package com.test.service;

import java.util.UUID;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;

@Aspect
@Component
public class LogBeforeMethodAspect {
	
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LogBeforeMethodAspect.class);

    @Before("@annotation(LogBeforeMethod)")
    public void logBeforeMethodCall(JoinPoint joinPoint) {
        // Generate a trace ID
        String traceId = UUID.randomUUID().toString();

        // Get method signature
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        // Log method call information with trace ID
        logger.info("TraceID: {}, Entering method {} in class {}", traceId, methodName, className);
    }

}
