package com.testproject.swp.model.ReservationDetails.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ReservationDetailDto {

    private int id;
    private int quantity;
    private int numOfPerson;
    private String docterName;
    private String nurseName;
    private Date beginTime;
    private int slot;
    private double price;
}
