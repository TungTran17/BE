package com.testproject.swp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "reservation_detail")
public class Reservation_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int reservation_detail_id;
    private int reservation_id;
    private int service_id;
    private double price;
    private int quantity;
    private int num_of_person;
    private int category_id;
    private int doctor_id;
    private int nurse_id;
    private Date begin_time;
    private int slot;
    private int children_id;
}