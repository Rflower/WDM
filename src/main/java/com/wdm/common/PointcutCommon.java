package com.wdm.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {


	@Pointcut("execution(* com.wdm..*Impl.get*(..))")
	public void getPointcut() {
		
	}
	@Pointcut("execution(* com.wdm..*Impl.*(..))")
	public void allPointcut() {
		
	}

}
