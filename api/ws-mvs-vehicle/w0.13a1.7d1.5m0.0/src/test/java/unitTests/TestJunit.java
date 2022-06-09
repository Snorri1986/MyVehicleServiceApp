package unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.jupiter.api.Test;

import main.WsMvsVehicleApplication;

/**
 * Description: The main test class. Container
 *
 * @author Denys Shabelnyk
 * @since w0.12a1.6d1.4m0.0
 */
public class TestJunit {

	/**
	 * Description: method which check JUnit health
	 *
	 * @since w0.12a1.6d1.4m0.0
	 */
	@Test
	public void checkTestCases() {
		String str = "First try";
		assertEquals("First try", str);
	}

	/**
	 * Description: checking database connection before make war build.
	 *
	 * @since w0.12a1.6d1.4m0.0
	 */
	@Test
	public void checkDbConnection() {

		WsMvsVehicleApplication wsmvsloginapp = new WsMvsVehicleApplication();

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
}
