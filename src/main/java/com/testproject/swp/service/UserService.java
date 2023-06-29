package com.testproject.swp.service;

import java.util.List;
import java.util.Map;

import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.dto.UserDTO;
import com.testproject.swp.model.dto.UserDTOCreate;
import com.testproject.swp.model.dto.UserDTOLoginRequest;
import com.testproject.swp.model.dto.UserDTOResponse;
import com.testproject.swp.model.dto.UserDTOUpdate;

public interface UserService {

    public List<UserDTO> getAllUsers();

    public UserDTO getUserById(int user_id) throws CustomNotFoundEx;

    public UserDTO createUser(UserDTOCreate userDTOCreate) throws CustomBadReqEx;

    public UserDTO updateUser(UserDTOUpdate userDTOUpdate);

    public UserDTO deleteUser(int user_id) throws CustomNotFoundEx;

    public Map<String, UserDTOResponse> authenticate(Map<String, UserDTOLoginRequest> userLoginRequestMap);

}