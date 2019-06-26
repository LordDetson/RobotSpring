package by.babanin.example2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class LoggerAspect {
    private Logger logger;

    public LoggerAspect(Logger logger) {
        this.logger = logger;
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

    public void printMap(Object o) {
        System.out.println("Print info begin >>");

        Map map = (Map) o;
        for (Object object : map.keySet()) {
            System.out.println("key=" + object + ", " + map.get(object));
        }

        System.out.println("Print info end <<");
        System.out.println();
    }

    public void printSet(Object o) {
        System.out.println("Print info begin >>");

        Set set = (Set) o;
        for (Object object : set) {
            System.out.println(object);
        }

        System.out.println("Print info end <<");
        System.out.println();
    }
}
