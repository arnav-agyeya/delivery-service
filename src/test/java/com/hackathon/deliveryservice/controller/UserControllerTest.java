package com.hackathon.deliveryservice.controller;

import com.hackathon.deliveryservice.controllerwrapper.SignUpWrapper;
import com.hackathon.deliveryservice.entities.UserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void testSignUp() {
        SignUpWrapper signUpWrapper = new SignUpWrapper("TestAdmin", "9709635639", "admin@xyz.com", "tadmin", "tpwd",
                true);

        ResponseEntity<UserAccount> userAccountResponseEntity = userController.signUp(signUpWrapper);


    }
}
