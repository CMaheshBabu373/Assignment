package com.test.Task;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogMethodParamAspect {
	@Around("@annotation(LogMethodParam)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	     	 
		     Object proceed = joinPoint.proceed();
		     Object args[] = joinPoint.getArgs();
		     System.out.println("Parameters passed to Method are : " + Arrays.toString(args));
		     return proceed;
		 }
	
}
