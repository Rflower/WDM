package com.wdm.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wdm.domain.Restaurant;

public interface RestaurantService {

	//상세보기
	Restaurant getRestBoard(Restaurant restaurant);
	
	//맛집등록하기
	void insertRestaurant(Restaurant restaurant);
	
	//boolean confirmAddress(String address_name);
	
	//관리자 화면 불러오기
	Page<Restaurant> getRestaurantListPaging(Pageable paging);
	
	//검색 리스트
	Page<Restaurant> getSearchCategoryList( String searchKeyword,String orderby,Pageable pageable);
	
	
	int nameChk(String name);
	
	//삭제하기
	void deleteRestaurant(Restaurant restaurant);
}