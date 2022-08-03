package com.wdm.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wdm.domain.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	
	//관리자 전체 페이지 보기
	@Query("SELECT r FROM Restaurant r ORDER BY r.rseq ASC")
	Page<Restaurant> getRestaurantListPaging(Pageable paging);
	

	//동,메뉴로 검색 및 추천순, 최신순 orderby
	@Query(value="SELECT * FROM restaurant  WHERE MENU LIKE '%'||?1||'%' OR DONG LIKE'%'||?1||'%' ", nativeQuery=true)
	Page<Restaurant> getSearchCategoryList(String searchKeyword, Pageable pageable);
	

}
