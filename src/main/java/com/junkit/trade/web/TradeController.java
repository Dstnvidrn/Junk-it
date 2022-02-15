package com.junkit.trade.web;

import antlr.StringUtils;
import com.junkit.trade.domain.Item;
import com.junkit.trade.domain.Message;
import com.junkit.trade.service.ItemService;
import com.junkit.trade.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.junkit.trade.domain.User;
import com.junkit.trade.service.UserService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class TradeController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private ItemService itemService;

	@GetMapping("/")
	public String redirectToWelcome() {
		return"redirect:/welcome";
	}
	@GetMapping("/welcome")
	public String getHomePage() {
		return "welcome";
	}

	@GetMapping("/register")
	public String getRegisterPage(ModelMap modelMap) {
		User user = new User();
		modelMap.put("user", user);
		return "register";
	}

	@PostMapping("/register")
	public String createAccount(User user) {
		userService.save(user);
		return "redirect:/welcome";
	}

	@GetMapping("/welcome/{userId}")
	public String contactSeller(ModelMap modelMap, @PathVariable Long userId) {
		modelMap.put("user", userService.findById(userId));
		modelMap.put("items",itemService.findAllItems());
		modelMap.put("item",new Item());
		return "welcome";
	}


	@GetMapping("profile/{userId}")
	public String getUserAccount(ModelMap modelMap, @PathVariable Long userId) {
		User user = userService.findById(userId);
		List<Message> userMessages = messageService.findByUser(userId);
		modelMap.put("messages", userMessages);
		modelMap.put("user", user);
		return "profile";
	}

	@GetMapping("/{userId}/messages")
	public String getMessagePage(ModelMap modelMap, @PathVariable Long userId) {
		List<Message> userMessages = messageService.findByUser(userId);
		modelMap.put("messages", userMessages);
		return "messages";
	}


}
