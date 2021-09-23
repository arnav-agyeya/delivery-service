package com.hackathon.deliveryservice.dao;

import com.hackathon.deliveryservice.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemDao extends JpaRepository<Item, Long> {
}