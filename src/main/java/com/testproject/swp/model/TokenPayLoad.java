package com.testproject.swp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenPayLoad {
    private int userID;
    private String email;
}
