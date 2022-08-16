package com.wdm.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wdm.config.SecurityUser;
import com.wdm.domain.Member;

@Controller
@SessionAttributes("loginMember")
public class SecurityController {
	
	//화면 이동
	@GetMapping("login")
	public void login() {
		
	}
	

	@GetMapping("/loginSuccess")
	public String loginSuccess(@AuthenticationPrincipal SecurityUser principal, Model model) {
		Member member = principal.getMember();
		
		
		System.out.println("[SecurityController]loginSuccess() : member=" + member);
		
		model.addAttribute("loginMember", member);
		
		return "redirect:main";

	}
	
	//접근 권한 없음
	@GetMapping("/system/accessDenied")
	public void accessDenied() {
	}
	
	@GetMapping("/failLogin")
	public void failLogin() {
		
	}

}
