package com.wdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.wdm.config.SecurityUser;
import com.wdm.domain.QnA;
import com.wdm.persistence.QnARepository;

@Service
public class QnAServiceImpl implements QnAService{

	@Autowired
	private QnARepository qnaRepo;
	
	@Override
	public void SaveQna(QnA qna) {
		qnaRepo.save(qna);
		
	}

	@Override
	public List<QnA> getFindById(String id) {
		
		return qnaRepo.findByIdOrderByQseqDesc(id);
	}

	@Override
	public List<QnA> getFindByRefId(String id) {
	
		return qnaRepo.findByrefidOrderByQseqDesc(id);
	}
	@Override
	public QnA findByqseq(Long qesq) {
		
		return qnaRepo.findByqseq(qesq);
	}

	
	@Override
	public void UpdateQna(QnA qna) {
		
		qna.setReplyyn("y");
		qnaRepo.save(qna);
		
		
	}

	@Override
	public List<QnA> getFindByQgrp(Long qseq) {
	
		System.out.println("getFindByQgrp() : qseq="+qseq);
		return qnaRepo.findQgrp(qseq);
	}



}
