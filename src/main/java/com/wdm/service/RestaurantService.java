package com.wdm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wdm.domain.Restaurant;

public interface RestaurantService {

	//상세보기
	Restaurant getRestBoard(Restaurant restaurant);
	
	//맛집등록하기
	void insertRestaurant(Restaurant restaurant);
	
	//boolean confirmAddress(String address_name);

	Page<Restaurant> getRestaurantListPaging(Pageable paging);
	
	Page<Restaurant> getSearchCategoryList( String searchKeyword,String orderby,Pageable pageable);

	//추천 상위 4개 맛집 출력
	List<Restaurant> getBestLikescntList();
}