package com.testproject.swp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.dto.UserDTO;
import com.testproject.swp.model.dto.UserDTOCreate;
import com.testproject.swp.model.dto.UserDTOUpdate;
import com.testproject.swp.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    public UserDTO getUserById(@PathVariable int user_id) throws CustomNotFoundEx {
        return userService.getUserById(user_id);
    }

    @PostMapping("")
    public UserDTO createUser(@RequestBody UserDTOCreate userDTOCreate) throws CustomBadReqEx {
        return userService.createUser(userDTOCreate);
    }

    @PutMapping("/{user_id}")
    public UserDTO updateUser(@PathVariable int user_id, @RequestBody UserDTOUpdate userDTOUpdate) {
        userDTOUpdate.setUser_id(user_id);
        return userService.updateUser(userDTOUpdate);
    }

    @DeleteMapping("/{user_id}")
    public UserDTO deleteUser(@PathVariable int user_id) throws CustomNotFoundEx {
        return userService.deleteUser(user_id);

    }

}
