package vmt.demo.conf.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "vmt.demo" })
public class WebConfigs implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
//		source.setBasename("messages");
//		return source;
//	}
//
//	@Override
//	public Validator getValidator() {
//		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//		validator.setValidationMessageSource(messageSource());
//		return validator;
//	}

//	@Bean
//	public HttpMessageConverter<String> responseBodyConverter() {
//		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//		return converter;
//	}
//
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(responseBodyConverter());
//	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST");
	}
}