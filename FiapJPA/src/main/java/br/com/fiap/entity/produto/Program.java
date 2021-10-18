package br.com.fiap.entity.produto;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Program {

	public static void main(String[] args) {

		EntityManager em = null;
		
		try {
			em = Persistence.createEntityManagerFactory("FiapJPA").createEntityManager();		
			em.getTransaction().begin();
			
			em.getTransaction().commit();
		

		} catch (Exception e) {

			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();

		}

		if (em != null) {
			em.close();
		}
		System.exit(0);		

	}
}
