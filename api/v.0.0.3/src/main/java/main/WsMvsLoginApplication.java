package main;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Value;
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

	// ready to commit
	@Value("${spring.datasource.uri}")
	String dbHerokuUri;
	// ... //

	// ready to commit
	@Value("${spring.datasource.username}")
	String unHeroku;
	// ... //

	// ready to commit
	@Value("${spring.datasource.password}")
	String passHeroku;
	// ... //

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

	// ready to commit //
	@Bean
	public BasicDataSource dataSource() throws URISyntaxException {
		URI dbUri = new URI(dbHerokuUri);

		String username = unHeroku; // ready to commit
		String password = passHeroku; // ready to commit
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath(); // need test

		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(dbUrl);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);

		return basicDataSource;
	}
	// ... //

}
