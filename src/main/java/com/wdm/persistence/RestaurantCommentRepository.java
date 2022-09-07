package com.wdm.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.wdm.domain.Restaurant_Comment;

public interface RestaurantCommentRepository extends CrudRepository<Restaurant_Comment, Long>{
	
	Page<Restaurant_Comment> findByRseqOrderByRcseqDesc(Long rseq, Pageable pageable);

}
