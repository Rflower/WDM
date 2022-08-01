package com.wdm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wdm.domain.Restaurant;
import com.wdm.service.RestaurantService;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/restrantList")
	public String getRestrantList(Restaurant restestaurant, Model model) {
		
		List<Restaurant> restestaurantList =  restaurantService.getRestaurantList();
		model.addAttribute("restestaurantList", restestaurantList);
		return "WDMList";
	}
	
	@GetMapping("/insertRestaurant")
	public String insertRestaurantView() {
		return "WDMInsert";
	}
}
