package com.hackathon.deliveryservice.service;

import com.hackathon.deliveryservice.controllerwrapper.PlaceOrderWrapper;
import com.hackathon.deliveryservice.entities.Order;

import java.util.List;

public interface IOrderManagementService {

    Order placeOrder(PlaceOrderWrapper order);

    List<Order>  getOrdersOfAUser(long userId);
}
