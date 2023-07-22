package com.testproject.swp.model.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUsersDTO {
    private int userID;
    private String name;
    private int gender;
    //private String password;
    // private String token;
    private String address;
    private String email;
    private String phone;
    private int roleID;
    private int status;
    private String roleName;

}
