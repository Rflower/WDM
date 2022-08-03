package com.wdm.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wdm.domain.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	

	@Query(value="SELECT rseq FROM Restaurant WHERE dong like '%'||?1||'%' ORDER BY seq DESC", nativeQuery=true)
	List<Restaurant> getRestaurantList(String keyword);
	
	//관리자 화면에서 전체 글 불러오기 할때 필요
	@Query(value ="select * From restaurant ", nativeQuery = true)
	List<Restaurant> getRestaurantListAll();
	
	//boolean existsByAddress_name(String address_name);
}
