package com.wdm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wdm.domain.CountById;
import com.wdm.domain.QnA;

public interface AdminService {

	Page<QnA> getAdminQnAList(Pageable pageable);

	List<CountById> getCountById();
}
