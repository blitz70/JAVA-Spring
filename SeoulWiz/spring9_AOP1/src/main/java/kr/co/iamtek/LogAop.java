package kr.co.iamtek;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint jointpoint) throws Throwable {
		String signitureStr = jointpoint.getSignature().toShortString();
		System.out.println(signitureStr + " started.");
		long st = System.currentTimeMillis();
		try {
			Object obj = jointpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signitureStr + " ended, duration : "+ (et - st));
		}
	}

}
