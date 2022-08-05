package com.wdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdm.domain.Restaurant_Comment;
import com.wdm.persistence.RestaurantCommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private RestaurantCommentRepository rcRepo;
	
	@Override
	public void saveRestaurantComment(Restaurant_Comment comment) {
		
		rcRepo.save(comment);

	}

	@Override
	public List<Restaurant_Comment> getcommentList(Long rseq) {
		
		return rcRepo.findByRseq(rseq);
	}
	
	//맛집의 총 댓글 갯수
	@Override
	public Long countByRseq(Long Rseq) {
		
		return rcRepo.countByRseq(Rseq);
	}


}
