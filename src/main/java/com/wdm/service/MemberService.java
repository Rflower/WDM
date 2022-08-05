package com.wdm.service;

import com.wdm.domain.Member;

public interface MemberService {

	void joinMember(Member member);

	int idCheck(String id);

	int nicknameCheck(String nickname);

	int emailCheck(String email);



}