package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelectApp1 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		User u =new User();
		
		Query q=em.createQuery("select u from User u where u.getName='boya' and u.getPhone=880787");
		
		Object ul=q.getSingleResult();
		System.out.println(ul);
		
		
		
	}

}
