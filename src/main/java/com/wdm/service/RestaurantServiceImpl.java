package com.wdm.service;

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

	@Override
	public Restaurant getRestBoard(Restaurant restaurant) {
		
		return restRepo.findById(restaurant.getRseq()).get();
	}

	@Override
	public void insertRestaurant(Restaurant restaurant) {
		
		restRepo.save(restaurant);
	}

	@Override
	public Page<Restaurant> getRestaurantListPaging(Pageable pageable) {
		int page = pageable.getPageNumber();
		
		Pageable paging = PageRequest.of(page, 8); 
		
		Page<Restaurant> pageList = restRepo.getRestaurantListPaging(paging);

		return pageList;
	}
	
	@Override
	public Page<Restaurant> getSearchCategoryList(String searchKeyword, String orderby, Pageable pageable) {
		int page = pageable.getPageNumber();
		Pageable paging = PageRequest.of(page, 8, Sort.by(Sort.Direction.DESC, orderby));
		
		Page<Restaurant> pageList = restRepo.getDongAndMenuSearchList(searchKeyword, paging);
		
		return pageList;
	}
}
