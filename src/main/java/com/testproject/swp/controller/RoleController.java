package com.testproject.swp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.role.dto.RolesDTO;
import com.testproject.swp.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/ccg1")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/roles")
    public List<RolesDTO> getRoles() throws CustomNotFoundEx{
        return roleService.getRoles();
    }
}
