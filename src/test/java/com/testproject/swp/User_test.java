package com.testproject.swp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.testproject.swp.entity.User;
import com.testproject.swp.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class User_test {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(false)
    public void testCreateUser() {
        User user = new User(0, "Tunng", 0, "fdsfag", "1234", "fsfdsf", "234324", 0, 0, "image.png");
        User sevedUser = userRepository.save(user);
        assertNotNull(sevedUser);
    }

    @Test
    public void testFindUserByName() {
        String user_name = "Tunng";
       // User user = userRepository.findUser(user_name);
       // assertThat(User.getUser_fullname()).isEqualTo(user_name);
    }



}
