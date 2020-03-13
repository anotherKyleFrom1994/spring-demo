package vmt.demo.conf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingHandler {
	private static final String annotationStart = "@annotation(";
	private static final String annotationEnd = ")";
	private static final String loggerInterface = "vmt.demo.conf.aop.Loggable";

	@Before(annotationStart + loggerInterface + annotationEnd)
	public void beforeLogging(JoinPoint joinPoint) {
		Object target = joinPoint.getTarget();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("Before running loggingAdvice on method=" + methodName);
		// Logger.getLogger(target.getClass().getName())
		// .info(String.format("%s.%s(%s)",
		// target.getClass().getName(), methodName, Arrays.toString(args)));
	}

	@After(annotationStart + loggerInterface + annotationEnd)
	public void afterLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("After running loggingAdvice on method="+ methodName);
	}

}