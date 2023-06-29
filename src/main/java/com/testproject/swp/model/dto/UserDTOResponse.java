package com.testproject.swp.model.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTOResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //private int user_id;
    private String user_fullname;
    private int user_gender;
    private String user_address;
    //private String user_password;
    private String user_email;
    private String user_phone;
    private int role_id;
    private int user_status;
    private String user_image;
    private String user_token;
}
