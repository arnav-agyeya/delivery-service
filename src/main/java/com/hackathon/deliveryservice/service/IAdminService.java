package com.hackathon.deliveryservice.service;

import com.hackathon.deliveryservice.entities.UserAccount;

import java.util.List;

public interface IAdminService {

    List<UserAccount> getAllUsers();

    List<UserAccount> getAllAdmins();

    List<UserAccount> getAllClients();

    UserAccount getUser(long userId);
}
