package kr.co.iamtek;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		//before Pointcut
		String signitureStr = joinPoint.getSignature().toShortString();
		System.out.println(signitureStr + " started.");
		long st = System.currentTimeMillis();
		try {
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			//after Pointcut
			long et = System.currentTimeMillis();
			System.out.println(signitureStr + " ended, duration : "+ (et - st));
		}
	}
	
	public void beforeAdvice(JoinPoint joinPoint) {
		String signitureStr = joinPoint.getSignature().toShortString();
		System.out.println(signitureStr + " beforeAdvice()");
	}
	
	public void afterReturningAdvice(JoinPoint joinPoint) {
		String signitureStr = joinPoint.getSignature().toShortString();
		System.out.println(signitureStr+" afterReturningAdvice()");
	}
	
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}
	
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}

}
