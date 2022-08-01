package com.wdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdm.domain.Restaurant;
import com.wdm.persistence.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restReop;
	
	@Override
	public List<Restaurant> getRestaurantList(){
		
		return (List<Restaurant>) restReop.findAll();
	}
}
