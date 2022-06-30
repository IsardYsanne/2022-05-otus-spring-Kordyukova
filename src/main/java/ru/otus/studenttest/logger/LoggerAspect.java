package ru.otus.studenttest.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Аспект для логгера.
 */
@Aspect
@Component
public class LoggerAspect {

    private static final Logger logger = LoggerFactory.getLogger("");

    @Before("within(ru.otus.studenttest..*)")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Вызван метод: " + joinPoint.getSignature().toShortString());
    }
}
