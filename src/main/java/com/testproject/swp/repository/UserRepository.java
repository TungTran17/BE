package com.testproject.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testproject.swp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
