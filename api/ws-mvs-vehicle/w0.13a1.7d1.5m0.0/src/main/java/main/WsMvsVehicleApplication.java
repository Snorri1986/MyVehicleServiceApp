package main;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Description: The main class. Extends SpringBootServletInitializer
 *
 * @author Denys Shabelnyk
 * @since w0.12a1.6d1.4m0.0
 */
@SpringBootApplication
@ComponentScan({ "repository", "controllers" })
@Configuration
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class })
public class WsMvsVehicleApplication extends SpringBootServletInitializer {

	private static ApplicationContext context;

	@Value("${spring.datasource.uri}")
	String dbHerokuUri;

	@Value("${spring.datasource.username}")
	String unHeroku;

	@Value("${spring.datasource.password}")
	String passHeroku;

	/**
	 * Description: Getter for username to Heroku Cloud
	 *
	 * @since w0.12a1.6d1.4m0.0
	 * @return String with username
	 */
	public String getUnHeroku() {
		return unHeroku;
	}

	/**
	 * Description: Getter for password to Heroku Cloud
	 *
	 * @since w0.12a1.6d1.4m0.0
	 * @return String with password
	 */
	public String getPassHeroku() {
		return passHeroku;
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.tomcat")
	/**
	 * Description: Bean.DataSource pool connections
	 *
	 * @since w0.12a1.6d1.4m0.0
	 * @return PoolProperties instance
	 */
	public PoolProperties getDataSourcePoolProperties() {
		return new PoolProperties();
	}

	@Bean
	/**
	 * Description: Bean. DataSource PostgreSQL
	 *
	 * @since w0.12a1.6d1.4m0.0
	 * @return BasicDataSource instance
	 * @throws URISyntaxException - connection string
	 */
	public BasicDataSource dataSource() throws URISyntaxException {
		URI dbUri = new URI(dbHerokuUri);

		String username = unHeroku;
		String password = passHeroku;

		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(dbUrl);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);

		return basicDataSource;
	}

	/**
	 * Description: getter method of JPA properties(Bean)
	 *
	 * @author Denys Shabelnyk
	 * @since w0.12a1.6d1.4m0.0
	 * @return Properties - return current JPA properties
	 */
	@Bean
	@Primary
	@ConfigurationProperties("spring.jpa")
	public Properties getJpaProperties() {
		return new Properties();
	}

	/**
	 * Description: factory to EntityManager
	 *
	 * @author Denys Shabelnyk
	 * @since w0.12a1.6d1.4m0.0
	 * @return LocalContainerEntityManagerFactoryBean - return current instance
	 * @throws ClassNotFoundException - if a class didn't find
	 */
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		Properties jpaProperties = getJpaProperties();
		vendorAdapter.setGenerateDdl(false);
		final boolean showsql = Boolean.parseBoolean(jpaProperties.getProperty("show-sql", "false"));
		vendorAdapter.setShowSql(showsql);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		try {
			factoryBean.setDataSource(dataSource());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan("repository");
		factoryBean.setJpaProperties(jpaProperties);

		return factoryBean;
	}

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
