package com.testproject.swp.model.mapper;

import com.testproject.swp.entity.User;
import com.testproject.swp.model.dto.UserDTO;
import com.testproject.swp.model.dto.UserDTOCreate;
import com.testproject.swp.model.dto.UserDTOResponse;
import com.testproject.swp.model.dto.UserDTOUpdate;

public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .user_id(user.getUser_id())
                .user_fullname(user.getUser_fullname())
                .user_gender(user.getUser_gender())
                .user_address(user.getUser_address())
                .user_email(user.getUser_email())
                .user_phone(user.getUser_phone())
                .role_id(user.getRole_id())
                .user_image(user.getUser_image())
                .user_status(user.getUser_status())
                .build();
    }

    public static User toUser(UserDTOCreate userDTO) {
        return User.builder()
                .user_password(userDTO.getUser_password())
                .user_fullname(userDTO.getUser_fullname())
                .user_gender(userDTO.getUser_gender())
                .user_address(userDTO.getUser_address())
                .user_email(userDTO.getUser_email())
                .user_phone(userDTO.getUser_phone())
                .role_id(userDTO.getRole_id())
                .user_image(userDTO.getUser_image())
                .user_status(userDTO.getUser_status())
                .build();
    }

    public static User toUser(UserDTOUpdate userDTOUpdate) {
        return User.builder()
                .user_id(userDTOUpdate.getUser_id())
                .user_password(userDTOUpdate.getUser_password())
                .user_fullname(userDTOUpdate.getUser_fullname())
                .user_gender(userDTOUpdate.getUser_gender())
                .user_address(userDTOUpdate.getUser_address())
                .user_email(userDTOUpdate.getUser_email())
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
                .user_address(user.getUser_address())
                .user_email(user.getUser_email())
                .user_phone(user.getUser_phone())
                .role_id(user.getRole_id())
                .user_image(user.getUser_image())
                .user_status(user.getUser_status())
                .build();
    }
}
