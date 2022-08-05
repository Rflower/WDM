package com.wdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

//	@GetMapping("contact")
//	public String contact() {
//		return "join";
//	}
//	
//	@GetMapping("login")
//	public String login() {
//		return "login";
//	}
	
	@GetMapping("mypage")
	public String mypage() {
		return "mypage";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "adminpage";
	}
	
	@GetMapping("QnA")
	public String QnA() {
		return "QnA";
	}
	
	@GetMapping("updateInfo")
	public String updateInfo() {
		return "updateInfo";
	}
	
	@GetMapping("myList")
	public String myList() {
		return "myList";
	}
	
	@GetMapping("adminQnA")
	public String adminQnA() {
		return "adminQnAList";
	}
	
	@GetMapping("adminDetail")
	public String adminDetail() {
		return "adminDetail";
	}
	@GetMapping("adminGetBoardList")
	public String adminGetBoardList() {
		return "adminGetBoardList";
	}
	@GetMapping("adminCheckPage")
	public String adminCheckPage() {
		return "adminCheckPage";
	}
}
