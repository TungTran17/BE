package com.testproject.swp.model.Reservation.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ReservationsDTO {

    private int reservationID;
    private double totalPrice;
    private String note;
    private int reservationStatus;
    private Date createdDate;
    private String userGuess;

}
