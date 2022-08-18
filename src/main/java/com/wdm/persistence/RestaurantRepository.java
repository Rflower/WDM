package com.wdm.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wdm.domain.CountById;
import com.wdm.domain.Likes;
import com.wdm.domain.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	
	//관리자 화면에서 전체 글 불러오기 할때 필요
	@Query("SELECT r FROM Restaurant r ORDER BY r.rseq desc")
	Page<Restaurant> getRestaurantListPaging(Pageable paging);
	
	@Query(value="SELECT * FROM Restaurant  WHERE MENU LIKE '%'||?1||'%' OR DONG LIKE'%'||?1||'%' ", nativeQuery=true)
	Page<Restaurant> getSearchCategoryList(String searchKeyword, Pageable pageable);
	
	@Query(value="SELECT * FROM Restaurant  WHERE MENU LIKE '%'||?1||'%' OR DONG LIKE'%'||?1||'%' AND KIND=?2", nativeQuery=true)
	Page<Restaurant> getKindSearchKeywordList(String searchKeyword, String kind, Pageable pageable);
	
	@Query(value="SELECT * FROM Restaurant  WHERE kind=?1", nativeQuery=true)
	Page<Restaurant> findBykind(String kind, Pageable pageable);
	
	//추천 상위 4개 맛집 불러오기
	@Query(value="SELECT * FROM (SELECT * from restaurant order by likescnt desc) WHERE rownum<=4", nativeQuery=true)
	List<Restaurant> getBestLikescntList();
	
	@Query(value="SELECT COUNT(*) FROM restaurant WHERE name=?1", nativeQuery=true)
	public int nameChk(String name);
	
	@Query(value="SELECT COUNT (*) From member WHERE id=?1", nativeQuery = true)
	public int idCheck(String id);

	@Query(value="SELECT new Likes(a.lseq, a.id, a.rseq) FROM com.wdm.domain.Likes a WHERE a.rseq=?1 AND a.id=?2")
	Likes findLikes(Long rseq, String id);

	@Modifying
	@Query(value="UPDATE restaurant SET likescnt = likescnt + 1 WHERE rseq=?1", nativeQuery=true)
	void plusLikes(Long rseq);
	
	@Modifying
	@Query(value="UPDATE restaurant SET likescnt = likescnt - 1 WHERE rseq=?1", nativeQuery=true)
	void minusLikes(Long rseq);	
	
	//id별로 올린 게시글수 확인하는 관리자 차트 
	@Query(value="SELECT id, count(id) AS countById FROM restaurant group by id", nativeQuery=true)
	List<CountById> getCountById();

}
