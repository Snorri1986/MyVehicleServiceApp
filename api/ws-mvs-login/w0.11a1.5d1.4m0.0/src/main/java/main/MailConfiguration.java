package main;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * Description: class for mail send configuration
 *
 * @author Denys Shabelnyk
 * @since w0.10a1.4d1.3m0.0
 */
@Configuration
@Component
public class MailConfiguration {

	@Autowired
	private Environment env;

	/**
	 * Description: defenition of JavaMailSender bean
	 *
	 * @return JavaMailSender - instance of JavaMailSender bean
	 * @since w0.10a1.4d1.3m0.0
	 */
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(env.getProperty("senderhost"));
		mailSender.setPort(Integer.valueOf(env.getProperty("senderport")));
		mailSender.setUsername(env.getProperty("sendername"));
		mailSender.setPassword(env.getProperty("senderpassword"));

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");

		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}

}
