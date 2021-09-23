package com.hackathon.deliveryservice.service;

import com.hackathon.deliveryservice.controllerwrapper.SignUpWrapper;
import com.hackathon.deliveryservice.entities.LoginUser;
import com.hackathon.deliveryservice.entities.UserAccount;

public interface IUserService {

//    public void signUp(String name,
//                       String phNo,
//                       String email,
//                       String username,
//                       String pwd,
//                       boolean isAdmin);

    void signUp(UserAccount user,
                LoginUser loginUser);

    boolean login(String username,
                  String pwd);

    UserAccount saveUser(SignUpWrapper userAccount);

    UserAccount getUserById(long userId);

    UserAccount getUserByUserName(String userName);
}
