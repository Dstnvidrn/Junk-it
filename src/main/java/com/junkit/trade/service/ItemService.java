package com.junkit.trade.service;


import com.junkit.trade.domain.Item;
import com.junkit.trade.domain.User;
import com.junkit.trade.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public List <Item> findAllItems(){
        return itemRepository.findAll();
    }

    public Item save(Item item, User user) {
        user.getItems().add(item);
        itemRepository.save(item);
        return item;
    }
}
