package com.testproject.swp.model.ReservationDetails.mapper;

import com.testproject.swp.entity.ReservationDetail;
import com.testproject.swp.model.ReservationDetails.dto.ReservationDetailDto;
import com.testproject.swp.repository.UserRepository;

public class ReservationDetailMapper {

    public static ReservationDetailDto toGetReservationDetail(ReservationDetail reservationDetail,
            UserRepository userRepository) {
        return ReservationDetailDto.builder()
                .id(reservationDetail.getReservationDetailID())
                .quantity(reservationDetail.getQuantity())
                .numOfPerson(reservationDetail.getNumOfPerson())
                .docterName(userRepository.findById(reservationDetail.getDocterID()).get().getName())
                .nurseName(userRepository.findById(reservationDetail.getNurseID()).get().getName())
                .beginTime(reservationDetail.getBeginTime())
                .slot(reservationDetail.getSlot())
                .price(reservationDetail.getPrice())
                .build();
    }
}
