// need test v.0.5
package repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataBaseBridge {

	@Autowired
	EntityManager entityManager; // need test

	// need test v.0.5
	public Integer setNewUser(String username, String password, String firstname, String lastname) {
		Integer answerCode = 0;
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("auth.c_subscriber")
				.registerStoredProcedureParameter("i_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_surname", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_login", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_password", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("v_result", Integer.class, ParameterMode.OUT)
				.setParameter(1, firstname).setParameter(2, lastname).setParameter(3, username)
				.setParameter(4, password);
		query.execute();
		answerCode = (Integer) query.getOutputParameterValue("v_result");
		return answerCode;
	}
	// ... //

}
// ... //
