package com.testproject.swp.model.user.mapper;

import com.testproject.swp.entity.Role;
import com.testproject.swp.entity.User;
import com.testproject.swp.model.user.dto.GetUsersDTO;
import com.testproject.swp.model.user.dto.UserDTO;
import com.testproject.swp.model.user.dto.UserDTOCreate;
import com.testproject.swp.model.user.dto.UserDTOResponse;
import com.testproject.swp.model.user.dto.UserDTOUpdate;

import java.util.stream.Collectors;


public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .userID(user.getUserID())
                .name(user.getName())
                .gender(user.getGender())
                .address(user.getAddress())
                .email(user.getEmail())
                .phone(user.getPhone())
                //.roleID(user.getRoleID())
                //.status(user.getStatus())
                .build();
    }

    public static User toUserCreateUser(UserDTOCreate userDTOCreate) {
        return User.builder()
                .password(userDTOCreate.getPassword())
                .name(userDTOCreate.getName())
                .gender(userDTOCreate.getGender())
                .token(userDTOCreate.getToken())
                .address(userDTOCreate.getAddress())
                .email(userDTOCreate.getEmail())
                .phone(userDTOCreate.getPhone())
                //.roleID(userDTOCreate.getRoleID())
                //.status(userDTOCreate.getStatus())
                .build();
    }

    public static User toUserUpdateUser(UserDTOUpdate userDTOUpdate) {
        return User.builder()
                .password(userDTOUpdate.getPassword())
                .userID(userDTOUpdate.getUserID())
                .name(userDTOUpdate.getName())
                .gender(userDTOUpdate.getGender())
                .address(userDTOUpdate.getAddress())
                .email(userDTOUpdate.getEmail())
                .phone(userDTOUpdate.getPhone())
                .roleID(userDTOUpdate.getRoleID())
                .status(userDTOUpdate.getStatus())
                .build();
    }

    public static User toUserUpdateUser(User user, UserDTOUpdate userDTOUpdate) {
        return User.builder()
                .password(userDTOUpdate.getPassword())
                .userID(userDTOUpdate.getUserID())
                .name(userDTOUpdate.getName())
                .gender(userDTOUpdate.getGender())
                .address(userDTOUpdate.getAddress())
                .email(userDTOUpdate.getEmail())
                .phone(userDTOUpdate.getPhone())
                .roleID(userDTOUpdate.getRoleID())
                .status(userDTOUpdate.getStatus())
                .build();
    }

    public static GetUsersDTO toGetUser(User user) {
        String roleName = String.join(", ", user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList()));

        return GetUsersDTO.builder()
                //.password(user.getPassword())
                .userID(user.getUserID())
                .name(user.getName())
                .gender(user.getGender())
                .address(user.getAddress())
                .email(user.getEmail())
                .status(user.getStatus())
                .roleID(user.getRoles().get(0).getRoleID())
                .phone(user.getPhone())
                .roleName(roleName)
                // .roleID(user.getRoleID())
                // .status(user.getStatus())
                .build();
    }

    public static UserDTOResponse toUserDTOResponse(User user) {
        return UserDTOResponse.builder()
                .name(user.getName())
                .gender(user.getGender())
                //.token(user.getToken())
                .address(user.getAddress())
                .email(user.getEmail())
                .phone(user.getPhone())
                //.roleID(user.getRoleID())
                //.status(user.getStatus())
                .build();
    }
}
