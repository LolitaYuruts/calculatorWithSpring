package aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.time.LocalDateTime;

@org.aspectj.lang.annotation.Aspect
public class Aspect {

    private Logger logger = Logger.getLogger(this.getClass());

    @Pointcut("@annotation(LogAnnotation)")
    public void logAnnotationPointCut() {
    }

    @Before("logAnnotationPointCut()")
    public void logStartTime() {
        logger.info("The start of the method");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("The start of the method: " + now);
    }


    @After("logAnnotationPointCut()")
    public void logFinishTime() {
        logger.info("The end of the method");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("The end of the method: " + now);
    }
}
