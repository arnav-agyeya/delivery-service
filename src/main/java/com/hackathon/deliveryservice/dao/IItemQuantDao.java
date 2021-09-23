package com.hackathon.deliveryservice.dao;

import com.hackathon.deliveryservice.entities.ItemQuant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemQuantDao extends JpaRepository<ItemQuant, Long> {
}