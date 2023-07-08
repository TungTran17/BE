package com.testproject.swp.model.Reservation.mapper;

import com.testproject.swp.entity.Reservation;
import com.testproject.swp.model.Reservation.dto.ReservationCreateDTO;
import com.testproject.swp.model.Reservation.dto.ReservationResponseDTO;
import com.testproject.swp.model.Reservation.dto.ReservationsDTO;

public class ReservationMapper {
    public static ReservationsDTO toGetReservation(Reservation reservation) {
        return ReservationsDTO.builder()
                .reservationID(reservation.getReservationID())
                .totalPrice(reservation.getTotalPrice())
                .note(reservation.getNote())
                .reservationStatus(reservation.getReservationStatus())
                .createdDate(reservation.getCreatedDate())
                .build();
    }

    public static ReservationResponseDTO toReservationDTOResponse(Reservation reservation) {
        return ReservationResponseDTO.builder()
                .totalPrice(reservation.getTotalPrice())
                .note(reservation.getNote())
                .reservationStatus(reservation.getReservationStatus())
                .createdDate(reservation.getCreatedDate())
                .build();
    }

    public static Reservation toReservationCreateReservation(ReservationCreateDTO createReservationDTO) {
        return Reservation.builder()
                .totalPrice(createReservationDTO.getTotalPrice())
                .note(createReservationDTO.getNote())
                .reservationStatus(createReservationDTO.getReservationStatus())
                .createdDate(createReservationDTO.getCreatedDate())
                .build();
    }

}
