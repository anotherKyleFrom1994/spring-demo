package vmt.demo.conf.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "vmt.demo" })
public class WebConfigs implements WebMvcConfigurer {

	/**
	 * Resolve the path and the file extension
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

	// @Bean
	// public ContextCleanupListener listenerRegistration() {
	// ContextCleanupListener cleanupListener = new ContextCleanupListener();
	// ServletContextEvent event = null;
	// cleanupListener.contextInitialized(event);
	// return cleanupListener;
	// }

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