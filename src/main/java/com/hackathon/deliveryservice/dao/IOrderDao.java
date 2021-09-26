package com.hackathon.deliveryservice.dao;

import com.hackathon.deliveryservice.entities.Order;
import com.hackathon.deliveryservice.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao extends JpaRepository<Order, Long> {

    List<Order> findAllByUser(UserAccount userAccount);
}
