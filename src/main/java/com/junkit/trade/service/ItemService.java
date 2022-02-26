package com.junkit.trade.service;


import com.junkit.trade.domain.Item;
import com.junkit.trade.domain.User;
import com.junkit.trade.repository.ItemRepository;
import com.junkit.trade.until.FileUploadUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
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

    public Item postNewItemListing(Item newItem, Long userId, String photoName) {
        newItem.setPostDate(LocalDate.now());
        newItem.setPhoto(photoName);
        newItem.setUser(userService.findById(userId));
        return itemRepository.save(newItem);
//        String uploadDir = "./static/listing-photos/" + savedItem.getItemId();
//
//        FileUploadUntil.savePhoto(uploadDir,photoName);


    }
}
