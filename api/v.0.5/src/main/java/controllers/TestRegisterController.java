// need test v0.5
package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRegisterController {

	// @Autowired
	// DataBaseBridge dataBaseBridge;

	@GetMapping("/registerTest")
	public String regTestClient() {

		/*
		 * String login = "testLogin"; String password = "testPassword"; String fname =
		 * "testFirstName"; String sname = "testSureName"; Integer funcanswer;
		 *
		 * // DataBaseBridge db = new DataBaseBridge(); funcanswer =
		 * dataBaseBridge.setNewUser(login, password, fname, sname);
		 *
		 * if (funcanswer == 0) { return "successRegister"; } else { return
		 * "failureRegister"; }
		 */

		return "Test endpoint";

	}

}
// ... //
