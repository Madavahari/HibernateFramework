package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertApp
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		User u=new User();
		u.setId(102);
		u.setName("akhil");
		u.setEmail("akhil@gmail.com");
		u.setPhone(9008683987l);
		
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
		System.out.println("User Saved Successfully");
		
	}

}
