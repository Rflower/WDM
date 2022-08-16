package com.wdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Page<Restaurant_Comment> getcommentList(Long rseq,Pageable pageable) {
		int page = pageable.getPageNumber();
		Pageable paging = PageRequest.of(page, 7);
		
		Page<Restaurant_Comment> getCommentList = rcRepo.findByRseqOrderByRcseqDesc(rseq, paging);
		return getCommentList;
	}

}
