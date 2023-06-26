// package com.testproject.swp.controller;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import com.testproject.swp.entity.Service;
// import com.testproject.swp.entity.User;
// import com.testproject.swp.service.ServiceService;
// import com.testproject.swp.service.UserService;

// class UserControllerTest {
//     @Mock
//     private UserService userService;

//     @InjectMocks
//     private UserController userController;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     void createUser_shouldReturnCreatedUser() {
//         User inputUser = new User();
//         User createdUser = new User();
//         when(userService.createUser(inputUser)).thenReturn(createdUser);

//         ResponseEntity<User> response = userController.createUser(inputUser);

//         assertEquals(HttpStatus.CREATED, response.getStatusCode());
//         assertEquals(createdUser, response.getBody());
//         verify(userService, times(1)).createUser(inputUser);
//     }

//     @Test
//     void getAllUser_shouldReturnAllUser() {
//         List<User> users = Arrays.asList(new User(), new User());
//         when(userService.getAllUsers()).thenReturn(users);

//         ResponseEntity<List<User>> response = userController.getAllUsers();

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals(users, response.getBody());
//         verify(userService, times(1)).getAllUsers();
//     }

//     @Test
//     void getUserById_existingUserId_shouldReturnUser() {
//         int user_id = 1;
//         User user = new User();
//         when(userService.getUserByid(user_id)).thenReturn(Optional.of(user));

//         ResponseEntity<User> response = userController.getUserByid(user_id);

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals(user, response.getBody());
//         verify(userService, times(1)).getUserByid(user_id);
//     }

//     @Test
//     void updateUser_existingUserId_shouldReturnUpdatedUser() {
//         int user_id = 1;
//         User inputUser = new User();
//         User updatedUser = new User();
//         when(userService.updateUser(user_id, inputUser)).thenReturn(updatedUser);

//         ResponseEntity<User> response = userController.updateUser(user_id, inputUser);

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals(updatedUser, response.getBody());
//         verify(userService, times(1)).updateUser(user_id, inputUser);
//     }

//     @Test
//     void deleteUser_existingUserId_shouldReturnSuccessMessage() {
//         int user_id = 1;
//         when(userService.deleteUser(user_id)).thenReturn(true);

//         ResponseEntity<String> response = userController.deleteUser(user_id);

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals("User deleted successfully", response.getBody());
//         verify(userService, times(1)).deleteUser(user_id);
//     }

// }
