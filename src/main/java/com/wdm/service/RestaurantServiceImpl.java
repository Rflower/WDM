package com.wdm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdm.domain.Restaurant;
import com.wdm.persistence.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restRepo;
	
	@Override
	public List<Restaurant> getRestaurantList(){
		
		return (List<Restaurant>) restRepo.findAll();
	}
	
	@Override
	public Restaurant getRestBoard(Restaurant restaurant) {
		
		return restRepo.findById(restaurant.getRseq()).get();
	}
	/*
	@Override
	public void insertRestaurant(Restaurant restaurant, MultipartFile image1) throws Exception {
	
		String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
		
		UUID uuid = UUID.randomUUID();
		
		String fileName = uuid + "_" + image1.getOriginalFilename();
		
		File saveFile = new File(projectPath, fileName);
		
		image1.transferTo(saveFile);
		
		restReop.save(restaurant);

	}
*/
	@Override
	public void insertRestaurant(Restaurant restaurant) {
		
		restRepo.save(restaurant);
	}
	/*
	@Override
	public boolean confirmAddress(String address_name) {
	
		return restReop.existsByAddress_name(address_name);
	}
	*/

}
