package com.wdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wdm.domain.Restaurant;
import com.wdm.service.RestaurantService;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
//	//전체 글보기 관리자페이지에서 필요
//	@GetMapping("/restaurantList")
//	public String getRestaurantListPaging( Model model, Pageable pageable) {
//		
//		Page<Restaurant> restaurantList =  restaurantService.getRestaurantListPaging(pageable);
//		int nowPage = restaurantList .getPageable().getPageNumber() + 1;
//		model.addAttribute("restaurantList", restaurantList);
//		model.addAttribute("maxPage", 3);
//		model.addAttribute("nowPage", nowPage);
//		return "WDMList";
//	}
	


	@GetMapping("/restaurantList")
	public String getDongAndMenuSearchList(@RequestParam(required = false, defaultValue = "rseq", value = "orderby")String orderby,
										  @RequestParam(required = false, value = "searchKeyword") String searchKeyword,
										  Model model, Pageable pageable) {
				
		Page<Restaurant> restaurantList = null;
		
		if(searchKeyword == null) {
			restaurantList =  restaurantService.getRestaurantListPaging(pageable);
		}
		else {
			restaurantList = restaurantService.getSearchCategoryList(searchKeyword,orderby,pageable);
		}
		
		for(Restaurant item : restaurantList) {
			System.out.println(item);
		}
		
		int nowPage = restaurantList .getPageable().getPageNumber() + 1;
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("maxPage", 3);
		model.addAttribute("nowPage", nowPage);
		
		
		return "WDMList";
	}
	
	
	@GetMapping("/insertRestaurant")
	public String insertRestaurantView() {
		return "WDMInsert";
	}
}
