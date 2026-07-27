package com.example.logistics.config;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;import org.slf4j.*;import org.springframework.stereotype.Component;
@Aspect @Component
public class LoggerAspect{
private static final Logger log=LoggerFactory.getLogger(LoggerAspect.class);
@Around("execution(* com.example.logistics.service..*(..))")
public Object logMethod(ProceedingJoinPoint p)throws Throwable{
log.info("Entering: {}",p.getSignature().getName());
Object r=p.proceed();
log.info("Exiting: {}",p.getSignature().getName());
return r;
}
}
