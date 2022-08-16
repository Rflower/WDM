package com.wdm.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforAdvice {

	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		
		Object args[] = jp.getArgs();
		
		if(args.length == 0) {
			System.out.printf("[사전 처리] 메소드명 : %s() Args : 없음\n", method);
			
		}else {
			System.out.printf("[사전 처리] 메소드명 : %s() Args : %s\n", method,args[0].toString());
		}
	}
}
