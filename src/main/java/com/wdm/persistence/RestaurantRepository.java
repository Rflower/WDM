package com.wdm.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wdm.domain.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	
	//관리자 화면에서 전체 글 불러오기 할때 필요
	@Query("SELECT r FROM Restaurant r ORDER BY r.rseq ASC")
	Page<Restaurant> getRestaurantListPaging(Pageable paging);
	
	@Query(value="SELECT * FROM Restaurant  WHERE MENU LIKE '%'||?1||'%' OR DONG LIKE'%'||?1||'%' ", nativeQuery=true)
	Page<Restaurant> getSearchCategoryList(String searchKeyword, Pageable pageable);
	
	//추천 상위 4개 맛집 불러오기
	@Query(value="SELECT * FROM (SELECT * from restaurant order by likescnt desc) WHERE rownum<=4", nativeQuery=true)
	List<Restaurant> getBestLikescntList();
	
	
	//boolean existsByAddress_name(String address_name);
}
