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
@Table(name = "service_status")
public class Service_status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    private int status_id;
    private int service_id;
    private int service_status;
}