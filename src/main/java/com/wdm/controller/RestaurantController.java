package com.wdm.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wdm.domain.Restaurant;
import com.wdm.service.RestaurantService;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/insertRestaurant")
	public String insertRestaurantView() {
		return "WDMInsert";
	}
	
	@GetMapping("/WDMDetail")
	public String wdmDetail(Restaurant restaurant, Model model) {
		
		model.addAttribute("restaurant", restaurantService.getRestBoard(restaurant));
		
		return "WDMDetail";
	}
	
	/*
	// 주소 중복확인
	@ResponseBody
	@GetMapping("/address_check")
	public ResponseEntity<?> addressCheckView(@RequestParam(value = "address_name") String address_name) throws BadRequestException{
		System.out.println(address_name);
		
		if(restaurantService.confirmAddress(address_name) == true) {
			throw new BadRequestException("이미 등록된 맛집입니다.");
		} else {
			return ResponseEntity.ok("사용 가능한 아이디 입니다.");
		}
	}
	*/
	
	@PostMapping("/insertRestaurant")
	public String insertRestaurant(@RequestParam(value="upload_image1", required=false)MultipartFile uploadFile1,
								   @RequestParam(value="upload_image2", required=false)MultipartFile uploadFile2,
								   @RequestParam(value="upload_image3", required=false)MultipartFile uploadFile3,
								   Restaurant restaurant, HttpSession session) {
		if(!uploadFile1.isEmpty()) {
			String fileName1 = uploadFile1.getOriginalFilename();
			restaurant.setImage1(fileName1);
			
			// 이미지 파일을 이동할 실제경로 구하기
			//String image_path = session.getServletContext()
			//					.getRealPath("src/main/resources/static/files/");
			String image_path = "/bootstrap/img/";
			try {
				uploadFile1.transferTo(new File(image_path+fileName1));
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
		if(!uploadFile2.isEmpty()) {
			String fileName2 = uploadFile2.getOriginalFilename();
			restaurant.setImage2(fileName2);
			
			// 이미지 파일을 이동할 실제경로 구하기
//			String image_path = session.getServletContext()
//								.getRealPath("src/main/resources/static/files/");
			String image_path = "/bootstrap/img/";
			try {
				uploadFile2.transferTo(new File(image_path+fileName2));
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		if(!uploadFile3.isEmpty()) {
			String fileName3 = uploadFile3.getOriginalFilename();
			restaurant.setImage3(fileName3);
			
			// 이미지 파일을 이동할 실제경로 구하기
//			String image_path = session.getServletContext()
//								.getRealPath("src/main/resources/static/files/");
			String image_path = "/bootstrap/img/";
			try {
				uploadFile3.transferTo(new File(image_path+fileName3));
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		restaurant.setId("sslee");
		System.out.println("restaurant:" + restaurant);
		
		restaurantService.insertRestaurant(restaurant);
		
		return "redirect:restaurantList";
	}
	
//	//전체 글보기 
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

	// 깃허브 머지 테스트
	//22222어ㅏㅁ농ㄻ홒륨아ㅣ로ㅓㅏㅁㄴ
}

	
	
	
	
	
	
	
	
	