package com.testproject.swp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.Reservation.dto.ReservationCreateDTO;
import com.testproject.swp.model.Reservation.dto.ReservationResponseDTO;
import com.testproject.swp.model.Reservation.dto.ReservationsDTO;
import com.testproject.swp.service.ReservationService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/ccg1")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public List<ReservationsDTO> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservation/{id}")
    public ReservationsDTO getReservationById(@PathVariable int id) throws CustomNotFoundEx {
        return reservationService.getReservationById(id);
    }

    @PostMapping("/addReservation")
    public Map<String, ReservationResponseDTO> addReservation(@RequestBody Map<String, ReservationCreateDTO>  reservationCreateDTOMap) {
        return reservationService.addReservation(reservationCreateDTOMap);
    }
}
