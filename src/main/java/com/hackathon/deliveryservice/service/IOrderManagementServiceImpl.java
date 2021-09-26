package com.hackathon.deliveryservice.service;

import com.hackathon.deliveryservice.controllerwrapper.PlaceOrderWrapper;
import com.hackathon.deliveryservice.dao.IItemDao;
import com.hackathon.deliveryservice.dao.IItemQuantDao;
import com.hackathon.deliveryservice.dao.IOrderDao;
import com.hackathon.deliveryservice.dao.IUserAccountDao;
import com.hackathon.deliveryservice.entities.ItemQuant;
import com.hackathon.deliveryservice.entities.Order;
import com.hackathon.deliveryservice.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IOrderManagementServiceImpl implements IOrderManagementService {

    @Autowired
    private IUserAccountDao userAccountDao;
    @Autowired
    private IOrderDao orderDao;
    @Autowired
    private IItemDao itemDao;
    @Autowired
    private IItemQuantDao itemQuantDao;

    @Override
    public Order placeOrder(PlaceOrderWrapper orderWrapper) {
        Order order = new Order();
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss");
        order.setOrderTime(LocalDate.parse(orderWrapper.getDate(), dateTimeFormat));
        order.setSourceAddress(orderWrapper.getSourceAddress());
        order.setDestinationAddress(orderWrapper.getDestAddress());
        order.setItemQuantList(getItemQuantList(orderWrapper));

        UserAccount userAccount = userAccountDao.findById(orderWrapper.getUserId()).orElse(null);
        assert userAccount != null;
        order.setUser(userAccount);

        orderDao.save(order);
        return order;
    }

    private List<ItemQuant> getItemQuantList(PlaceOrderWrapper orderWrapper) {
        return orderWrapper.getItemMap().entrySet()
                .stream()
                .map(this::getItemQuant)
                .collect(Collectors.toList());
    }

    private ItemQuant getItemQuant(Map.Entry<Integer, Integer> entry) {
        ItemQuant itemQuant = new ItemQuant(itemDao.findById(Long.valueOf(entry.getKey())).orElse(null),
                entry.getValue());
        itemQuantDao.save(itemQuant);
        return itemQuant;
    }

    @Override
    public List<Order> getOrdersOfAUser(long userId) {
        UserAccount userAccountDaoById = userAccountDao
                .findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong User Id"));
        System.out.println(userAccountDaoById);
        return orderDao.findAllByUser(userAccountDaoById);
    }
}
