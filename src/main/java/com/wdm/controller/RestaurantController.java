package com.wdm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.wdm.config.SecurityUser;
import com.wdm.domain.Likes;
import com.wdm.domain.Restaurant;
import com.wdm.persistence.LikesRepository;
import com.wdm.service.RestaurantService;

@Controller
@SessionAttributes("loginMember")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;	
	
	@Autowired
	private LikesRepository lRepo;

	//맛집 상위 4개 불러오기
	@GetMapping("/main")
	public String mainView(Model model) {
		
		List<Restaurant> likesTop4 = restaurantService.getBestLikescntList();
		
		for(Restaurant list : likesTop4) {
			System.out.println(list);
		}
		model.addAttribute("likesTop4", likesTop4);
	
		return "main";
	}
	
	
	@GetMapping("/WDMDetail")
	public String wdmDetail(Restaurant restaurant, Model model, @AuthenticationPrincipal SecurityUser principal) {	
		
		// 기존 detail부분
		model.addAttribute("restaurant", restaurantService.WDMDetail(restaurant));
		
		
		Optional<Likes> likes = null;
		if(principal != null) {
			Long rseq = restaurant.getRseq();
			System.out.printf("wdmDetail() : rseq = %s, username=%s\n", rseq, principal.getUsername());
			likes= lRepo.findLikesByRseqAndId(restaurant.getRseq(), principal.getUsername());
			if (likes.isEmpty()) {
				model.addAttribute("likes", 0);
			} else {
				model.addAttribute("likes", 1);	
			}
		} else {
			model.addAttribute("likes", 0);	
		}
		
		return "WDMDetail";
	}
	
	@GetMapping("/insertRestaurant")
	public String insertRestaurantView() {

		return "WDMInsert";
		
	}

	//수정
	
	@PostMapping("/insertRestaurant")
	public String insertRestaurant(@RequestParam(value="upload_image1", required=false)MultipartFile uploadFile1,
								   @RequestParam(value="upload_image2", required=false)MultipartFile uploadFile2,
								   @RequestParam(value="upload_image3", required=false)MultipartFile uploadFile3,
								   @AuthenticationPrincipal SecurityUser principal,
								   Restaurant restaurant) {
	
			String image_path = "C:/Users/Admin/images/";
			System.out.println("image_path: " + image_path);
			File saveFolder = new File(image_path);
			
			if (!saveFolder.exists()) {
				saveFolder.mkdirs();
			}
			
			if(!uploadFile1.isEmpty()) {
				String fileName1 = uploadFile1.getOriginalFilename();
				restaurant.setImage1(fileName1);
				
				try {
					uploadFile1.transferTo(new File(image_path + fileName1));
				} catch (IllegalStateException | IOException e){
					e.printStackTrace();
				}
			}
			
			if(!uploadFile2.isEmpty()) {
				String fileName2 = uploadFile2.getOriginalFilename();
				restaurant.setImage2(fileName2);
				
				try {
					uploadFile2.transferTo(new File(image_path+fileName2));
				} catch (IllegalStateException | IOException e){
					e.printStackTrace();
				}
			}
			
			if(!uploadFile3.isEmpty()) {
				String fileName3 = uploadFile3.getOriginalFilename();
				restaurant.setImage3(fileName3);
				
				try {
					uploadFile3.transferTo(new File(image_path+fileName3));
				} catch (IllegalStateException | IOException e){
					e.printStackTrace();
				}
			}
			//Member member = principal.getMember();
		
			restaurant.setId(principal.getUsername());
			
			System.out.println("restaurant:" + restaurant);
			
			restaurantService.insertRestaurant(restaurant);
		
		return "redirect:restaurantList";
	}
	
	
	@PostMapping("/nameChk")
	@ResponseBody 
	public int nameChk(@RequestParam("name") String name) {
		System.out.println(name);
		int cnt = restaurantService.nameChk(name);
	    System.out.println(cnt);
	    
	    return cnt; 
	}
	
	/*
	 * 맛집 수정 페이지 열기
	 */
	@GetMapping("/updateRestaurant")
	public String updateRestaurantView() {

		return "WDMupdate";
		
	}
	
	/*
	 * 맛집 수정 하기
	 */
	@PostMapping("/updateRestaurant")
	public String updateRestaurant(@RequestParam(value="upload_image1", required=false)MultipartFile uploadFile1,
			   @RequestParam(value="upload_image2", required=false)MultipartFile uploadFile2,
			   @RequestParam(value="upload_image3", required=false)MultipartFile uploadFile3,
			   @RequestParam(value="nonmakeImg") String org_image,
			   @AuthenticationPrincipal SecurityUser principal,
			   Restaurant restaurant) {
		
		String image_path = "C:/Users/Admin/images/";
		System.out.println("image_path: " + image_path);
		File saveFolder = new File(image_path);
		
		if (!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
		
		if(!uploadFile1.isEmpty()) {
			String fileName1 = uploadFile1.getOriginalFilename();
			restaurant.setImage1(fileName1);
			
			try {
				uploadFile1.transferTo(new File(image_path + fileName1));
			} catch (IllegalStateException | IOException e){
				e.printStackTrace();
			}
		} else { // 상품 이미지를 수정하지 않은 경우 기존 이미지 사용
			restaurant.setImage1(org_image);
		}
		
		if(!uploadFile2.isEmpty()) {
			String fileName2 = uploadFile2.getOriginalFilename();
			restaurant.setImage2(fileName2);
			
			try {
				uploadFile2.transferTo(new File(image_path+fileName2));
			} catch (IllegalStateException | IOException e){
				e.printStackTrace();
			}
		} else { // 상품 이미지를 수정하지 않은 경우 기존 이미지 사용
			restaurant.setImage2(org_image);
		}
		
		if(!uploadFile3.isEmpty()) {
			String fileName3 = uploadFile3.getOriginalFilename();
			restaurant.setImage3(fileName3);
			
			try {
				uploadFile3.transferTo(new File(image_path+fileName3));
			} catch (IllegalStateException | IOException e){
				e.printStackTrace();
			}
		} else { // 상품 이미지를 수정하지 않은 경우 기존 이미지 사용
			restaurant.setImage3(org_image);
		}
		
		//Member member = principal.getMember();
	
		restaurant.setId(principal.getUsername());
		//restaurant.setId("gdhong");
		System.out.println("restaurant:" + restaurant);
		
		restaurantService.updateRestaurant(restaurant);
		
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
	

	//검색창 검색시 불러오는 리스트 처리
	@GetMapping("/restaurantList")
	public String getDongAndMenuSearchList(@RequestParam(required = false, defaultValue = "regdate", value = "orderby")String orderby,
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

		//model.addAttribute("image_path", "/Users/Admin/images/");
		
		return "WDMList";
	}

	/*
	 * 맛집 삭제하기(Admin)
	 */
	@GetMapping("/deleteRestaurant")
	public String insertRestaurant(Restaurant restaurant) {
		
		restaurantService.deleteRestaurant(restaurant);
		
		return "forward:restaurantList";
	}
	

}

	/*
	@GetMapping("/categoryList")
	public String getSearchCategoryList(@RequestParam(required = false, value = "searchKeyword") String searchKeyword,
										@RequestParam(required = false, value = "orderby")String orderby,
										Model model, Pageable pageable) {
		
		Page<Restaurant> restaurantList = restaurantService.getSearchCategoryList(searchKeyword, orderby, pageable);

		for(Restaurant item : restaurantList) {
			System.out.println(item);
		}	
		int nowPage = restaurantList .getPageable().getPageNumber() + 1;
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("maxPage", 3);
		model.addAttribute("nowPage", nowPage);
		
		return "WDMList";
	}
	*/
	
	/*
	@GetMapping("/{category_name}")
	public String getSearchCategoryList(@PathVariable(required = false)String category_name,
										@RequestParam(required = false, value = "searchKeyword") String searchKeyword,
										@RequestParam(required = false, value = "orderby")String orderby,
										Model model, Pageable pageable) {
		
		Page<Restaurant> restaurantList = restaurantService.getSearchCategoryList(category_name, searchKeyword,orderby, pageable);

		for(Restaurant item : restaurantList) {
			System.out.println(item);
		}	
		int nowPage = restaurantList .getPageable().getPageNumber() + 1;
		model.addAttribute("restaurantList", restaurantList);
		model.addAttribute("maxPage", 3);
		model.addAttribute("nowPage", nowPage);
		
		return "WDMList";
	}
	*/
	

