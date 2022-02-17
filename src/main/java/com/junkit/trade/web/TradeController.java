package com.junkit.trade.web;

import antlr.StringUtils;
import com.junkit.trade.domain.Item;
import com.junkit.trade.domain.Message;
import com.junkit.trade.service.ItemService;
import com.junkit.trade.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
	public String redirectToBrowse() {
		return"redirect:/browse";
	}

	@GetMapping("/browse")
	public String getHomePage(ModelMap modelMap, @AuthenticationPrincipal User user) {
		modelMap.put("user", user);
		return "browse";
	}


	@GetMapping("/register")
	public String getRegisterPage(ModelMap modelMap) {
		User user = new User();
		modelMap.put("user", user);
		return "register";
	}
	@PostMapping("/register")
	public String createAccount(User user) {
		userService.createUserAccount(user);
		return "redirect:/browse";
	}




}
