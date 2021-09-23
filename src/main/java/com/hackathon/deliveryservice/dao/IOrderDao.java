package com.hackathon.deliveryservice.dao;

import com.hackathon.deliveryservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDao extends JpaRepository<Order, Long> {
}
