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
	    List<Item> listings = itemService.findAllItems();
	    modelMap.put("listings", listings);
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

	@GetMapping("/profile/{userId}/listings")
	public String getProfileListing(@AuthenticationPrincipal User loggedUser, @PathVariable Long userId, ModelMap modelMap) {
		User user = userService.findById(userId);
		System.out.println(loggedUser.getUserId());
		System.out.println(user.getUserId());
		List<Item> listings = itemService.findAllByUserId(loggedUser.getUserId());
		modelMap.put("user", user);
		modelMap.put("loggedUser", loggedUser);
		modelMap.put("item",new Item());
		modelMap.put("listings", listings);
		return "listings";
	}

	@PostMapping("/profile/{userId}/listings")
	public String postNewListing(Item newItem, @AuthenticationPrincipal User loggedUser,@PathVariable Long userId){
		itemService.save(newItem, loggedUser);
		return "redirect:/profile/{userId}/listings";
	}

	@GetMapping("/profile/{userId}/listings/{itemId}")
	public String getItemDetails(@AuthenticationPrincipal User loggedUser, @PathVariable Long userId, ModelMap modelMap, @PathVariable Long itemId){
		Item selectedItem = itemService.findById(itemId);
		User user = userService.findById(userId);
		modelMap.put("user",user);
		modelMap.put("loggedUser", loggedUser);
		modelMap.put("item",selectedItem);
		modelMap.put("message", new Message());
		return "listingDetails";
	}

	@PostMapping("/profile/{userId}/listings/{itemId}/update")
	public String updateItemDetails(Item selectedItem, @AuthenticationPrincipal User loggedInUser){
		itemService.updateItem(selectedItem, loggedInUser);
		return "redirect:/profile/{userId}/listings/{itemId}";
	}

	@PostMapping("/profile/listings/delete/{itemId}")
	public String deleteItemListing(@PathVariable Long itemId, @AuthenticationPrincipal User loggedInUser) {
		itemService.deleteItem(itemId);
		return "redirect:/profile/"+ loggedInUser.getUserId() + "/listings";
	}

	@PostMapping("/profile/listings/sell/{itemId}")
	public String markItemSold(@PathVariable Long itemId, @AuthenticationPrincipal User loggedInUser) {
		itemService.markSold(itemId);
		return "redirect:/profile/"+ loggedInUser.getUserId() + "/listings";
	}




}
