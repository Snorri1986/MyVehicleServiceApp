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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import controllers.UserRegistrationController;
import repository.DataBaseBridge;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = { UserRegistrationController.class, DataBaseBridge.class })
@EnableJpaRepositories(basePackages = "repository")
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class })

/**
 * Description: The main class
 *
 * @author Denys Shabelnyk
 * @since 0.0.1
 */
public class WsMvsLoginApplication extends SpringBootServletInitializer {

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
	 * @since 0.3
	 * @return String with username
	 */
	public String getUnHeroku() {
		return unHeroku;
	}

	/**
	 * Description: Getter for password to Heroku Cloud
	 *
	 * @since 0.3
	 * @return String with password
	 */
	public String getPassHeroku() {
		return passHeroku;
	}

	@Override
	/**
	 * Description: core method for Spring Boot and Apache tomact
	 *
	 * @since 0.0.2
	 * @param application Another SpringApplicationBuilder instance
	 * @return SpringApplicationBuilder Builder for application
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WsMvsLoginApplication.class);
	}

	/**
	 * Description: core method. Returs Application Context
	 *
	 * @since 0.0.1
	 * @return ApplicationContext instance
	 */
	public static ApplicationContext getContext() {
		return context;
	}

	/**
	 * Description: main method.Entry point
	 *
	 * @param args - command line arguments. Input for application
	 * @since 0.0.1
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(WsMvsLoginApplication.class, args);
		if (context == null) {
			context = ctx;
		}

	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.tomcat")
	/**
	 * Description: Bean.DataSource pool connections
	 *
	 * @since 0.0.2
	 * @return PoolProperties instance
	 */
	public PoolProperties getDataSourcePoolProperties() {
		return new PoolProperties();
	}

	@Bean
	/**
	 * Description: Bean. DataSource PostgreSQL
	 *
	 * @since 0.3
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
	 * @since 0.5
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
	 * @since 0.5
	 * @return LocalContainerEntityManagerFactoryBean - return current instance
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

}
