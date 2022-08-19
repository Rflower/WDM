package com.wdm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wdm.config.SecurityUser;
import com.wdm.domain.Member;
import com.wdm.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("findIdForm")
	public String findIdForm() {
		return "/findMember/findIdForm";
	}
	
	@PostMapping("findId")
	public String findIdResult(Member member, Model model) {
		String findId = memberService.findIdResult(member.getName(), member.getEmail());
		System.out.println(findId);
		
		if (findId != null) { // 이름과 이메일을 조건으로 아이디 조회 성공
			model.addAttribute("message", 1);
			model.addAttribute("id", findId);
		} else {
			model.addAttribute("message", -1);
		}
		return "/findMember/findIdResult";
	}

	@GetMapping("findPwdForm")
	public String findPwdForm() {
		return "/findMember/findPwdForm";
	}
	
	@PostMapping("findPwd")
	public String findPwdResult(Member member, Model model) {
		String findPwd = memberService.findPwdResult(member.getId(), member.getName(), member.getEmail());
		System.out.println(findPwd);
		
		if (findPwd != null) { // 이름과 이메일을 조건으로 아이디 조회 성공
			model.addAttribute("id", member.getId());
			model.addAttribute("message", 1);
		
		} else {
			model.addAttribute("message", -1);
		}
		
		return "/findMember/findPwdResult";
	}
	
	@PostMapping("changePwd")
	public String changePwd(Member member) {
		System.out.println(member.getPwd());
		memberService.changePwd(encoder.encode(member.getPwd()), member.getId());
		
		return "/findMember/changePwdOk";
	}
	
	@GetMapping("mypage")
	public String mypage() {
		return "mypage";
	}
	
	@GetMapping("myUpdateInfo")
	public String myUpdateInfo() {
		return "myUpdateInfo";
	}
	
	@PostMapping("updateMember")
	public String updateMember(Member member) {
		memberService.joinMember(member);		
		
		return "redirect:/system/logout";
	}
	
	@PostMapping("/updateNicknameCheck")
	@ResponseBody
	public int updateNicknameCheck(@RequestParam("nickname") String nickname,
							@AuthenticationPrincipal SecurityUser member) {
		
		int cnt = 0;
		String chkId = memberService.updateNicknameCheck(member.getUsername());
		int chkNick = memberService.nicknameCheck(nickname);
	
		if(chkNick == 0 && chkId.equals(nickname)) {
			cnt = 0;
		}else if(chkNick != 0 && !chkId.equals(nickname)) {
			cnt = 1;
		}
		return cnt;

	}
	
	@PostMapping("/updateEmailCheck")
	@ResponseBody
	public int updateEmailCheck(@RequestParam("email") String email,
							@AuthenticationPrincipal SecurityUser member) {
		
		int cnt = 0;
		String chkId = memberService.updateEmailCheck(member.getUsername());
		int chkEmail = memberService.emailCheck(email);	
		
		if(chkEmail == 0 && chkId.equals(email)) {
			cnt = 0;
		}else if(chkEmail != 0 && !chkId.equals(email)) {
			cnt = 1;
		}
		return cnt;

	}
}
