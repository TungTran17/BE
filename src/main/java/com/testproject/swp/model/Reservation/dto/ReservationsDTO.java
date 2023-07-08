package com.testproject.swp.model.Reservation.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReservationsDTO {

    private int reservationID;
    private double totalPrice;
    private String note;
    private int reservationStatus;
    private Date createdDate;
    
}
