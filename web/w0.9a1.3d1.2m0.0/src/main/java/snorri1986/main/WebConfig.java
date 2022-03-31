package snorri1986.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Description: configuratrion class which replace mvs-web-servlet.xml
 *
 * @author Denys Shabelnyk
 */
@EnableWebMvc
@Configuration
@Component
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Description: method which describe default view-name
	 *
	 * @param registry - view controller instance
	 * @since w0.9a1.3d1.2m0.0
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("main");
	}

	/**
	 * Description: method which describe viewresolver
	 *
	 * @return ViewResolver - instance object witch show views
	 * @since w0.9a1.3d1.2m0.0
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();

		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/jsp/");
		bean.setSuffix(".jsp");

		return bean;
	}
}
