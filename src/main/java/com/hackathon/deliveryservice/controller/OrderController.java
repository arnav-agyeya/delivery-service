package com.hackathon.deliveryservice.controller;

import com.hackathon.deliveryservice.controllerwrapper.PlaceOrderWrapper;
import com.hackathon.deliveryservice.entities.CardTransaction;
import com.hackathon.deliveryservice.entities.Order;
import com.hackathon.deliveryservice.service.ICardService;
import com.hackathon.deliveryservice.service.IItemService;
import com.hackathon.deliveryservice.service.IOrderManagementService;
import com.hackathon.deliveryservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private IOrderManagementService orderManagementService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICardService cardService;
    @Autowired
    private IItemService itemService;

    @RequestMapping(path = "/placeOrder")
    public ResponseEntity<Order> placeOrder(@RequestBody PlaceOrderWrapper orderWrapper) {
        Order order = orderManagementService.placeOrder(orderWrapper);
        //add card transaction entry
        CardTransaction cardTransaction = cardService.addTransaction(order);

        System.out.println(cardTransaction);

        return new ResponseEntity<>(order, HttpStatus.OK);

    }

    @RequestMapping(path = "/getOrders")
    public List<Order> getOrdersOfUser(@RequestParam("userid") long userId) {
        return orderManagementService.getOrdersOfAUser(userId);
    }


}
