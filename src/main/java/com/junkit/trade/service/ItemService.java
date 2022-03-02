package com.junkit.trade.service;


import com.junkit.trade.domain.Item;
import com.junkit.trade.domain.User;
import com.junkit.trade.repository.ItemRepository;
import com.junkit.trade.until.FileUploadUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserService userService;

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item save(Item item, User loggedInUser) {
        item.setUser(loggedInUser);
        item.setAvailable(true);
        item.setPostDate(LocalDate.now());
        return itemRepository.save(item);
    }
    public void deleteItem(Long itemId) {
        Item itemToDelete = findById(itemId);
        itemRepository.delete(itemToDelete);
    }

    public Item updateItem(Item selectedItem, User loggedInUser){
        selectedItem.setUser(loggedInUser);
        return itemRepository.save(selectedItem);
    }

    public List<Item> findAllByUserId(Long userId) {
        return itemRepository.findAllByUserUserId(userId);
    }
    public Item findById(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    public void markSold(Long itemId) {
        Item soldItem = findById(itemId);
        soldItem.setAvailable(false);
        itemRepository.save(soldItem);
    }



}