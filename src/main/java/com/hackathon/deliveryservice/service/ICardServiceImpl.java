package com.hackathon.deliveryservice.service;

import com.hackathon.deliveryservice.dao.IUserAccountDao;
import com.hackathon.deliveryservice.dao.IUserCardDao;
import com.hackathon.deliveryservice.entities.CardTransaction;
import com.hackathon.deliveryservice.entities.Order;
import com.hackathon.deliveryservice.entities.UserAccount;
import com.hackathon.deliveryservice.entities.UserCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ICardServiceImpl implements ICardService {

    @Autowired
    private IUserCardDao userCardDao;
    @Autowired
    private IUserAccountDao userAccountDao;

    @Override
    public void addTransaction(CardTransaction transaction) {

    }

    @Override
    public int viewPoints(long cardId) {
        return 0;
    }

    @Override
    public List<CardTransaction> getAllTransactions(long cardId) {
        return null;
    }

    @Override
    public UserCard createCardForNewUser(UserAccount userAccount) {
        UserCard userCard = new UserCard();
        userCard.setPoints(0);
        userCard.setUserAccount(userAccount);
        userCardDao.save(userCard);

        return userCard;
    }

    @Override
    public List<CardTransaction> getAllTransactionsForUser(long userId) {
        UserAccount user = userAccountDao.findById(userId).orElse(null);
        assert user != null;

        UserCard userCardByUserAccount = userCardDao.findUserCardByUserAccount(user);
        return userCardByUserAccount.getTransactionList();

    }

    @Override
    public UserCard getCard(long userId) {
        UserAccount user = userAccountDao.findById(userId).orElse(null);
        assert user != null;

        return userCardDao.findUserCardByUserAccount(user);
    }

    @Override
    public CardTransaction addTransaction(Order order) {
        UserCard card = userCardDao.findUserCardByUserAccount(order.getUser());
        List<CardTransaction> transactionList = card.getTransactionList();
        CardTransaction cardTransaction = new CardTransaction();
        cardTransaction.setTransactionType(true);
        cardTransaction.setPoints(order.getPrice());
        cardTransaction.setOrder(order);

        if (transactionList == null) {
            transactionList = new ArrayList<>();
        }
        transactionList.add(cardTransaction);
        card.setTransactionList(transactionList);

        userCardDao.save(card);
        return cardTransaction;
    }
}
