package com.testproject.swp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int service_id;
    private String service_title;
    private String service_bi;
    private String service_created_date;
    private int category_id;
    private double service_price;
    private double service_discount;
    private String service_detail;
    private int service_rateStar;
    private int service_vote;

}
