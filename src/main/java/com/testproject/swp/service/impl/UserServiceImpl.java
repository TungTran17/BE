package com.testproject.swp.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.testproject.swp.entity.User;
import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.dto.user.UserDTOLoginRequest;
import com.testproject.swp.model.dto.user.UserDTOResponse;
import com.testproject.swp.model.mapper.CustomError;
import com.testproject.swp.model.mapper.UserMapper;
import com.testproject.swp.repository.UserRepository;
import com.testproject.swp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    
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
            if (user.getUser_password().equals(userDTOLoginRequest.getUser_password())) {
                isAuthen = true;
                System.out.println("Username and password correct");
            }
        }
        if (!isAuthen) {
            throw new CustomBadReqEx(
                    CustomError.builder().code("400").message("Email or password incorrect").build());
            //System.out.println("Username and password incorrect");
        }
        Map<String, UserDTOResponse> wrapper = new HashMap<>();
        UserDTOResponse userDTOResponse = UserMapper.toUserDTOResponse(userOptional.get());
        wrapper.put("user", userDTOResponse);
        return wrapper;
    }
}
