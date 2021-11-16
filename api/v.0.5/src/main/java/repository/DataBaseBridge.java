package repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class DataBaseBridge {

	@Lazy
	@Autowired
	EntityManager entityManager;

	// TODO: finish method
	public Integer setNewUser(String username, String password, String firstname, String lastname) {
		Integer answerCode = 0;

		return answerCode;
	}

}
