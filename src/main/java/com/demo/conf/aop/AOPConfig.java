package com.demo.conf.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>
 * This is a configuration class that should be imported by the class extend
 * {@code org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer}.
 * In this project is {@code AppInitializer}.
 * </p>
 * 
 * <p>
 * {@code @EnableAspectJAutoProxy} is to notify Spring that there are some AOP
 * classes should be properly processed. The annotation should be used with
 * {@code @Configuration}.
 * </p>
 * 
 * 
 * @author Kyle Lin
 * @see org.springframework.context.annotation.Configuration
 * @see org.springframework.context.annotation.EnableAspectJAutoProxy
 */
@Configuration
@ComponentScan(basePackages = { "vmt.demo.conf.aop" })
@EnableAspectJAutoProxy
public class AOPConfig {

}
