package com.testproject.swp.model.mapper;

import com.testproject.swp.entity.User;
import com.testproject.swp.model.dto.user.UserDTO;
import com.testproject.swp.model.dto.user.UserDTOCreate;
import com.testproject.swp.model.dto.user.UserDTOResponse;
import com.testproject.swp.model.dto.user.UserDTOUpdate;

public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .userID(user.getUserID())
                .name(user.getName())
                .gender(user.getGender())
                .address(user.getAddress())
                .email(user.getEmail())
                .phone(user.getPhone())
                .roleID(user.getRoleID())
                .status(user.getStatus())
                .build();
    }

    public static User toUser(UserDTOCreate userDTOCreate) {
        return User.builder()
                .password(userDTOCreate.getPassword())
                .name(userDTOCreate.getName())
                .gender(userDTOCreate.getGender())
                .token(userDTOCreate.getToken())
                .address(userDTOCreate.getAddress())
                .email(userDTOCreate.getEmail())
                .phone(userDTOCreate.getPhone())
                .roleID(userDTOCreate.getRoleID())
                .status(userDTOCreate.getStatus())
                .build();
    }

    public static User toUser(UserDTOUpdate userDTOUpdate) {
        return User.builder()
                // .user_password(userDTOUpdate.getUser_password())
                .name(userDTOUpdate.getName())
                .gender(userDTOUpdate.getGender())
                .address(userDTOUpdate.getAddress())
                .email(userDTOUpdate.getEmail())
                .phone(userDTOUpdate.getPhone())
                .roleID(userDTOUpdate.getRoleID())
                .status(userDTOUpdate.getStatus())
                .build();
    }

    public static UserDTOResponse toUserDTOResponse(User user) {
        return UserDTOResponse.builder()
                .name(user.getName())
                .gender(user.getGender())
                .token(user.getToken())
                .address(user.getAddress())
                .email(user.getEmail())
                .phone(user.getPhone())
                .roleID(user.getRoleID())
                .status(user.getStatus())
                .build();
    }
}
