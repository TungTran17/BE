package com.testproject.swp.service;

import java.util.List;
import java.util.Map;

import com.testproject.swp.entity.User;
import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.user.dto.GetUsersDTO;
import com.testproject.swp.model.user.dto.UserDTOCreate;
import com.testproject.swp.model.user.dto.UserDTOLoginRequest;
import com.testproject.swp.model.user.dto.UserDTOResponse;

public interface UserService {

        public User authenticate(Map<String, UserDTOLoginRequest> userDTOLoginRequestMap)
                        throws CustomBadReqEx, CustomNotFoundEx;

        public Map<String, UserDTOResponse> registerUser(Map<String, UserDTOCreate> userDTOCreateReqMap)
                        throws CustomNotFoundEx;

        public List<GetUsersDTO> getUserList() throws CustomNotFoundEx;

        public GetUsersDTO getUserByID(int id) throws CustomNotFoundEx;

        public List<GetUsersDTO> getUserByIdRole(int id) throws CustomNotFoundEx;

        public List<GetUsersDTO> getListUsersPage(String email, int idRole, int status, int indexPage, int sizePage)
                        throws CustomNotFoundEx;

        public int countListUsers(String email, int idRole, int status) throws CustomNotFoundEx;

        public GetUsersDTO updateUser(GetUsersDTO userDTOUpdate) throws CustomNotFoundEx;

        public GetUsersDTO deleteUser(int id) throws CustomNotFoundEx;

        public void activeUser(int id) throws CustomNotFoundEx;

}