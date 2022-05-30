package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

/**
 * Description: The main class. Extends SpringBootServletInitializer
 *
 * @author Denys Shabelnyk
 * @since w0.12a1.6d1.4m0.0
 */
@SpringBootApplication
public class WsMvsVehicleApplication extends SpringBootServletInitializer {

	private static ApplicationContext context;

	@Override
	/**
	 * Description: core method for Spring Boot and Apache tomact
	 *
	 * @since w0.12a1.6d1.4m0.0
	 * @param application Another SpringApplicationBuilder instance
	 * @return SpringApplicationBuilder Builder for application
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WsMvsVehicleApplication.class);
	}

	/**
	 * Description: core method. Returs Application Context
	 *
	 * @since w0.12a1.6d1.4m0.0
	 * @return ApplicationContext instance
	 */
	public static ApplicationContext getContext() {
		return context;
	}

	/**
	 * Description: main method.Entry point
	 *
	 * @param args - command line arguments. Input for application
	 * @since w0.12a1.6d1.4m0.0
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(WsMvsVehicleApplication.class, args);
		if (context == null) {
			context = ctx;
		}

	}

}
