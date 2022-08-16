package com.wdm.service;

import com.wdm.domain.Member;

public interface MemberService {

	void joinMember(Member member);

	int idCheck(String id);

	int nicknameCheck(String nickname);

	int emailCheck(String email);

	String findIdResult(String id, String email);

	String findPwdResult(String id, String name, String email);

	void changePwd(String pwd, String id);
	
}