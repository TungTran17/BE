package com.testproject.swp.model.Cart;

import com.testproject.swp.entity.ReservationDetail;

public class CartMapper {

    public static ReservationDetail toGetReservationDetail(CartDto cartDto) {
        return ReservationDetail.builder()
                .reservationDetailID(cartDto.getCartId())
                .quantity(cartDto.getQuantity())
                .numOfPerson(cartDto.getNumOfPerson())
                .docterID(cartDto.getDoctor())
                .nurseID(cartDto.getNurse())
                .beginTime(cartDto.getBeginTime())
                .slot(cartDto.getSlot())
                .price(cartDto.getPrice())
                .build();
    }
}
