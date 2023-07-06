package com.testproject.swp.service;

import java.util.List;
import java.util.Map;

import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.dto.user.GetUsersDTO;
import com.testproject.swp.model.dto.user.UserDTOCreate;
import com.testproject.swp.model.dto.user.UserDTOLoginRequest;
import com.testproject.swp.model.dto.user.UserDTOResponse;
import com.testproject.swp.model.dto.user.UserDTOUpdate;

public interface UserService {

    public Map<String, UserDTOResponse> authenticate(Map<String, UserDTOLoginRequest> userDTOLoginRequestMap)
            throws CustomBadReqEx, CustomNotFoundEx;

    public Map<String, UserDTOResponse> registerUser(Map<String, UserDTOCreate> userDTOCreateReqMap);

    public Map<String, UserDTOResponse> getCurrentUser() throws CustomNotFoundEx;

    public Map<String, GetUsersDTO> getProfile(String name) throws CustomNotFoundEx;

    public List<GetUsersDTO> getUserList() throws CustomNotFoundEx;

    public GetUsersDTO getUserByID(int id) throws CustomNotFoundEx;

    public GetUsersDTO updateUser(UserDTOUpdate userDTOUpdate) throws CustomNotFoundEx;

    public GetUsersDTO deleteUser(int id) throws CustomNotFoundEx;

    public Map<String, UserDTOResponse> updateCurrentUser(Map<String, UserDTOUpdate> userDTOUpdateMap) throws CustomNotFoundEx;

}