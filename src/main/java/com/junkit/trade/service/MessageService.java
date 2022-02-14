package com.junkit.trade.service;


import com.junkit.trade.domain.Message;
import com.junkit.trade.domain.User;
import com.junkit.trade.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired UserService userService;

    public List<Message> findByUser(Long userId) {
        User user = userService.findById(userId);
        return messageRepository.findByUser(user);
    }

}
