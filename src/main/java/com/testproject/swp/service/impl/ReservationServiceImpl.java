package com.testproject.swp.service.impl;

import java.util.*;

import com.testproject.swp.entity.ReservationDetail;
import com.testproject.swp.model.Cart.CartDto;
import com.testproject.swp.model.Cart.CartMapper;
import com.testproject.swp.model.Cart.CartsDto;
import com.testproject.swp.model.ReservationDetails.dto.ReservationDetailDto;
import com.testproject.swp.model.ReservationDetails.mapper.ReservationDetailMapper;
import com.testproject.swp.repository.ReservationDetailRepository;
import com.testproject.swp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.testproject.swp.entity.Reservation;
import com.testproject.swp.entity.User;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.Reservation.dto.ReservationCreateDTO;
import com.testproject.swp.model.Reservation.dto.ReservationResponseDTO;
import com.testproject.swp.model.Reservation.dto.ReservationUpdateDTO;
import com.testproject.swp.model.Reservation.dto.ReservationsDTO;
import com.testproject.swp.model.Reservation.mapper.ReservationMapper;
import com.testproject.swp.model.customer.CustomError;
import com.testproject.swp.repository.ReservationRepository;
import com.testproject.swp.service.ReservationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationDetailRepository reservationDetailRepository;
    private final UserRepository userRepository;

    @Override
    public List<ReservationsDTO> getAllReservations() {

        List<ReservationsDTO> reservationList = new ArrayList<>();
        List<Reservation> reservations = reservationRepository.findAll();

        for (Reservation reservation : reservations) {
            reservationList.add(ReservationMapper.toGetReservation(reservation));
        }
        return reservationList;
    }

    @Override
    public ReservationsDTO getReservationById(int id) throws CustomNotFoundEx {

        Optional<Reservation> reservationOptional = reservationRepository.findById(id);

        if (reservationOptional.isPresent()) {
            return ReservationMapper.toGetReservation(reservationOptional.get());
        } else {
            throw new CustomNotFoundEx(CustomError.builder().code("404").message("Not found Reservation").build());
        }

    }

    @Override
    public Map<String, ReservationResponseDTO> addReservation(
            Map<String, ReservationCreateDTO> reservationDTOCreateReqMap) {
        ReservationCreateDTO createReservationDTO = reservationDTOCreateReqMap.get("reservation");
        Reservation reservation = ReservationMapper.toReservationCreateReservation(createReservationDTO);
        reservation = reservationRepository.save(reservation);
        return buildDTOResponse(reservation);
    }

    private Map<String, ReservationResponseDTO> buildDTOResponse(Reservation reservation) {
        Map<String, ReservationResponseDTO> wrapper = new HashMap<>();
        ReservationResponseDTO reservationResponseDTO = ReservationMapper.toReservationDTOResponse(reservation);
        wrapper.put("reservation", reservationResponseDTO);
        return wrapper;
    }

    @Override
    public ReservationsDTO updateReservation(ReservationUpdateDTO reservationUpdateDTO) throws CustomNotFoundEx {

        Reservation reservation = ReservationMapper.toReservationUpdateReservation(reservationUpdateDTO);
        reservation = reservationRepository.save(reservation);
        return ReservationMapper.toGetReservation(reservation);

    }

    @Override
    public ReservationsDTO deleteReservation(@PathVariable int id) throws CustomNotFoundEx {

        Optional<Reservation> reservationOptional = reservationRepository.findById(id);

        if (reservationOptional.isPresent()) {
            reservationRepository.deleteById(id);
            return ReservationMapper.toGetReservation(reservationOptional.get());
        } else {
            throw new CustomNotFoundEx(CustomError.builder().code("404").message("User not found").build());
        }
    }

    @Override
    public int checkReservationDetail(CartDto cartDto) {
        ReservationDetail reservationDetail = CartMapper.toGetReservationDetail(cartDto);
        return reservationDetailRepository.checkReservationDetail(reservationDetail.getBeginTime(),
                reservationDetail.getDocterID(), reservationDetail.getNurseID(), reservationDetail.getSlot());
    }

    @Override
    public int add(CartsDto cartsDto) {
        Reservation reservation = new Reservation();
        reservation.setNote(cartsDto.getNote());
        reservation.setReservationStatus(0);
        Date thoiGianHienTai = new Date();
        reservation.setCreatedDate(thoiGianHienTai);
        Optional<User> user = userRepository.findById(cartsDto.getUserId());
        reservation.setUser(user.get());
        reservation.setTotalPrice(cartsDto.getTotal());
        reservation = reservationRepository.save(reservation);
        for (CartDto cartDto : cartsDto.getCards()) {
            ReservationDetail reservationDetail = CartMapper.toGetReservationDetail(cartDto);

            reservationDetail.setReservationDetailID(0);
            reservationDetail.setReservation(reservation);
            reservationDetail.setUser(user.get());
            reservationDetailRepository.save(reservationDetail);
        }
        return 1;
    }

    @Override
    public List<ReservationDetailDto> getReservationDetailByReservationId(int reservationId) throws CustomNotFoundEx {
        List<ReservationDetail> list = reservationDetailRepository.getReservationDetailByReservationIs(reservationId);
        List<ReservationDetailDto> reservationDetailDtos = new ArrayList<>();
        for (ReservationDetail reservationDetail : list) {
            reservationDetailDtos
                    .add(ReservationDetailMapper.toGetReservationDetail(reservationDetail, userRepository));
        }
        return reservationDetailDtos;
    }

}
