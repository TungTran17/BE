package com.testproject.swp.entity;

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
@Table(name = "children_tb")
public class Children {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int childrenID;
    private String childrenName;
    private int childrenGender;
    private int childrenAge;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;
}
