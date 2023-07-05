package com.testproject.swp.model.dto.user;

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
    private int roleID;
    private int status;
}