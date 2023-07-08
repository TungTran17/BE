package com.testproject.swp.service;

import java.util.List;

import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.role.dto.RolesDTO;

public interface RoleService {

    public List<RolesDTO> getRoles() throws CustomNotFoundEx;

}
