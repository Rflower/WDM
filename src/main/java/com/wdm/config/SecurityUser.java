package com.wdm.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.wdm.domain.Member;

/*
 * Member 객체를 userDetails 타입으로 변환하는 클래스
 */
public class SecurityUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Member member;

	public SecurityUser(Member member) {
		//테이블에서 검색한 member 정보를 SecurityUser 클래스 전달 
		super(member.getId(), member.getPwd(), 
			AuthorityUtils.createAuthorityList(member.getRole().toString()));

		this.member = member;
	}

	public Member getMember() {
		return member;
	}
	
}
