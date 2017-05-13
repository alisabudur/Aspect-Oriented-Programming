package aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Alisa on 5/13/2017.
 */
@Aspect
public class PerformanceMonitoringAspect {
    private Logger logger = Logger.getLogger("Performance");

    @Pointcut("execution(public * *(..))")
    public void performancePublicMethods(){}

    @Around("performancePublicMethods()")
    public Object getPerformance(ProceedingJoinPoint jp){
        long start = System.nanoTime();
        try {
            return jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            long complete = System.nanoTime();
            logger.info("Operation " + jp.getSignature().toShortString()
                    + " took " + (complete - start) + " nanoseconds");
        }
        return null;
    }
}
