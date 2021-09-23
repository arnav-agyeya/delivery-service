package com.hackathon.deliveryservice.dao;

import com.hackathon.deliveryservice.entities.CardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardTransactionDao extends JpaRepository<CardTransaction, Long> {
}