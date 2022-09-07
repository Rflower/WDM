package com.wdm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wdm.domain.Restaurant_Comment;

public interface CommentService {

	void saveRestaurantComment(Restaurant_Comment comment);
	
	Page<Restaurant_Comment> getcommentList(Long rseq, Pageable pageable);
	
}
