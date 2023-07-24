package com.testproject.swp.model.Cart;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class CartDto {
    private int cartId;
    private int doctor;
    private int numOfPerson;
    private int nurse;
    private double price;
    private double priceService;
    private int quantity;
    private int serviceId;
    private int slot;
    private String title;
    private int userId;
    private Date beginTime;
}
