package com.testproject.swp.model.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTOCreate {
    private String name;
    private int gender;
    private String token;
    private String address;
    private String password;
    private String email;
    private String phone;
    //private int roleID;
    //private int status;
}
