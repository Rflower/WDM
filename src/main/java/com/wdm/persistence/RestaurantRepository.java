package com.wdm.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wdm.domain.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	
	
	//관리자 화면에서 전체 글 불러오기 할때 필요
	@Query("SELECT r FROM Restaurant r ORDER BY r.rseq ASC")
	Page<Restaurant> getRestaurantListPaging(Pageable paging);
	

	@Query(value="SELECT * FROM restaurant  WHERE MENU LIKE '%'||?1||'%' OR DONG LIKE'%'||?1||'%' ", nativeQuery=true)
	Page<Restaurant> getDongAndMenuSearchList(String searchKeyword, Pageable pageable);
	
	//boolean existsByAddress_name(String address_name);
}
