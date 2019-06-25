package by.babanin.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LoggerAspect {
    private Logger logger;

    public LoggerAspect(Logger logger) {
        this.logger = logger;
    }

    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method begin: " +
                joinPoint.getSignature().toShortString());
    }

    public void logAfter() {
        logger.info("Method end;");
    }

    public void logAfterThrow(Throwable ex) {
        logger.info("AFTER_THR: " + ex);
    }

    public Object watchTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object output = null;
        try {
            output = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long time = System.currentTimeMillis() - start;
        logger.info("Method: " + joinPoint.getSignature().toShortString() +
                "; time=" + time + " ms");
        return output;
    }
}
