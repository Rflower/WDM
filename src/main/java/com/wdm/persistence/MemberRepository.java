package com.wdm.persistence;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.wdm.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

	@Query(value="SELECT COUNT (*) From member WHERE id=?1", nativeQuery = true)
	public int idCheck(String id);

	@Query(value="SELECT COUNT (*) From member WHERE nickname=?1", nativeQuery = true)
	public int nicknameCheck(String nickname);

	@Query(value="SELECT COUNT (*) From member WHERE email=?1", nativeQuery = true)
	public int emailCheck(String email);
	
	@Query(value="SELECT id From member WHERE name=?1 AND email=?2", nativeQuery = true)
	public String findIdResult(String name, String email);

	@Query(value="SELECT pwd From member WHERE id=?1 AND name=?2 AND email=?3", nativeQuery = true)
	public String findPwdResult(String id, String name, String email);


}