package com.testproject.swp.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.testproject.swp.entity.User;
import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.dto.user.UserDTOLoginRequest;
import com.testproject.swp.model.dto.user.UserDTOResponse;
import com.testproject.swp.model.mapper.UserMapper;
import com.testproject.swp.repository.UserRepository;
import com.testproject.swp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;

    @Override
    public Map<String, UserDTOResponse> authenticate(Map<String, UserDTOLoginRequest> userDTOLoginRequestMap)
            throws CustomBadReqEx, CustomNotFoundEx {
        UserDTOLoginRequest userDTOLoginRequest = userDTOLoginRequestMap.get("user");

        Optional<User> userOptional = userRepository.findByEmail(userDTOLoginRequest.getUser_email());

        boolean isAuthen = false;
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getUser_password().equals(userDTOLoginRequest.getUser_password())) {
                isAuthen = true;
            }
        }
        if (!isAuthen) {
            System.out.println("User name and password is incorrect");
        }

        Map<String, UserDTOResponse> wrapper = new HashMap<>();
        UserDTOResponse userDTOResponse = UserMapper.toUserDTOResponse(userOptional.get());
        wrapper.put("user", userDTOResponse);
        return wrapper;
    }

}
