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
	EntityManager entityManager;

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
				.registerStoredProcedureParameter("i_login", String.class, ParameterMode.IN)
				.setParameter("i_login", username)
				.registerStoredProcedureParameter("i_password", String.class, ParameterMode.IN)
				.setParameter("i_password", password)
				.registerStoredProcedureParameter("i_name", String.class, ParameterMode.IN)
				.setParameter("i_name", firstname)
				.registerStoredProcedureParameter("i_surname", String.class, ParameterMode.IN)
				.setParameter("i_surname", lastname)
				.registerStoredProcedureParameter("v_result", Integer.class, ParameterMode.OUT);

		query.execute();
		answerCode = (Integer) query.getOutputParameterValue("v_result");
		return answerCode;
	}

	/**
	 * Description: method for handling user authorization
	 *
	 * @author Denys Shabelnyk
	 * @since 0.6
	 * @param username - login of user
	 * @param password - password of user
	 * @return Integer - result code. 0 - success, -1 - fail
	 */
	public Integer checkUserAuth(String username, String password) {
		Integer answerCode = 0;
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("auth.c_auth_subcriber")
				.registerStoredProcedureParameter("i_login", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_password", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("v_result", Integer.class, ParameterMode.OUT)
				.setParameter("i_login", username).setParameter("i_password", password);
		query.execute();
		answerCode = (Integer) query.getOutputParameterValue("v_result");
		return answerCode;
	}

	/**
	 * Description: method for handling restore password process
	 *
	 * @author Denys Shabelnyk
	 * @since w0.10a1.4d1.3m0.0
	 * @param usrLoginFromFront - login of user
	 * @return String - hash of user's password
	 */
	public String getCurrentUsrPassHash(String usrLoginFromFront) {
		String hashPassword;
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("auth.getsubscriberpassword")
				.registerStoredProcedureParameter("i_login", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("v_result", String.class, ParameterMode.OUT)
				.setParameter("i_login", usrLoginFromFront);
		query.execute();
		hashPassword = (String) query.getOutputParameterValue("v_result");
		return hashPassword;
	}
}