// need test
package unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import repository.DataBaseBridge;

@DataJpaTest
public class TestDB {

	@Autowired
	DataBaseBridge dbBridge;

	// need test v.0.5
	@Test
	public void checkSubscriberRegister() {

		String login = "testLogin";
		String password = "********";
		String fname = "testFirstName";
		String sname = "testSureName";
		Integer funcanswer;

		// DataBaseBridge db = new DataBaseBridge();
		funcanswer = dbBridge.setNewUser(login, password, fname, sname);
		assertEquals(funcanswer, 1);
	}
	// ... //

}
// ... //