package com.testproject.swp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "category")
public class MyServiceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "category_id")
    private int categoryid;

    @Column(name = "category_name")
    private String categoryname;

    @Column(name = "icon")
    private String icon;

}
