package com.wdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wdm.domain.Member;
import com.wdm.service.MemberService;

@Controller
public class JoinController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("contact")
	public String contact() {
		return "join";
	}
	
	@PostMapping("/join")
	public String join(Member member) {
		memberService.joinMember(member);
		
		System.out.println(member.toString());
		
		return "redirect:login";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		
		int cnt = memberService.idCheck(id);
		
		return cnt;
	}
	
	@PostMapping("/nicknameCheck")
	@ResponseBody
	public int nicknameCheck(@RequestParam("nickname") String nickname) {
		
		int cnt = memberService.nicknameCheck(nickname);
		
		return cnt;
	}
	
	@PostMapping("/emailCheck")
	@ResponseBody
	public int emailCheck(@RequestParam("email") String email) {

		int cnt = memberService.emailCheck(email);
		
		return cnt;
	}
	

}