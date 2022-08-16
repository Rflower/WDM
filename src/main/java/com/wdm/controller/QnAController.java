package com.wdm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wdm.config.SecurityUser;
import com.wdm.domain.QnA;
import com.wdm.service.QnAService;

@Controller

public class QnAController {

	@Autowired
	private QnAService QnAService;
	
	@GetMapping("/QnA")
	public String qnaView( @AuthenticationPrincipal SecurityUser principal, Model model) {
		
		
		List<QnA> qnaListRefId = QnAService.getFindByRefId(principal.getUsername());
		List<QnA> qnaListId = QnAService.getFindById(principal.getUsername());
		
		model.addAttribute("qnaList", qnaListRefId);
		model.addAttribute("qnaListId", qnaListId);

		return "QnA";
	}
	
	
	//Qna 내용 저장
	@GetMapping("/saveQnA")
	public String saveQna(@AuthenticationPrincipal SecurityUser principal, QnA qna) {

		qna.setQdepth(0);
		qna.setQgrp(0L);
		QnAService.SaveQna(qna);
		
		QnA vo = new QnA();
		vo = QnAService.findByqseq(qna.getQseq());
		vo.setQgrp(qna.getQseq());
		vo.setRefid(qna.getId());
		QnAService.SaveQna(vo);
		
		return "redirect:QnA";
	}

	
//	@GetMapping("/qna/list")
//	@ResponseBody
//	public List<QnA> getFindById(String id, @AuthenticationPrincipal SecurityUser principal) {
//		System.out.println("넘겨주는 id ="+id);
//
//		List<QnA> qnaList = QnAService.getFindById(id);
//		return qnaList;
//	}
	
	/*
	@GetMapping("/replyQna/list")
	@ResponseBody
	public Map<String, Object> getQnaReply(String id){
		System.out.println("id는" + id);
		
		Map<String, Object> qnaReplyList =  new HashMap<>();
		
		List<QnA> qnaList = QnAService.getFindByRefId(id);
		
		System.out.println("qseq의 갯수는 = "+qnaList.size());
		List<QnA> adminReply = null;
		
		for(int i =0; i<qnaList.size(); i++) {
			System.out.println(qnaList.get(i).getQseq());
								
			if(qnaList.get(i).getQgrp() != 0 ) {
				adminReply = QnAService.getFindByQgrp(qnaList.get(i).getQgrp());
				qnaReplyList.put("adminReply"+i, adminReply);
			}		
		}
		
		System.out.println("qnaReplyList 의 갯수는 =" + qnaReplyList.size());
//		Object value = qnaReplyList.get("adminReply0" );
//		System.out.println("qnaReplyList 의 value0 =" + qnaReplyList);

		Set<String> key1 = qnaReplyList.keySet();
		for(String key : key1 ) {
			System.out.println(key);
			List<QnA> qnas = (List<QnA>) qnaReplyList.get(key);
			
			for (int i=0; i<qnas.size(); i++) {
				System.out.println(qnas.get(i));
			}
		}
		
//		Collection<Object> values = qnaReplyList.values();	
//		Iterator<Object> it = values.iterator();
//		while(it.hasNext()) {
//			System.out.println("values는" +it.next());
//		}
	
		return qnaReplyList;	

	}*/
}
