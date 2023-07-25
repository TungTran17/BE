package com.testproject.swp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ReservationDetail_tb")
public class ReservationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationDetailID;
    private int quantity;
    private int numOfPerson;

    private int docterID;
    private int nurseID;
    private Date beginTime;
    private int slot;
    private double price;

    @ManyToOne
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;
}
