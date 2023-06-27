package com.testproject.swp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.testproject.swp.entity.User;
import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.dto.UserDTO;
import com.testproject.swp.model.dto.UserDTOCreate;
import com.testproject.swp.model.dto.UserDTOUpdate;
import com.testproject.swp.model.mapper.CustomError;
import com.testproject.swp.model.mapper.UserMapper;
import com.testproject.swp.repository.UserRepository;
import com.testproject.swp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOs = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            userDTOs.add(UserMapper.toUserDTO(user));
        }
        return userDTOs;
    }

    @Override
    public UserDTO getUserById(int user_id) throws CustomNotFoundEx {
        Optional<User> userOptional = userRepository.findById(user_id);
        if (userOptional.isPresent()) {
            return UserMapper.toUserDTO(userOptional.get());
        }
        throw new CustomNotFoundEx(CustomError.builder().code("404").message("getUserById - Not found user").build());

    }

    @Override
    public UserDTO createUser(UserDTOCreate userDTOCreate) throws CustomBadReqEx {
        if (userDTOCreate.getUser_email().equals("")) {
            throw new CustomBadReqEx(CustomError.builder().code("400").message("Email is blank").build());
        }
        User user = UserMapper.toUser(userDTOCreate);
        user = userRepository.save(user);
        return UserMapper.toUserDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTOUpdate userDTOUpdate) {
        User user = UserMapper.toUser(userDTOUpdate);
        user = userRepository.save(user);
        return UserMapper.toUserDTO(user);
    }

    @Override
    public UserDTO deleteUser(int user_id) throws CustomNotFoundEx {
        Optional<User> userOptional = userRepository.findById(user_id);
        if (userOptional.isEmpty()) {
            throw new CustomNotFoundEx(CustomError.builder().code("404").message("Not found user").build());
        }
        userRepository.deleteById(user_id);
        return UserMapper.toUserDTO(userOptional.get());
    }

}
