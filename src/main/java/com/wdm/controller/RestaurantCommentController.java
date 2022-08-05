package com.wdm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wdm.domain.Restaurant_Comment;
import com.wdm.service.CommentService;

@RestController
@RequestMapping("/comments")
public class RestaurantCommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/save")
	public String SaveComment(Restaurant_Comment comment) {
		
		comment.setId("sslee");
		comment.setNickname("한산대첩");

		commentService.saveRestaurantComment(comment);
		
		System.out.println(comment.toString());
		//String url = "WDMDetail?rseq="+comment.getRseq();
		return "success";
		
	}
	
		
	@GetMapping("/list")
	public List<Restaurant_Comment>commentsList(Restaurant_Comment comment, Model model) {;
		
		List<Restaurant_Comment> commentList = commentService.getcommentList(comment.getRseq());
		Long totalCount = commentService.countByRseq(comment.getRseq());
		
		for(Restaurant_Comment List : commentList) {
			System.out.println(List);
		}
		System.out.println(totalCount);
		
		model.addAttribute("commentList", commentList);
		model.addAttribute("totalCount", totalCount);
		return commentList;
	}
	

}
