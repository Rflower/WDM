package com.wdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wdm.domain.Restaurant;
import com.wdm.persistence.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restRepo;

	
	//rseq값으로 맛집 상세보기
	@Override
	public Restaurant WDMDetail(Restaurant restaurant) {
		
		return restRepo.findById(restaurant.getRseq()).get();
	}

	@Override
	public void insertRestaurant(Restaurant restaurant) {
		
		restRepo.save(restaurant);
	}

	//관리자화면에서 사용할 맛집 전체 보기 리스트
	@Override
	public Page<Restaurant> getRestaurantListPaging(Pageable pageable) {
		int page = pageable.getPageNumber();
		
		Pageable paging = PageRequest.of(page, 8); 
		
		Page<Restaurant> pageList = restRepo.getRestaurantListPaging(paging);

		return pageList;
	}

	//검색창에서 메뉴,동 검색. 추천순,최신순 정렬 리스트 
	@Override
	public Page<Restaurant> getSearchCategoryList(String searchKeyword,String orderby,Pageable pageable) {
		int page = pageable.getPageNumber();
		Pageable paging = PageRequest.of(page, 8, Sort.by(Sort.Direction.DESC, orderby));
		
		Page<Restaurant> pageList = restRepo.getSearchCategoryList(searchKeyword, paging);
		
		return pageList;
	}

	@Override
	public int nameChk(String name) {
		int cnt = restRepo.nameChk(name);
		return cnt;
	}

	@Override
	public void deleteRestaurant(Restaurant restaurant) {
		
		restRepo.deleteById(restaurant.getRseq());
	}

	@Override
	public List<Restaurant> getBestLikescntList() {
	
		return restRepo.getBestLikescntList();
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {

		Restaurant findRest = restRepo.findById(restaurant.getRseq()).get();
		
		findRest.setName(restaurant.getName());
		findRest.setKind(restaurant.getKind());
		findRest.setMenu(restaurant.getMenu());
		findRest.setAddress_name(restaurant.getAddress_name());
		findRest.setAddress_detail(restaurant.getAddress_detail());
		findRest.setDong(restaurant.getDong());
		findRest.setContent(restaurant.getContent());
		findRest.setImage1(restaurant.getImage1());
		findRest.setImage2(restaurant.getImage2());
		findRest.setImage3(restaurant.getImage3());
		
		System.out.println("findRest: " + findRest);
		restRepo.save(findRest);
		
	}

	@Override
	public Page<Restaurant> getKindSearchKeywordList(String searchKeyword, String kind, String orderby, Pageable pageable) {
		int page = pageable.getPageNumber();
		Pageable paging = PageRequest.of(page, 8, Sort.by(Sort.Direction.DESC, orderby));
		System.out.println("kind의 값은? = " + kind);
		System.out.println("searchKeyword의 값은? = " + searchKeyword);
	
		Page<Restaurant> pageList = restRepo.getKindSearchKeywordList(searchKeyword, kind, paging);

		return pageList;
	}

	@Override
	public Page<Restaurant> getfindBykind(String kind, Pageable pageable){ 
		
		int page = pageable.getPageNumber();
		Pageable paging = PageRequest.of(page, 8);
		
		Page<Restaurant> pageList = restRepo.findBykind(kind, paging);
		return pageList;
	}

}

