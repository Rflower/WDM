package com.wdm.service;

import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.wdm.domain.AuthEmail;
import com.wdm.persistence.EmailRepository;

@Service("mss")
public class MailSendService {

	@Autowired
	private EmailRepository emailRepo;
	
	@Autowired
    private JavaMailSenderImpl mailSender;
	private int size;
	
	//인증키 생성
    private String getKey(int size) {
        this.size = size;
        return getAuthCode();
    }
	
    //인증코드 난수 발생
    private String getAuthCode() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }

        return buffer.toString();
    }
	
	//인증메일 보내기
    public String sendAuthMail(String email) {
        //6자리 난수 인증번호 생성
        String authKey = getKey(6);

        //인증메일 보내기
        try {
            MailUtils sendMail = new MailUtils(mailSender);
            sendMail.setSubject("회원가입 이메일 인증");
            sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
            .append("<p>아래 코드를 회원가입창에 입력하세요</p>")
            .append("<h2>")
            .append(authKey)
            .append("</h2>")
//            .append("<a href='http://localhost:9080/member/signUpConfirm?email=")
//            .append(email)
//            .append("&authKey=")
//            .append(authKey)
//            .append("' target='_blenk'>이메일 인증 확인</a>")
            .toString());
            sendMail.setFrom("wdm@wdm.com", "우동맛");
            sendMail.setTo(email);
            sendMail.send();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        AuthEmail authEmail = new AuthEmail();
        
        authEmail.setAuthKey(authKey);
        authEmail.setEmail(email);
        
        emailRepo.save(authEmail);
        
        return authKey;
    }
    
    public String findkey(String email) {
    	
    	return emailRepo.findkey(email);
    }
    
}



