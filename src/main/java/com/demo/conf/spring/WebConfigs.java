package com.demo.conf.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * DispatcherServlet is packed by Spring here, as you can configure the options
 * in this class.
 * 
 * By annotated {@code @EnableWebMvc}, Spring container considers the default
 * values is set. i.e. It'll fill up the attributes to fulfill the mandatory
 * columns when initializing the container.
 * 
 * You can override the methods from the super class, also can you override the
 * classes responsible for the functions, and use {@code @Bean} to expose them.
 * 
 * @author Kyle Lin
 */
@Configuration
@EnableWebMvc
// @ComponentScan(basePackages = { "com.demo" })
@ComponentScan(basePackages = { "com.demo" }, excludeFilters = {
		@Filter(type = FilterType.REGEX, pattern = { "com.demo.conf.db", "dao" }) })
public class WebConfigs implements WebMvcConfigurer {

	/**
	 * Resolve the path and the file extension (e.g. when you use the path as
	 * "home", it'll be resolved to "/WEB-INF/views/home.jsp")
	 * 
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	/**
	 * A simple way to register a controller, as there's no other request or
	 * response action must be handled.
	 * 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		ViewControllerRegistration home = registry.addViewController("/");
		home.setViewName("home");

		ViewControllerRegistration login = registry.addViewController("/login");
		login.setViewName("login");

		ViewControllerRegistration error = registry.addViewController("*");
		error.setViewName("error_page");
		error.setStatusCode(HttpStatus.NOT_FOUND);

	}

	// /**
	// * There is also a feature supports Cross-Origin Resource Sharing(CORS).
	// *
	// * @see
	// org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
	// */
	// @Override
	// public void addCorsMappings(CorsRegistry registry) {
	// registry.addMapping("/**").allowedMethods("GET", "POST");
	// }

	// @Bean
	// public MessageSource messageSource() {
	// ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	// source.setBasename("messages");
	// return source;
	// }
	//
	// @Override
	// public Validator getValidator() {
	// LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	// validator.setValidationMessageSource(messageSource());
	// return validator;
	// }

	// @Bean
	// public HttpMessageConverter<String> responseBodyConverter() {
	// StringHttpMessageConverter converter = new
	// StringHttpMessageConverter(Charset.forName("UTF-8"));
	// return converter;
	// }
	//
	// @Override
	// public void configureMessageConverters(List<HttpMessageConverter<?>>
	// converters) {
	// converters.add(responseBodyConverter());
	// }
}