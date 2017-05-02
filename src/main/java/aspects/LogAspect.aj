package aspects;

import org.apache.log4j.Logger;

/**
 * Created by Alisa on 5/2/2017.
 */
public aspect LogAspect {
    pointcut tracePublicMethods(): execution(public * *(..));

    before() : tracePublicMethods() {
        final Logger logger = Logger.getLogger("My log");
        logger.info(thisJoinPoint.getSignature() + " - started");
    }

    after() : tracePublicMethods() {
        final Logger logger = Logger.getLogger("My log");
        logger.info(thisJoinPoint.getSignature() + " - ended");
    }
}
