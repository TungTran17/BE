package com.testproject.swp.model.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTOUpdate {

    private String name;
    private int gender;
    //private String token;
    private String address;
    // private String userPassword;
    private String email;
    private String phone;
    private int roleID;
    private int status;
}
