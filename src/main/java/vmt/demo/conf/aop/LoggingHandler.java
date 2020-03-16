package vmt.demo.conf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * <p>
 * This is the implementation of the {@code @interface}. The body of the before
 * and after method, that registered as before and after the annotated method
 * executed.
 * </p>
 * 
 * The usage might be like this:
 * 
 * <pre class="code">
 * &#064;Loggable
 * public String foo() {
 * 	// do somthing......
 * }
 * </pre>
 * <p>
 * {@code @Aspect} is a registration to notify Spring this is an aspect to be
 * watched.
 * </p>
 * <p>
 * {@code @Component} is to notify Spring this is a dependency that should be
 * registered to execute Dependency Inject(DI).
 * </p>
 * 
 * @author Kyle Lin
 * @see AOPConfig
 * @see Loggable
 */
@Aspect
@Component
public class LoggingHandler {
	private static final String annotationStart = "@annotation(";
	private static final String annotationEnd = ")";
	private static final String loggerInterface = "vmt.demo.conf.aop.Loggable";

	/**
	 * Before entering the joint point. Which means before the annotated method
	 * start.
	 * 
	 * @param joinPoint
	 */
	@Before(annotationStart + loggerInterface + annotationEnd)
	public void beforeLogging(JoinPoint joinPoint) {
		// Object target = joinPoint.getTarget();
		String methodName = joinPoint.getSignature().getName();
		// Object[] args = joinPoint.getArgs();
		System.out.println("Before running loggingAdvice on method=" + methodName);
		// Logger.getLogger(target.getClass().getName())
		// .info(String.format("%s.%s(%s)",
		// target.getClass().getName(), methodName, Arrays.toString(args)));
	}

	/**
	 * After entering the joint point. Which means after the annotated method start.
	 * 
	 * @param joinPoint
	 */
	@After(annotationStart + loggerInterface + annotationEnd)
	public void afterLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("After running loggingAdvice on method=" + methodName);
	}

}