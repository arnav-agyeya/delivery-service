package com.hackathon.deliveryservice.service;

import com.hackathon.deliveryservice.entities.CardTransaction;
import com.hackathon.deliveryservice.entities.Order;
import com.hackathon.deliveryservice.entities.UserAccount;
import com.hackathon.deliveryservice.entities.UserCard;

import java.util.List;

public interface ICardService {

    void addTransaction(CardTransaction transaction);

    int viewPoints(long cardId);

    List<CardTransaction> getAllTransactions(long cardId);

    UserCard createCardForNewUser(UserAccount userAccount);

    List<CardTransaction> getAllTransactionsForUser(long userId);

    UserCard getCard(long userId);

    CardTransaction addTransaction(Order order);
}
