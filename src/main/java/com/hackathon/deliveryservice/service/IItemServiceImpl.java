package com.hackathon.deliveryservice.service;

import com.hackathon.deliveryservice.dao.IItemDao;
import com.hackathon.deliveryservice.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IItemServiceImpl implements IItemService {

    @Autowired
    private IItemDao itemDao;

    @Override
    public List<Item> getAllItems() {
        return itemDao.findAll();
    }

    @Override
    public Item getItemByName(String name) {
        return null;
    }

    @Override
    public Item addItem(String itemName,
                        int itemPrice) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setItemPrice(itemPrice);

        itemDao.save(item);
        return item;
    }
}
