package unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import main.WsMvsLoginApplication;

/**
 * Description: The main test class. Container
 *
 * @author Denys Shabelnyk
 * @since 0.3
 */

// TODO: how to call database procedure directly from spring boot in test
public class TestJunit {

	// need test task 5.2 and 5.3
	@Autowired
	EntityManager entityManagerInTest;
	// ... //

	/**
	 * Description: method which check JUnit health
	 *
	 * @since 0.3
	 */
	@Test
	public void checkTestCases() {
		String str = "First try";
		assertEquals("First try", str);
	}

	/**
	 * Description: checking database connection before make war build.
	 *
	 * @since 0.3
	 */
	@Test
	public void checkDbConnection() {

		WsMvsLoginApplication wsmvsloginapp = new WsMvsLoginApplication();

		String uri = "<uri>";

		URI dbUri = null;
		try {
			dbUri = new URI(uri);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String username = wsmvsloginapp.getUnHeroku();
		String password = wsmvsloginapp.getPassHeroku();
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(dbUrl);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);

		assertNotNull(basicDataSource);

	}

	// need test task 5.2
	@Test
	public void checkAuthTestUserPositive() {
		String login = "LoyalUser";
		String password = "LoyalPassword";
		Integer answerCode;
		StoredProcedureQuery query = entityManagerInTest.createStoredProcedureQuery("auth.c_auth_subcriber")
				.registerStoredProcedureParameter("i_login", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_password", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("v_result", Integer.class, ParameterMode.OUT)
				.setParameter("i_login", login).setParameter("i_password", password);
		query.execute();
		answerCode = (Integer) query.getOutputParameterValue("v_result");
		assertEquals(answerCode, 0);
	}
	// ... //

	// need test task 5.3
	@Test
	public void checkAuthTestUserNegative() {
		String login = "Loyal";
		String password = "LoyalP";
		Integer answerCode;
		StoredProcedureQuery query = entityManagerInTest.createStoredProcedureQuery("auth.c_auth_subcriber")
				.registerStoredProcedureParameter("i_login", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_password", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("v_result", Integer.class, ParameterMode.OUT)
				.setParameter("i_login", login).setParameter("i_password", password);
		query.execute();
		answerCode = (Integer) query.getOutputParameterValue("v_result");
		assertEquals(answerCode, -1);
	}
	// ... //
}
