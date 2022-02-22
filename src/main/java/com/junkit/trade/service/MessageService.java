package com.junkit.trade.service;


import com.junkit.trade.domain.Message;
import com.junkit.trade.domain.User;
import com.junkit.trade.repository.MessageRepository;
import com.junkit.trade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {


    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Message> findAllByReceiverUserId (Long userId) {
        User user = userRepository.getById(userId);
        List<Message> messagesList = messageRepository.findAllByReceiverUserId(userId);
        for (Message message: messagesList) {
            System.out.println(message.getMessageId());
        }

        return messagesList;
    }

    public Message save (Message message) {
        return messageRepository.save(message);
    }

    public Message findById(Long messageId) {
        return messageRepository.findById(messageId).orElse(null);
    }

    public void deleteMessageById(Long messageId) {
        messageRepository.delete(findById(messageId));
    }



}
