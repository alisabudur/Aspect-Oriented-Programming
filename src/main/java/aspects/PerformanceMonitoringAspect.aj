package aspects;

import org.apache.log4j.Logger;

/**
 * Created by Alisa on 5/13/2017.
 */
public aspect PerformanceMonitoringAspect {
    private Logger logger = Logger.getLogger("Performance");

    pointcut performancePublicMethods(): execution(public * *(..));

    Object around(): performancePublicMethods(){
        long start = System.nanoTime();
        try {
            return proceed();
        } finally {
            long complete = System.nanoTime();
            logger.info("Operation " + thisJoinPointStaticPart.getSignature().toShortString()
                    + " took " + (complete - start) + " nanoseconds");
        }
    }
}
