package com.testproject.swp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.testproject.swp.entity.Reservation;
import com.testproject.swp.entity.ReservationDetail;
import com.testproject.swp.entity.Role;
import com.testproject.swp.repository.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.testproject.swp.entity.User;
import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.customer.CustomError;
import com.testproject.swp.model.user.dto.GetUsersDTO;
import com.testproject.swp.model.user.dto.LoginMesage;
import com.testproject.swp.model.user.dto.UserDTOCreate;
import com.testproject.swp.model.user.dto.UserDTOLoginRequest;
import com.testproject.swp.model.user.dto.UserDTOResponse;
import com.testproject.swp.model.user.dto.UserDTOUpdate;
import com.testproject.swp.model.user.mapper.UserMapper;
import com.testproject.swp.payload.LoginMessage;
import com.testproject.swp.repository.UserRepository;
import com.testproject.swp.service.UserService;
import com.testproject.swp.util.JWTTokenUtil;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private  final RoleRepository repository;
    private final JWTTokenUtil jwtTokenUtil;

    @Override
    public Map<String, UserDTOResponse> authenticate(Map<String, UserDTOLoginRequest> userLoginRequestMap)
            throws CustomBadReqEx, CustomNotFoundEx {
        UserDTOLoginRequest userDTOLoginRequest = userLoginRequestMap.get("user");

        Optional<User> userOptional = userRepository.findByEmail(userDTOLoginRequest.getEmail());
        if (!userOptional.isPresent()) {
            throw new CustomNotFoundEx(
                    CustomError.builder().code("404").message("Your email is not registered").build());
        }

        boolean isAuthen = false;
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(userDTOLoginRequest.getPassword(),
                    user.getPassword())) {
                isAuthen = true;
                // System.out.println("Username and password correct");
            }
        }
        if (!isAuthen) {
            throw new CustomBadReqEx(
                    CustomError.builder().code("400").message("Email or password incorrect").build());
        }
        return buildDTOResponse(userOptional.get());
    }

    // @Override
    // public Map<String, UserDTOResponse> registerUser(Map<String, UserDTOCreate>
    // userDTOCreateReqMap)
    // throws CustomNotFoundEx {
    // UserDTOCreate createUserDTOCreate = userDTOCreateReqMap.get("user");
    // User user = UserMapper.toUserCreateUser(createUserDTOCreate);
    // user.setPassword(passwordEncoder.encode(user.getPassword()));
    // user = userRepository.save(user);
    // return buildDTOResponse(user);
    // }

    @Transactional
    @Override
    public Map<String, UserDTOResponse> registerUser(Map<String, UserDTOCreate> userDTOCreateReqMap) {
        UserDTOCreate createUserDTOCreate = userDTOCreateReqMap.get("user");
        User user = UserMapper.toUserCreateUser(createUserDTOCreate);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<>();
        Role role = repository.findById(1).get();
        roles.add(role);
        user.setRoles(roles);
        try {
            user =  userRepository.save(user);
        }catch (Exception e){
            System.out.println("Lỗi" + e.getMessage());
        }

        return buildDTOResponse(user);
//        try {
//            user = userRepository.save(user);
//        }catch (Exception e){
//
//        }
//
//        Optional<User> userOptional = userRepository.findById(user.getUserID());
//                List<Role> roles = new ArrayList<>();
//        Role role = repository.findById(1).get();
//        roles.add(role);
////        userOptional.get().getRoles().a;
//        user = userRepository.save( userOptional.get());
//        return buildDTOResponse(user);
    }

    private Map<String, UserDTOResponse> buildDTOResponse(User user) {
        Map<String, UserDTOResponse> wrapper = new HashMap<>();
        UserDTOResponse userDTOResponse = UserMapper.toUserDTOResponse(user);
        userDTOResponse.setToken(jwtTokenUtil.generateToken(user, 24 * 60 * 60));
        wrapper.put("user", userDTOResponse);
        return wrapper;
    }

    // @Override
    // public Map<String, UserDTOResponse> getCurrentUser() throws CustomNotFoundEx
    // {
    // Object principal =
    // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    // if (principal instanceof UserDetails) {
    // String email = ((UserDetails) principal).getUsername();
    // User user = userRepository.findByEmail(email).get();
    // return buildDTOResponse(user);
    // }
    // throw new CustomNotFoundEx(CustomError.builder().code("404").message("User
    // not exits").build());

    // }

    // @Override
    // public Map<String, GetUsersDTO> getProfile(String name) throws
    // CustomNotFoundEx {
    // Optional<User> userOptional = userRepository.findByName(name);
    // if (userOptional.isPresent()) {
    // return buildProfileResponse(userOptional.get());
    // } else {
    // throw new CustomNotFoundEx(CustomError.builder().code("403").message("User
    // not found").build());
    // }
    // }

    // @Override
    // public Map<String, UserDTOResponse> updateCurrentUser(Map<String,
    // UserDTOUpdate> userDTOUpdateMap)
    // throws CustomNotFoundEx {
    // System.out.println("dsd");
    // User user = getUserLoggedIn();
    // UserDTOUpdate userDTOUpdate = userDTOUpdateMap.get("user");
    // if (user != null) {
    // UserMapper.toUserUpdateUser(user, userDTOUpdate);
    // user = userRepository.save(user);
    // return buildDTOResponse(user);
    // }
    // throw new CustomNotFoundEx(CustomError.builder().code("404").message("User
    // not found").build());
    // }

    // public User getUserLoggedIn() {
    // Object principal =
    // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    // if (principal instanceof UserDetails) {
    // String email = ((UserDetails) principal).getUsername();
    // User user = userRepository.findByEmail(email).get();
    // System.out.println(user);
    // return user;
    // }
    // System.out.println("đwdwd");
    // return null;
    // }

    // private Map<String, GetUsersDTO> buildProfileResponse(User user) {
    // Map<String, GetUsersDTO> wrapper = new HashMap<>();
    // GetUsersDTO getUsersDTO = GetUsersDTO.builder()
    // .name(user.getName())
    // .gender(user.getGender())
    // .address(user.getAddress())
    // .email(user.getEmail())
    // .phone(user.getPhone())
    // .roleID(user.getRoleID())
    // .status(user.getStatus())
    // .build();
    // wrapper.put("profile", getUsersDTO);
    // return wrapper;
    // }

    @Override
    public List<GetUsersDTO> getUserList() throws CustomNotFoundEx {

        List<GetUsersDTO> userList = new ArrayList<>();
        List<User> users = userRepository.findAll();

        for (User user : users) {
            userList.add(UserMapper.toGetUser(user));
        }
        return userList;
    }

    @Override
    public GetUsersDTO getUserByID(int id) throws CustomNotFoundEx {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return UserMapper.toGetUser(userOptional.get());
        } else {
            throw new CustomNotFoundEx(CustomError.builder().code("404").message("User not found").build());
        }

    }

    @Override
    public List<GetUsersDTO> getUserByIdRole(int id) throws CustomNotFoundEx {
        List<User> userOptional = userRepository.findByRole(id);
        if (userOptional != null ) {
            List<GetUsersDTO> list = new ArrayList<>();
            for (User user: userOptional) {
                list.add(UserMapper.toGetUser(user));
            }
            return list;
        } else {
            throw new CustomNotFoundEx(CustomError.builder().code("404").message("User not found").build());
        }
    }

    @Override
    public  List<GetUsersDTO> getListUsersPage(String email, int idRole, int status, int indexPage, int sizePage) throws CustomNotFoundEx {
        Pageable pageable = PageRequest.of(indexPage - 1, sizePage, Sort.by("userID").ascending());
        Page<User> page = userRepository.getListUsersPage(email, idRole, status, pageable);

        List<GetUsersDTO> userList = new ArrayList<>();

        for (User user : page) {
            userList.add(UserMapper.toGetUser(user));
        }
        return userList;
    }

    @Override
    public int countListUsers(String email, int idRole, int status) throws CustomNotFoundEx {

        return userRepository.countListUsersPage(email,idRole,status);
    }

    @Override
    public GetUsersDTO updateUser(GetUsersDTO getUsersDTO) throws CustomNotFoundEx {
        Optional<User> userOptional = userRepository.findById(getUsersDTO.getUserID());
        User user;
      if(userOptional.isPresent()){
          user = userOptional.get();
      }else {
          user = new User();
          user.setPassword("123");
          List<Reservation> reservations = new ArrayList<>();
          user.setReservations(reservations);
          List<ReservationDetail> reservationDetails = new ArrayList<>();
          user.setReservationDetails(reservationDetails);
      }
            user.setName(getUsersDTO.getName());
            user.setEmail(getUsersDTO.getEmail());
            user.setPhone(getUsersDTO.getPhone());
            user.setAddress(getUsersDTO.getAddress());
            user.setGender(getUsersDTO.getGender());
             user.setStatus(getUsersDTO.getStatus());

            List<Role> roles = new ArrayList<>();
            Role role = repository.findById(getUsersDTO.getRoleID()).get();
            roles.add(role);

            user.setRoles(roles);
            try {
//                List<Reservation> reservations = new ArrayList<>();
//                if(user.setReservations(reservations));
                User  usersDTO =  userRepository.save(user);
                return UserMapper.toGetUser(usersDTO);
            }catch (Exception e){
                throw new CustomNotFoundEx(CustomError.builder().code("400").message(e.getMessage()).build());
            }

    }

    @Override
    public GetUsersDTO deleteUser(int id) throws CustomNotFoundEx {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return UserMapper.toGetUser(userOptional.get());
        } else {
            throw new CustomNotFoundEx(CustomError.builder().code("404").message("User not found").build());
        }
    }

    @Override
    public void activeUser(int id) throws CustomNotFoundEx {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userOptional.get().setStatus(userOptional.get().getStatus()==1?0:1);
            userRepository.save(userOptional.get());
        } else {
            throw new CustomNotFoundEx(CustomError.builder().code("404").message("User not found").build());
        }
    }

    // @Override
    // public UserDTOResponse registerUser(UserDTOCreate userDTOCreateReqMap) {
    // User user = UserMapper.toUserCreateUser(userDTOCreateReqMap);
    // user.setPassword(passwordEncoder.encode(user.getPassword()));
    // user.setToken(jwtTokenUtil.generateToken(user, 24 * 60 * 60));
    // user = userRepository.save(user);
    // return UserMapper.toUserDTOResponse(user);
    // }

    // @Override
    // public LoginMessage login(UserDTOLoginRequest userDTOLoginRequest) {
    // String msg = "";
    // User user1 = userRepository.findByEmail(userDTOLoginRequest.getEmail());
    // if (user1 != null) {
    // String password = userDTOLoginRequest.getPassword();
    // String encodedPassword = user1.getPassword();
    // Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
    // if (isPwdRight) {
    // Optional<User> user =
    // userRepository.findOneByEmailAndPassword(userDTOLoginRequest.getEmail(),
    // encodedPassword);
    // if (user.isPresent()) {
    // return new LoginMessage("Login Success", true);
    // } else {
    // return new LoginMessage("Login Failed", false);
    // }
    // } else {
    // return new LoginMessage("password Not Match", false);
    // }
    // } else {
    // return new LoginMessage("Email not exits", false);
    // }
    // }

}
