package com.wdm.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wdm.domain.Likes;

public interface LikesRepository extends CrudRepository<Likes, Long> {
	
	Optional<Likes> findLikesByRseqAndId(Long rseq, String id);
	
	@Query(value="INSERT INTO likes(rseq, id) VALUES (rseq=?1, id=?2)", nativeQuery = true)
	int insertLikes(Long rseq, String id);

	int countByLseq(int lseq);

	@Query(value="SELECT * FROM likes WHERE rseq=?1 AND id=?2", nativeQuery = true)
	Likes findLikes(Long rseq, String id);

	@Modifying
	@Query(value="DELETE FROM likes WHERE rseq=?1 AND id=?2", nativeQuery = true)
	void deleteLikes(Long rseq, String id);
	
	@Query(value="SELECT * FROM likes WHERE rseq=?1 AND id=?2", nativeQuery = true)
	Likes findByRseqAndId(Long rseq, String id);
	

}