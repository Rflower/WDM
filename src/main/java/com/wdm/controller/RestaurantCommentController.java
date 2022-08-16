package com.wdm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wdm.config.SecurityUser;
import com.wdm.domain.Member;
import com.wdm.domain.Restaurant_Comment;
import com.wdm.service.CommentService;

@RestController
@RequestMapping("/comments")
@SessionAttributes("loginMember")
public class RestaurantCommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/save")
	public String SaveComment(@AuthenticationPrincipal SecurityUser principal, Restaurant_Comment comment) {
		Member member = principal.getMember();
	
			comment.setId(member.getId());
			comment.setNickname(member.getNickname());
			
			commentService.saveRestaurantComment(comment);
		
			System.out.println(comment.toString());
			
			return "success";
			
	
	}
	
		
	@GetMapping("/list")
	public Map<String, Object> commentsList(Long rseq, Pageable pageable) {;
		Map<String, Object> commnetInfo = new HashMap<>();
		
		Page<Restaurant_Comment> pageInfo = commentService.getcommentList(rseq, pageable);
		//테이블에 저장된 전체 게시글의 수
		Long totalCount = pageInfo.getTotalElements();

		for(Restaurant_Comment List : pageInfo) {
			System.out.println(List);
		}

		List<Restaurant_Comment> commentList = pageInfo.getContent();
				
		commnetInfo.put("commentList", commentList);
		commnetInfo.put("pageInfo", pageInfo);
		commnetInfo.put("totalCount", totalCount);
		commnetInfo.put("rseq", rseq);
		
		return commnetInfo;
	}
	

}
