package com.testproject.swp.model.Reservation.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class ReservationResponseDTO {
    private double totalPrice;
    private String note;
    private int reservationStatus;
    private Date createdDate;
}
