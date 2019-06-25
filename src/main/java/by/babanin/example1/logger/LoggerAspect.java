package by.babanin.example1.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
    private Logger logger;

    public LoggerAspect(Logger logger) {
        this.logger = logger;
    }

    @Pointcut("execution(* by.babanin.example1.interfaces.Robot.action())")
    public void robotAction() {

    }

    @Before("robotAction()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method begin: " +
                joinPoint.getSignature().toShortString());
    }

    @After("robotAction()")
    public void logAfter() {
        logger.info("Method end;");
    }

    @AfterThrowing(value = "robotAction()", throwing = "ex")
    public void logAfterThrow(Throwable ex) {
        logger.info("AFTER_THR: " + ex);
    }

    @Around("robotAction() " +
            "|| execution(* by.babanin.example1.interfaces.RobotFactory.*(..)) " +
            "|| execution(* by.babanin.example1.interfaces.RobotPool.*(..))")
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
