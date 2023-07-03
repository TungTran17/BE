package com.testproject.swp.model.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTOUpdate {
    private int user_id;
    private String user_fullname;
    private int user_gender;
    private String user_address;
    private String user_password;
    private String user_email;
    private String user_phone;
    private int role_id;
    private int user_status;
    private String user_image;
}
