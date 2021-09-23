package com.hackathon.deliveryservice.dao;

import com.hackathon.deliveryservice.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAccountDao extends JpaRepository<UserAccount, Long> {
}
