package com.wdm.service;

import java.util.List;

import com.wdm.domain.Restaurant;

public interface RestaurantService {

	List<Restaurant> getRestaurantList();

	Restaurant getRestBoard(Restaurant restaurant);
	
	//void insertRestaurant(Restaurant restaurant, MultipartFile image1) throws Exception;
	void insertRestaurant(Restaurant restaurant);
	
	//boolean confirmAddress(String address_name);
}