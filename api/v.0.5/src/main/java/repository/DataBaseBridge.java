// need test v.0.5
package repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class DataBaseBridge {

	@Lazy
	@Autowired
	EntityManager entityManager;

	// need test v.0.5
	public Integer setNewUser(String username, String password, String firstname, String lastname) {
		Integer answerCode = 0;
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("auth.c_subscriber")
				.registerStoredProcedureParameter("i_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_surname", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_login", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("i_password", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("v_result", Integer.class, ParameterMode.OUT)
				.setParameter(1, username).setParameter(2, password).setParameter(3, firstname)
				.setParameter(4, lastname);
		query.execute();
		answerCode = (Integer) query.getOutputParameterValue("v_result");
		return answerCode;
	}
	// ... //

}
// ... //
