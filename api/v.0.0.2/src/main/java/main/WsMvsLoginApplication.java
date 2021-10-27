package main;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Configuration
@ComponentScan
public class WsMvsLoginApplication extends SpringBootServletInitializer {

	private static ApplicationContext context;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WsMvsLoginApplication.class);
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(WsMvsLoginApplication.class, args);
		if (context == null) {
			context = ctx;
		}

	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.tomcat")
	public PoolProperties getDataSourcePoolProperties() {
		return new PoolProperties();
	}

}
