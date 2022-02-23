package com.junkit.trade.web;


import com.junkit.trade.domain.Item;
import com.junkit.trade.domain.Message;
import com.junkit.trade.domain.User;
import com.junkit.trade.service.MessageService;
import com.junkit.trade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MessageService messageService;

    @GetMapping("/profile")
    public String getUserProfile(ModelMap modelMap, @AuthenticationPrincipal User loggedUser) {
        modelMap.put("loggedUser", loggedUser);
        return "profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile (@AuthenticationPrincipal User loggedInUser, User user ) {
        loggedInUser.setFirstName(user.getFirstName());
        loggedInUser.setLastName(user.getLastName());
        loggedInUser.setEmail(user.getEmail());
        loggedInUser.setUsername(user.getUsername());
//        String updatedPassword = passwordEncoder.encode(user.getPassword());
//        loggedInUser.setPassword(updatedPassword);    // WILL ADD A 'RESET USER PASSWORD LATER
        userService.save(loggedInUser);
        return "redirect:/profile/" + loggedInUser.getUserId();
    }

    @GetMapping("/profile/messages")
    public String getMessagePage(ModelMap modelMap, @AuthenticationPrincipal User loggedInUser) {
        List<Message> messageList = messageService.findAllByReceiverUserId(loggedInUser.getUserId());
        modelMap.put("message", new Message());
        modelMap.put("loggedUser", loggedInUser);
        modelMap.put("messages", messageList);
        return "messages";
    }

    @GetMapping("/profile/{userId}")
    public String getOtherProfile(@PathVariable Long userId, ModelMap modelMap, @AuthenticationPrincipal User loggedInUser){
        User user = userService.findById(userId);
        user.setFirstName(User.upperCaseFirstLetter(user.getFirstName()));
        user.setLastName(User.upperCaseFirstLetter(user.getLastName()));
        modelMap.put("message",new Message());
        modelMap.put("user", user);
        modelMap.put("loggedUser",loggedInUser);
        return "/profile";
    }

    @PostMapping("/profile/{userId}/message")
    public String messageOtherProfile(@AuthenticationPrincipal User loggedInUser , @PathVariable Long userId, Message newMessage) {
        messageService.createDirectMessage(loggedInUser, userId, newMessage);
        return "redirect:/profile/" + userId;
    }

    @PostMapping("/profile/messages/delete/{messageId}")
    public String deleteMessage(@PathVariable Long messageId) {
        messageService.deleteMessageById(messageId);
        return "redirect:/profile/messages";
    }

    @PostMapping("/profile/messages/reply/{userId}")
    public String replyToUser(@AuthenticationPrincipal User loggedInUser, @PathVariable Long UserId,  Message newMessage) {
        messageService.createDirectMessage(loggedInUser, UserId, newMessage);
    return "redirect:/profile/messages";
    }


    @GetMapping("/profile/{userId}/listings")
    public String getProfileListing(@AuthenticationPrincipal User loggedUser, @PathVariable Long userId, ModelMap modelMap) {
        User user = userService.findById(userId);
        modelMap.put("user", user);
        modelMap.put("loggedUser", loggedUser);
        return "listings";
    }
}
