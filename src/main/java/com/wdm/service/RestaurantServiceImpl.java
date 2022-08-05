package com.wdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wdm.domain.Restaurant;
import com.wdm.persistence.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restRepo;
	
	//rseq값으로 맛집 상세보기
	@Override
	public Restaurant getRestBoard(Restaurant restaurant) {
		
		return restRepo.findById(restaurant.getRseq()).get();
	}

	@Override
	public void insertRestaurant(Restaurant restaurant) {
		
		restRepo.save(restaurant);
	}

	//관리자화면에서 사용할 맛집 전체 보기 리스트
	@Override
	public Page<Restaurant> getRestaurantListPaging(Pageable pageable) {
		int page = pageable.getPageNumber();
		
		Pageable paging = PageRequest.of(page, 8); 
		
		Page<Restaurant> pageList = restRepo.getRestaurantListPaging(paging);

		return pageList;
	}

	//검색창에서 메뉴,동 검색. 추천순,최신순 정렬 리스트 
	@Override
	public Page<Restaurant> getSearchCategoryList(String searchKeyword,String orderby,Pageable pageable) {
		int page = pageable.getPageNumber();
		Pageable paging = PageRequest.of(page, 8, Sort.by(Sort.Direction.DESC, orderby));
		
		Page<Restaurant> pageList = restRepo.getSearchCategoryList(searchKeyword, paging);
		
		return pageList;
	}

	@Override
	public List<Restaurant> getBestLikescntList() {
	

		return restRepo.getBestLikescntList();
	}
	
	
}
