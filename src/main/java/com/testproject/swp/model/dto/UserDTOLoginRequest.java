package com.testproject.swp.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTOLoginRequest {
    private String user_email;
    private String user_password;
}
