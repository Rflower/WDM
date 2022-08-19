package com.wdm.service;

import java.util.Optional;

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

	@Override
	public String findIdResult(String id, String email) {
		String resultId = memberRepo.findIdResult(id, email);
		
		return resultId;
	}

	@Override
	public String findPwdResult(String id, String name, String email) {
		String resultPwd = memberRepo.findPwdResult(id, name, email);
		
		return resultPwd;
	}

	@Override
	public void changePwd(String pwd, String id) {
		
		Optional<Member> findId = memberRepo.findById(id);
		Member member = findId.get();
		member.setPwd(pwd);
		
		memberRepo.save(member);
		
	}

}
