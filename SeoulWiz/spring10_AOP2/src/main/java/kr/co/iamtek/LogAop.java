package kr.co.iamtek;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {

//	@Pointcut("execution(public void get*(..))")	// public void인 모든 get메소드
//	@Pointcut("execution(* kr.co.iamtek.*.*())")	// kr.co.iamtek 패키지에 파라미터가 없는 모든 메소드
//	@Pointcut("execution(* kr.co.iamtek..*.*())")	// kr.co.iamtek 패키지 & com.javalec.ex 하위 패키지에 파라미터가 없는 모든 메소드
//	@Pointcut("execution(* kr.co.iamtek.Worker.*())")	// kr.co.iamtek.Worker 안의 파라미터가 없는 모든 메소드
//
//	@Pointcut("within(kr.co.iamtek.*)")	//kr.co.iamtek 패키지 안에 있는 모든 메소드
//	@Pointcut("within(kr.co.iamtek..*)")  //kr.co.iamtek 패키지 및 하위 패키지 안에 있는 모든 메소드
//	@Pointcut("within(kr.co.iamtek.Worker)") //kr.co.iamtek.Worker 모든 메소드
//
//	@Pointcut("bean(student)")	//student 빈에만 적용
	@Pointcut("bean(*ker)")	//ker로 끝나는 빈에만 적용
//	@Pointcut("within(kr.co.iamtek.*)")
	private void pointcutMethod() {
	}
	
	@Around("pointcutMethod()")		//using with @Pointcut, will apply only to Worker
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
	
	@Before("within(kr.co.iamtek.Student)")		//without @Pointcut, will apply only to Student
	public void beforeAdvice(JoinPoint joinPoint) {
		String signitureStr = joinPoint.getSignature().toShortString();
		System.out.println(signitureStr + " beforeAdvice()");
	}

}
