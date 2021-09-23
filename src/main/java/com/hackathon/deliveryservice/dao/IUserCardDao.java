package com.hackathon.deliveryservice.dao;

import com.hackathon.deliveryservice.entities.UserAccount;
import com.hackathon.deliveryservice.entities.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserCardDao extends JpaRepository<UserCard, Long> {

    UserCard findUserCardByUserAccount(UserAccount userAccount);
}