package com.testproject.swp.model.dto.user;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String user_fullname;
    private int user_gender;
    private String user_address;
    private String token;
    private String email;
    private String user_phone;
    private int role_id;
    private int user_status;
    private String user_image;
}
