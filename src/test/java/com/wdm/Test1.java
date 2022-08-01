package com.wdm;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wdm.domain.Restaurant;
import com.wdm.persistence.RestaurantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {

	@Autowired
	private RestaurantRepository rRepo;
	
	@Test
	public void TestgetRestaurantListAll() {
	
		List<Restaurant> rList = (List<Restaurant>) rRepo.findAll();
		for(Restaurant item : rList) {
			System.out.println(item);
		}
	}
}
