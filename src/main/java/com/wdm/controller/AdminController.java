package com.wdm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wdm.domain.CountById;
import com.wdm.domain.QnA;
import com.wdm.domain.Restaurant;
import com.wdm.service.AdminService;
import com.wdm.service.RestaurantService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("admin")
	public String admin() {
		return "adminpage";
	}
	
	//QnA 전체 불러오기
	@GetMapping("adminQnA")
	public String adminQnA(Pageable pageable,Model model) {
		Page<QnA> adminQnAList = adminService.getAdminQnAList(pageable);
		
		int nowPage = adminQnAList .getNumber() + 1;
		model.addAttribute("adminQnAList", adminQnAList);
		model.addAttribute("maxPage", 3);
		model.addAttribute("nowPage", nowPage);
		
		return "adminQnAList";
	}
	
	
	@GetMapping("adminWDMList")
	public String adminWDMList(Pageable pageable,Model model) {
		Page<Restaurant> adminWDMList = restaurantService.getRestaurantListPaging(pageable);
		
		int nowPage = adminWDMList .getNumber() + 1;
		model.addAttribute("adminWDMList", adminWDMList);
		model.addAttribute("maxPage", 3);
		model.addAttribute("nowPage", nowPage);

		
		return "adminWDMList";
	}
	
	
	@GetMapping("adminCheckPage")
	public String adminCheckPage() {
		return "adminCheckPage";
	}
	
	@GetMapping("admin_chart")
	@ResponseBody
	public List<CountById> adminChart() {
		List<CountById> getCountById = adminService.getCountById();
		
		return getCountById;
	}
	
	@GetMapping("adminNotice")
	public String adminNotice() {
		return "adminNotice";
	}
}
