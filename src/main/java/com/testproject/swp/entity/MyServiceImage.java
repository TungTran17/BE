package com.testproject.swp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "service_image")
public class MyServiceImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "image_id")
    private int imageid;

    @Column(unique = true, name = "service_id")
    private String serviceid;

    @Column(name = "image_link", columnDefinition = "TEXT")
    private String imagelink;
}
