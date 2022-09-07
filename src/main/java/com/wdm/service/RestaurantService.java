package com.wdm.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wdm.domain.Restaurant;

public interface RestaurantService {

	//상세보기
	Restaurant WDMDetail(Restaurant restaurant);
	
	//맛집등록하기
	void insertRestaurant(Restaurant restaurant);

	//전체 맛집 보기
	Page<Restaurant> getRestaurantListPaging(String orderby,Pageable paging);
	
	//키워드,추천,좋아요 순으로 맛집 보기
	Page<Restaurant> getSearchCategoryList( String searchKeyword, String orderby,Pageable pageable);
	
	//키워드, 맛집 종류, 추천, 좋아요 순으로 맛집 보기
	Page<Restaurant> getKindSearchKeywordList(String searchKeyword, String kind, String orderby, Pageable pageable);

	int nameChk(String name);
	
	//삭제하기
	void deleteRestaurant(Restaurant restaurant);

	// 수정하기
	void updateRestaurant(Restaurant restaurant);
	
	//추천 상위 4개 맛집 출력
	List<Restaurant> getBestLikescntList();
	
	Page<Restaurant> getRestaurantMyList(String id, Pageable pageable);
	
	Restaurant myWDMDetail(Restaurant restaurant);

}