package com.wdm.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wdm.domain.Restaurant_Comment;

public interface RestaurantCommentRepository extends CrudRepository<Restaurant_Comment, Long>{

	List<Restaurant_Comment> findByRseq(Long Rseq);
	
	
	Long countByRseq(Long Rseq);
}
