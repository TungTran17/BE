package com.testproject.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testproject.swp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
