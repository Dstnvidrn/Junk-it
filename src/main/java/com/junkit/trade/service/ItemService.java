package com.junkit.trade.service;


import com.junkit.trade.domain.Item;
import com.junkit.trade.domain.User;
import com.junkit.trade.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserService userService;

    public List <Item> findAllItems(){
        return itemRepository.findAll();
    }

    public Item save(Item item, Long userId) {
        item.setUser(userService.findById(userId));
        item.setAvailable(true);
        item.setPostDate(LocalDate.now());
        itemRepository.save(item);
        return item;
    }
}
