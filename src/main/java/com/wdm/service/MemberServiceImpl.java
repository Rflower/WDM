package com.wdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wdm.domain.Member;
import com.wdm.domain.Role;
import com.wdm.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void joinMember(Member member) {
		member.setPwd(encoder.encode(member.getPwd()));
		member.setSocialyn('n');
		member.setRole(Role.ROLE_MEMBER);
		
		memberRepo.save(member);

	}

	@Override
	public int idCheck(String id) {
		int cnt = memberRepo.idCheck(id);
		
		return cnt;
	}

	@Override
	public int nicknameCheck(String nickname) {
		int cnt = memberRepo.nicknameCheck(nickname);

		return cnt;
	}

	@Override
	public int emailCheck(String email) {
		int cnt = memberRepo.emailCheck(email);
		
		return cnt;
	}


}
