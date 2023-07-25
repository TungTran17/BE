package com.testproject.swp.model.Cart;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CartsDto {
    private List<CartDto> cards;
    private String note;
    private int total;
    private int userId;
}
