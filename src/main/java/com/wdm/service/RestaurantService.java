package com.wdm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wdm.domain.Restaurant;

public interface RestaurantService {
	
	Page<Restaurant> getRestaurantListPaging(Pageable paging);
	
	Page<Restaurant> getSearchCategoryList( String searchKeyword, String orderby, Pageable pageable);
	
}