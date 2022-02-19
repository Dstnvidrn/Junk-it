package com.junkit.trade.web;


import com.junkit.trade.domain.Message;
import com.junkit.trade.domain.User;
import com.junkit.trade.service.MessageService;
import com.junkit.trade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String getUserProfile(ModelMap modelMap, @AuthenticationPrincipal User user) {
        modelMap.put("user", user);
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
        return "redirect:/profile";
    }

    @GetMapping("/profile/messages")
    public String getMessagePage(ModelMap modelMap, @AuthenticationPrincipal User LoggedInuser) {
        List<Message> messageList = messageService.findAllByReceiverUserId(LoggedInuser.getUserId());
        modelMap.put("messages", messageList);
        return "messages";
    }

    @GetMapping("/profile/{userId}")
    public String getOtherProfile(@PathVariable Long userId, ModelMap modelMap, @AuthenticationPrincipal User loggedInUser){
        User user = userService.findById(userId);
        modelMap.put("user", user);
        modelMap.put("loggedUser",loggedInUser);
        return "/profile";
    }

}
