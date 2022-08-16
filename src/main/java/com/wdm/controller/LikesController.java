package com.wdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wdm.config.SecurityUser;
import com.wdm.domain.Likes;
import com.wdm.service.LikesService;

@Controller
@SessionAttributes("loginMember")
public class LikesController {
	
	@Autowired
	private LikesService likesService;
	
	@PostMapping("/restaurant/likes")
	@ResponseBody
	public int Likes(@ModelAttribute Likes likes, @AuthenticationPrincipal SecurityUser principal) {
		System.out.println("Likes: " + likes);
		
		// 세션에서 아이디 불러오기
		likes.setId(principal.getUsername());
		
		int result = likesService.insertLikes(likes, principal.getUsername());
		System.out.println("result: " + result);
		return result;
	}
}
