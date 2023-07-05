package com.testproject.swp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.testproject.swp.entity.User;
import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.dto.user.GetUsersDTO;
import com.testproject.swp.model.dto.user.UserDTOCreate;
import com.testproject.swp.model.dto.user.UserDTOLoginRequest;
import com.testproject.swp.model.dto.user.UserDTOResponse;
import com.testproject.swp.model.dto.user.UserDTOUpdate;
import com.testproject.swp.model.mapper.CustomError;
import com.testproject.swp.model.mapper.UserMapper;
import com.testproject.swp.repository.UserRepository;
import com.testproject.swp.service.UserService;
import com.testproject.swp.util.JWTTokenUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JWTTokenUtil jwtTokenUtil;

    @Override
    public Map<String, UserDTOResponse> authenticate(Map<String, UserDTOLoginRequest> userLoginRequestMap)
            throws CustomBadReqEx, CustomNotFoundEx {
        UserDTOLoginRequest userDTOLoginRequest = userLoginRequestMap.get("user");

        Optional<User> userOptional = userRepository.findByEmail(userDTOLoginRequest.getEmail());
        if (!userOptional.isPresent()) {
            throw new CustomNotFoundEx(
                    CustomError.builder().code("404").message("Your email is not registered").build());
        }

        boolean isAuthen = false;
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(userDTOLoginRequest.getPassword(), user.getPassword())) {
                isAuthen = true;
                // System.out.println("Username and password correct");
            }
        }
        if (!isAuthen) {
            throw new CustomBadReqEx(
                    CustomError.builder().code("400").message("Email or password incorrect").build());
        }
        return buildDTOResponse(userOptional.get());
    }

    @Override
    public Map<String, UserDTOResponse> registerUser(Map<String, UserDTOCreate> userDTOCreateReqMap) {
        UserDTOCreate createUserDTOCreate = userDTOCreateReqMap.get("user");
        User user = UserMapper.toUserCreateUser(createUserDTOCreate);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return buildDTOResponse(user);
    }

    private Map<String, UserDTOResponse> buildDTOResponse(User user) {
        Map<String, UserDTOResponse> wrapper = new HashMap<>();
        UserDTOResponse userDTOResponse = UserMapper.toUserDTOResponse(user);
        userDTOResponse.setToken(jwtTokenUtil.generateToken(user, 24 * 60 * 60));
        wrapper.put("user", userDTOResponse);
        return wrapper;
    }

    @Override
    public Map<String, UserDTOResponse> getCurrentUser() throws CustomNotFoundEx {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userRepository.findByEmail(email).get();
            return buildDTOResponse(user);
        }
        throw new CustomNotFoundEx(CustomError.builder().code("404").message("User not exits").build());

    }

    @Override
    public Map<String, GetUsersDTO> getProfile(String name) throws CustomNotFoundEx {
        Optional<User> userOptional = userRepository.findByName(name);
        if (userOptional.isPresent()) {
            return buildProfileResponse(userOptional.get());
        } else {
            throw new CustomNotFoundEx(CustomError.builder().code("403").message("User not found").build());
        }
    }

    private Map<String, GetUsersDTO> buildProfileResponse(User user) {
        Map<String, GetUsersDTO> wrapper = new HashMap<>();
        GetUsersDTO getUsersDTO = GetUsersDTO.builder()
                .name(user.getName())
                .gender(user.getGender())
                .address(user.getAddress())
                .email(user.getEmail())
                .phone(user.getPhone())
                .roleID(user.getRoleID())
                .status(user.getStatus())
                .build();
        wrapper.put("profile", getUsersDTO);
        return wrapper;
    }

    @Override
    public List<GetUsersDTO> getUserList() throws CustomNotFoundEx {

        List<GetUsersDTO> userList = new ArrayList<>();
        List<User> users = userRepository.findAll();

        for (User user : users) {
            userList.add(UserMapper.toGetUser(user));
        }
        return userList;
    }

    @Override
    public GetUsersDTO getUserByID(int id) throws CustomNotFoundEx {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return UserMapper.toGetUser(userOptional.get());
        } else {
            throw new CustomNotFoundEx(CustomError.builder().code("404").message("User not found").build());
        }

    }

    @Override
    public GetUsersDTO updateUser(UserDTOUpdate userDTOUpdate) throws CustomNotFoundEx {
        User user = UserMapper.toUserUpdateUser(userDTOUpdate);
        user = userRepository.save(user);
        return UserMapper.toGetUser(user);
    }

    @Override
    public GetUsersDTO deleteUser(int id) throws CustomNotFoundEx {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return UserMapper.toGetUser(userOptional.get());
        } else {
            throw new CustomNotFoundEx(CustomError.builder().code("404").message("User not found").build());
        }
    }

}
