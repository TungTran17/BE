package com.testproject.swp.entity;

import javax.persistence.*;

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
@Table(name = "children")
public class Children {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "children_id")
    private int childrenID;

    @Column(name = "children_name")
    private String childrenName;
    @Column(name = "children_gender")
    private int childrenGender;
    @Column(name = "children_age")
    private int childrenAge;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
