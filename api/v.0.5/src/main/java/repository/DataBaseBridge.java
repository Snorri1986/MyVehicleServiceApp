// ready to commit v.0.5
package repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Description: The repository class
 *
 * @author Denys Shabelnyk
 * @since 0.5
 */
@Repository
public class DataBaseBridge {

	@Autowired
	EntityManager entityManager; // ready to commit

	// ready to commit v.0.5
	/**
	 * Description: method for adding new user
	 *
	 * @author Denys Shabelnyk
	 * @since 0.5
	 * @param username  - login of new user
	 * @param password  - password of new user
	 * @param firstname - first name of new user
	 * @param lastname  - last name of new user
	 * @return Integer - result code. 0 - success, -1 - fail
	 */
	public Integer setNewUser(String username, String password, String firstname, String lastname) {
		Integer answerCode = 0;
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("auth.c_subscriber")
				.registerStoredProcedureParameter("i_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_surname", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_login", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_password", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("v_result", Integer.class, ParameterMode.OUT)
				.setParameter("i_name", firstname).setParameter("i_surname", lastname).setParameter("i_login", username)
				.setParameter("i_password", password);
		query.execute();
		answerCode = (Integer) query.getOutputParameterValue("v_result");
		return answerCode;
	}
	// ... //

}
// ... //
