package com.hackathon.deliveryservice.service;

import com.hackathon.deliveryservice.entities.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAdminServiceImpl implements IAdminService {
    @Override
    public List<UserAccount> getAllUsers() {
        return null;
    }

    @Override
    public List<UserAccount> getAllAdmins() {
        return null;
    }

    @Override
    public List<UserAccount> getAllClients() {
        return null;
    }

    @Override
    public UserAccount getUser(long userId) {
        return null;
    }
}
