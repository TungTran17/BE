package com.testproject.swp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int user_id;
    private String user_fullname;
    private int user_gender;
    private String token;
    private String user_address;
    private String user_password;
    @Column(unique = true)
    private String user_email;
    private String user_phone;
    private int role_id;
    private int user_status;
    private String user_image;

}
