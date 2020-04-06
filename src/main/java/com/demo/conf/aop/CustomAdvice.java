package com.demo.conf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * <p>
 * This is the implementation of {@code @Loggable}. The body of the before and
 * after method, that registered as before and after the annotated method
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
 * {@code @Aspect} is a registration to notify Spring this is an joint point to
 * be watched.
 * </p>
 * <p>
 * {@code @Component} is to notify Spring this is a dependency that should be
 * registered to execute Dependency Inject(DI).
 * </p>
 * 
 * @author Kyle Lin
 * 
 * @see AOPConfig
 * @see Loggable
 * @see org.springframework.context.annotation.EnableAspectJAutoProxy
 */
@Aspect
@Component
public class CustomAdvice {
	private static final String ANNOTATION_TAG = "@annotation";
	private static final String EXECUTION_TAG = "execution";

	private static final String START_BRACKET = "(";
	private static final String END_BRACKET = ")";

	private static final String loggerInterface = "com.demo.conf.aop.Loggable";

	/**
	 * Before entering the joint point. Which means before the annotated method
	 * start.
	 * 
	 * @param joinPoint
	 */
	@Before(ANNOTATION_TAG + START_BRACKET + loggerInterface + END_BRACKET) // @annotation(com.demo.conf.aop.Loggable)
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
	 * After leaving the joint point. Which means after the annotated method start.
	 * 
	 * @param joinPoint
	 */
	@After(ANNOTATION_TAG + START_BRACKET + loggerInterface + END_BRACKET) // @annotation(com.demo.conf.aop.Loggable)
	public void afterLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("After running loggingAdvice on method=" + methodName);
	}

	/**
	 * Around the joint point execution. Which means before and after the annotated
	 * method executed.
	 * 
	 * @param joinPoint
	 */
	// @Around(ANNOTATION_TAG + START_BRACKET + loggerInterface + END_BRACKET) //
	// @annotation(com.demo.conf.aop.Loggable)
	// public void aroundLogging(JoinPoint joinPoint) {
	// String methodName = joinPoint.getSignature().getName();
	// System.out.println("LoggingAdvice on method=" + methodName);
	// }

}