package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateApp
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		User u=new User();
		u.setId(106);
		u.setName("boya");
		u.setEmail("boya@gmail.com");
		u.setPhone(880787l);
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(u);
		et.commit();
		
	}

}
