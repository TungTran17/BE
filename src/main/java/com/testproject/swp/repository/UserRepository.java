package com.testproject.swp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.testproject.swp.entity.User;
@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //public Optional<User> findOneByEmailAndPassword(String email, String user_password);
    public Optional<User> findByEmail(String email);
    public Optional<User> findByName(String name);
    
}
