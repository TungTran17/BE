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
@Table(name = "reservation_medical")
public class Reservation_medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int medical_id;
    private int reservation_detail_id;
    private String diagnosis;
    private Date created_date;
    private int doctor_id;
}
