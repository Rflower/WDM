package com.wdm.service;

import java.util.List;

import com.wdm.domain.Restaurant_Comment;

public interface CommentService {

	void saveRestaurantComment(Restaurant_Comment comment);
	
	List<Restaurant_Comment> getcommentList(Long rseq);
	
	//맛집의 총 댓글 갯수
	
	Long countByRseq(Long Rseq);
}
