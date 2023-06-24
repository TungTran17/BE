package com.testproject.swp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testproject.swp.entity.User;
import com.testproject.swp.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByid(int user_id) {
        return userRepository.findById(user_id);
    }

    public User updateUser(int user_id, User updateUser) {
        Optional<User> existingUser = userRepository.findById(user_id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUser_fullname(updateUser.getUser_fullname());
            user.setUser_email(updateUser.getUser_email());
            user.setUser_password(updateUser.getUser_password());
            user.setUser_address(updateUser.getUser_address());
            user.setUser_phone(updateUser.getUser_phone());
            user.setUser_gender(updateUser.getUser_gender());
            user.setRole_id(updateUser.getRole_id());
            user.setUser_image(updateUser.getUser_image());
            user.setUser_status(updateUser.getUser_status());
            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(int user_id) {
        Optional<User> existingUser = userRepository.findById(user_id);
        if (existingUser.isPresent()) {
            userRepository.delete(existingUser.get());
            return true;
        }
        return false;
    }

}
