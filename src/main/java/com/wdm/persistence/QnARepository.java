package com.wdm.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wdm.domain.QnA;

public interface QnARepository extends CrudRepository<QnA, Long> {
	
	//문의하기 눌렀을때 아이디로 조회
	List<QnA> findByIdOrderByQseqDesc(String id);
	//문의하기 눌렀을때 refid로 조회
	List<QnA> findByrefidOrderByQseqDesc(String id);
	
	// Save 후 qgrp 업데이트를 위해 qseq로 조회
	QnA findByqseq(Long qseq);
	
	@Query(value ="SELECT * FROM QnA WHERE qgrp = ?1", nativeQuery=true)
	List<QnA> findQgrp(Long qseq);
	
	//관리자화면에서 전체 리스트 불러오기
	@Query("SELECT q FROM QnA q Order By qseq Desc")
	Page<QnA> adminQnAList(Pageable pageable);
}
