package com.testproject.swp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.user.dto.GetUsersDTO;
import com.testproject.swp.model.user.dto.UserDTOCreate;
import com.testproject.swp.model.user.dto.UserDTOLoginRequest;
import com.testproject.swp.model.user.dto.UserDTOResponse;
import com.testproject.swp.model.user.dto.UserDTOUpdate;
import com.testproject.swp.payload.LoginMessage;
import com.testproject.swp.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ccg1")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public Map<String, UserDTOResponse> login(@RequestBody Map<String, UserDTOLoginRequest> userDTOLoginReqMap)
            throws CustomBadReqEx, CustomNotFoundEx {
        return userService.authenticate(userDTOLoginReqMap);
    }

    // @PostMapping("/login")
    // public ResponseEntity<?> login(@RequestBody UserDTOLoginRequest
    // userDTOLoginRequest)
    // throws CustomBadReqEx, CustomNotFoundEx {
    // LoginMessage loginMessage = userService.login(userDTOLoginRequest);
    // return ResponseEntity.ok(loginMessage);
    // }

    @PostMapping("/register")
    public Map<String, UserDTOResponse> registerUser(@RequestBody Map<String, UserDTOCreate> userDTOCreateReqMap)
            throws CustomNotFoundEx {
        return userService.registerUser(userDTOCreateReqMap);
    }
    // @PostMapping("/register")
    // public UserDTOResponse registerUser(@RequestBody UserDTOCreate
    // userDTOCreateReqMap) {
    // return userService.registerUser(userDTOCreateReqMap);
    // }

    // @GetMapping("/user")
    // public Map<String, UserDTOResponse> getCurrentUser() throws CustomNotFoundEx {
    //     return userService.getCurrentUser();
    // }

     @GetMapping("/Users/{email}/{idRole}/{status}/{indexPage}/{sizePage}")
     public  List<GetUsersDTO> getListUsersPage(@PathVariable String email,@PathVariable int idRole,@PathVariable int status
             , @PathVariable int indexPage, @PathVariable int sizePage) throws CustomNotFoundEx {
         return userService.getListUsersPage(email,idRole,status,indexPage,sizePage);
     }

    @GetMapping("/Users/count/{email}/{idRole}/{status}")
    public  int countListUsers(@PathVariable String email,@PathVariable int idRole,@PathVariable int status ) throws CustomNotFoundEx {
        return userService.countListUsers(email,idRole,status);
    }


    // @PutMapping("/user")
    // public Map<String, UserDTOResponse> updateCurrentUser(@RequestBody Map<String, UserDTOUpdate> userDTOUpdateMap)
    //         throws CustomNotFoundEx {
    //     System.out.println("dsd");
    //     return userService.updateCurrentUser(userDTOUpdateMap);
    // }

    @GetMapping("/users/listUser")
    public List<GetUsersDTO> getUserList() throws CustomNotFoundEx {
        return userService.getUserList();
    }

    @GetMapping("/users/{id}")
    public GetUsersDTO getUserByID(@PathVariable int id) throws CustomNotFoundEx {
        return userService.getUserByID(id);
    }

    @GetMapping("/users/role/{idRole}")
    public List<GetUsersDTO> getUserByIdRole(@PathVariable int idRole) throws CustomNotFoundEx {
        return userService.getUserByIdRole(idRole);
    }

    @PutMapping("/users/update")
    public GetUsersDTO updateUser(@RequestBody GetUsersDTO getUsersDTO)
            throws CustomNotFoundEx {
        return userService.updateUser(getUsersDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public GetUsersDTO deleteUser(@PathVariable int id) throws CustomNotFoundEx {
        return userService.deleteUser(id);
    }



    @GetMapping("/active/{id}")
    public void activeUser(@PathVariable int id) throws CustomNotFoundEx {
         userService.activeUser(id);
    }


}
