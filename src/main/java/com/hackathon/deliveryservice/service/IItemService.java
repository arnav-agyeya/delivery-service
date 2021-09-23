package com.hackathon.deliveryservice.service;

import com.hackathon.deliveryservice.entities.Item;

import java.util.List;

public interface IItemService {

    List<Item> getAllItems();

    Item getItemByName(String name);

    Item addItem(String itemName,
                 int itemPrice);
}
