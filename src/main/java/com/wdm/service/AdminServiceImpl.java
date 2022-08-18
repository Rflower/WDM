package com.wdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wdm.domain.CountById;
import com.wdm.domain.QnA;
import com.wdm.persistence.QnARepository;
import com.wdm.persistence.RestaurantRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private QnARepository qnaRepo;
	@Autowired
	private RestaurantRepository restRepo;
	
	@Override
	public Page<QnA> getAdminQnAList(Pageable pageable) {
		int page = pageable.getPageNumber();
		Pageable paging = PageRequest.of(page, 8);
		Page<QnA> pageList = qnaRepo.adminQnAList(paging);
		
		return pageList;
	}

	@Override
	public List<CountById> getCountById() {
		
		return restRepo.getCountById();
	}
	

	
}
