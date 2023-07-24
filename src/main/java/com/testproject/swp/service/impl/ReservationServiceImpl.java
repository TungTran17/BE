package com.testproject.swp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.testproject.swp.entity.ReservationDetail;
import com.testproject.swp.repository.ReservationDetailRepository;
import org.springframework.http.ResponseEntity;
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
import com.testproject.swp.model.user.mapper.UserMapper;
import com.testproject.swp.repository.ReservationRepository;
import com.testproject.swp.service.ReservationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationDetailRepository reservationDetailRepository;

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
    public int checkReservationDetail(ReservationDetail reservationDetail) {

        return reservationDetailRepository.checkReservationDetail(reservationDetail.getBeginTime(),reservationDetail.getDocterID(), reservationDetail.getNurseID(), reservationDetail.getSlot());
    }

}
