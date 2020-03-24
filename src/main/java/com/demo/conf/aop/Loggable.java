package com.demo.conf.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Basic usage of Java annotation registration. There is a series of tutorial on
 * <a href="https://openhome.cc/Gossip/Java/CustomizeAnnotation.html">
 * Openhome.cc </a>.
 * 
 * @author Kyle Lin
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Loggable {

}
