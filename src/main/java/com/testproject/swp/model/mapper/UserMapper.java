package com.testproject.swp.model.mapper;

import com.testproject.swp.entity.User;
import com.testproject.swp.model.dto.user.UserDTO;
import com.testproject.swp.model.dto.user.UserDTOCreate;
import com.testproject.swp.model.dto.user.UserDTOResponse;
import com.testproject.swp.model.dto.user.UserDTOUpdate;

public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .user_id(user.getUser_id())
                .user_fullname(user.getUser_fullname())
                .user_gender(user.getUser_gender())
                .user_address(user.getUser_address())
                .email(user.getEmail())
                .user_phone(user.getUser_phone())
                .role_id(user.getRole_id())
                .user_image(user.getUser_image())
                .user_status(user.getUser_status())
                .build();
    }

    public static User toUser(UserDTOCreate userDTOCreate) {
        return User.builder()
                .user_password(userDTOCreate.getUser_password())
                .user_fullname(userDTOCreate.getUser_fullname())
                .user_gender(userDTOCreate.getUser_gender())
                .token(userDTOCreate.getToken())
                .user_address(userDTOCreate.getUser_address())
                .email(userDTOCreate.getEmail())
                .user_phone(userDTOCreate.getUser_phone())
                .role_id(userDTOCreate.getRole_id())
                .user_image(userDTOCreate.getUser_image())
                .user_status(userDTOCreate.getUser_status())
                .build();
    }

    public static User toUser(UserDTOUpdate userDTOUpdate) {
        return User.builder()
                .user_id(userDTOUpdate.getUser_id())
                .user_password(userDTOUpdate.getUser_password())
                .user_fullname(userDTOUpdate.getUser_fullname())
                .user_gender(userDTOUpdate.getUser_gender())
                .user_address(userDTOUpdate.getUser_address())
                .email(userDTOUpdate.getEmail())
                .user_phone(userDTOUpdate.getUser_phone())
                .role_id(userDTOUpdate.getRole_id())
                .user_image(userDTOUpdate.getUser_image())
                .user_status(userDTOUpdate.getUser_status())
                .build();
    }

    public static UserDTOResponse toUserDTOResponse(User user) {
        return UserDTOResponse.builder()
                .user_fullname(user.getUser_fullname())
                .user_gender(user.getUser_gender())
                .token(user.getToken())
                .user_address(user.getUser_address())
                .email(user.getEmail())
                .user_phone(user.getUser_phone())
                .role_id(user.getRole_id())
                .user_image(user.getUser_image())
                .user_status(user.getUser_status())
                .build();
    }
}
