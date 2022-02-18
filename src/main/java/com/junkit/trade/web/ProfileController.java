package com.junkit.trade.web;


import com.junkit.trade.domain.User;
import com.junkit.trade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
        String updatedPassword = passwordEncoder.encode(user.getPassword());
        loggedInUser.setPassword(updatedPassword);
        userService.save(loggedInUser);
        return "redirect:/profile";
    }


//    @GetMapping("/profile/{userId}")
//    public String visitOtherProfile(ModelMap modelMap, @AuthenticationPrincipal User user, @PathVariable Long userId) {
//
//
//    }
}
