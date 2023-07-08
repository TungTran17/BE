package com.testproject.swp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testproject.swp.entity.Role;
import com.testproject.swp.model.dto.role.RolesDTO;
import com.testproject.swp.model.mapper.RoleMapper;
import com.testproject.swp.repository.RoleRepository;
import com.testproject.swp.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<RolesDTO> getRoles() {
        List<RolesDTO> roleList = new ArrayList<>();
        List<Role> roles = roleRepository.findAll();

        for (Role role : roles) {
            roleList.add(RoleMapper.toRoleList(role));
        }
        return roleList;
    }

}
