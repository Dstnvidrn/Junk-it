package com.junkit.trade.web;

import com.junkit.trade.domain.User;
import com.junkit.trade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/showLogin")
    public String getLogin() {
        return "login_page";
    }

    @PostMapping("/showLogin")
    public String postLogin() {
        return "redirect:/browse";
    }





}
