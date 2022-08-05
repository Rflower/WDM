package com.wdm.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wdm.domain.Member;
import com.wdm.persistence.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Member> findMember = memberRepo.findById(username);
		
		if (!findMember.isPresent()) {
			throw new UsernameNotFoundException(username +"사용자 없음");

		}else {			
			Member member = findMember.get();
			System.out.println(member);
			return new SecurityUser(member);
		}
	}

}
