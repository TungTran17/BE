package com.testproject.swp.model.mapper;

import com.testproject.swp.entity.Role;
import com.testproject.swp.model.dto.role.RolesDTO;

public class RoleMapper {

    public static RolesDTO toRoleList(Role role) {
        return RolesDTO.builder()
                .roleID(role.getRoleID())
                .roleName(role.getRoleName())
                .build();
    }
}
