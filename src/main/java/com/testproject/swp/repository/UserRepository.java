package com.testproject.swp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.testproject.swp.entity.User;
// @Component
@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //Optional<User> findOneByEmailAndPassword(String user_email, String user_password);
    public Optional<User> findByEmail(String user_email);
}
