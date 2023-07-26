package com.testproject.swp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "service_status")
public class MyServiceStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int statusid;

    @Column(unique = true, name = "service_id")
    private int serviceid;

    @Column(name = "service_status")
    private int servicestatus;
}
