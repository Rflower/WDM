package com.wdm.service;

import java.util.List;

import com.wdm.domain.QnA;

public interface QnAService {

	void SaveQna(QnA qna);
	
	List<QnA> getFindById(String id);
	
	List<QnA> getFindByRefId(String id);
	
	QnA findByqseq(Long qesq);
	
	void UpdateQna(QnA qna);
	
	List<QnA> getFindByQgrp(Long qseq);
}
