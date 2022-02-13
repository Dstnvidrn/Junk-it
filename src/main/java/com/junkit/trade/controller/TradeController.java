package com.junkit.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.junkit.trade.domain.User;
import com.junkit.trade.service.UserService;

@Controller
public class TradeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/browse")
	public String getHomePage(ModelMap modelMap) {
		return "home";
	}
	@GetMapping("/register")
	public String getRegisterPage(ModelMap modelMap) {
		User user = new User();
		modelMap.put("user", user);
		return "register";
	}
	
	@GetMapping("/browse/{userId}/contact")
	public String contactSeller(ModelMap modelMap, @PathVariable Long userId) {
		return null;		
	}
	
	@GetMapping("/browse/{userId}/{itemId}")
		public String getItemInfo (ModelMap modelMap, @PathVariable Long itemId) {
			return null;		
	}
	@PostMapping("/register")
	public String createAccount(User user) {
		userService.save(user);
		return "redirect:/browse";
	}

}
