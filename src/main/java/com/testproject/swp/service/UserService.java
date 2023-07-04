package com.testproject.swp.service;

import java.util.Map;

import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.dto.user.UserDTOCreate;
import com.testproject.swp.model.dto.user.UserDTOLoginRequest;
import com.testproject.swp.model.dto.user.UserDTOResponse;

public interface UserService {

    public Map<String, UserDTOResponse> authenticate(Map<String, UserDTOLoginRequest> userDTOLoginRequestMap)
            throws CustomBadReqEx, CustomNotFoundEx;

    public Map<String, UserDTOResponse> registerUser(Map<String, UserDTOCreate> userDTOCreateReqMap);

    public Map<String, UserDTOResponse> getCurrentUser() throws CustomNotFoundEx;

}