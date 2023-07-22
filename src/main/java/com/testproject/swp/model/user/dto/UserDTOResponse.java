package com.testproject.swp.model.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOResponse {
    private String name;
    private int gender;
    private String token;
    private String address;
    private String email;
    private String phone;

    //private int roleID;
    //private int status;
}