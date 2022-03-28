package com.bookstore.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This class is aspect, it will log the request.
 * 
 * @author Muthukumar Chellappa
 *
 */

@Aspect
@Component
public class LoggingAspect {

	private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	/* @Before("execution (* com.bookstore.book.transferobjects.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		if (joinPoint.getArgs().length == 0) {
			log.info("Request Payload : ");
		} else {
			log.info("Request Payload : {} " + joinPoint.getArgs()[0]);
		}
	} */

}