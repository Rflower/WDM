package com.wdm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wdm.domain.Likes;
import com.wdm.domain.Restaurant;
import com.wdm.persistence.LikesRepository;
import com.wdm.persistence.RestaurantRepository;

@Service
public class LikesServiceImpl implements LikesService {

	@Autowired
	private LikesRepository likesRepo;
	
	@Autowired
	private RestaurantRepository restRepo;
	
	
	@Transactional
	@Override
	public int insertLikes(Likes likes, String id) {
		
		// 좋아요가 DB에 저장이 되는것이 없으면 0이 그대로 리턴으로 넘어감
		int result = 0;
		System.out.println("Likes: " + likes);
	
		// 좋아요가 이미 있는지 확인하는 코드
		Optional<Likes> findLikes = likesRepo.findLikesByRseqAndId(likes.getRseq(), id);
		System.out.println("findLikes.isEmpty(): " + findLikes.isEmpty());
	
		// find가 null이면 좋아요가 없는 상태이므로 정보 저장
		// find가 null이 아니면 좋아요가 있는 상태이므로 정보 삭제
		if(findLikes.isEmpty()) {
			
			// insert의 리턴값은 DB에 성공적으로 insert된 갯수를 보내므로 result가 1이 됨	
			likesRepo.save(likes);
			Optional<Restaurant> restaurant= restRepo.findById(likes.getRseq());
			restRepo.plusLikes(restaurant.get().getRseq());
			
			result = 1;
		} else {

			likesRepo.findLikes(likes.getRseq(), id);
			likesRepo.deleteLikes(likes.getRseq(), id);
			
			Optional<Restaurant> restaurant= restRepo.findById(likes.getRseq());
			restRepo.minusLikes(restaurant.get().getRseq());
			
			result = 0;
			}
		System.out.println("find: " + findLikes);
		return result;
	}
}
