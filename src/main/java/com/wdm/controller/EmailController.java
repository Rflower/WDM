package com.wdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wdm.domain.AuthEmail;
import com.wdm.service.MailSendService;

@RestController
public class EmailController {

	@Autowired
	private MailSendService mss;
	
	@RequestMapping(value = "/mail", produces = "application/json; charset=UTF-8")
    public String mailSend(@RequestParam("email") String email){
		System.out.println("이메일 인증 "+email);
		
	       //임의의 authKey 생성 & 이메일 발송
	    String authKey = mss.sendAuthMail(email);
	    System.out.println(authKey);

		return email;

 	}
	
	@GetMapping("/authCheckEmail")
	public int authCheckEmail(@RequestParam("authKey") String authKey,
								@RequestParam("email") String email) {
		int result = 0;
		
		System.out.println("이메일>>>>>>>>>>>>>"+ email);
		System.out.println("인증키>>>>>>>>>>>>>"+ authKey);
		String authKeyDB = mss.findkey(email);
		
		System.out.println("디비 인증키>>>>>>>>>>>"+authKeyDB);

		if(authKey.equals(authKeyDB)) {
			result = 1;
			
		}else {
			result = 0;
		}
		
		System.out.println("리턴 결과>>>>>>>>>>>>>"+result);
		return result;
	}
}
	

