package database;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(Account account) {
		em.persist(account);
	}
	/*
	public List<Account> getAll() {
		TypedQuerry<Account> query = em.createQuery(
				"SELECT "
	}
	*/
	
}
