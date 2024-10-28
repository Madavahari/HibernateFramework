package demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelectApp 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		
		User u=new User();
		
		Query q=em.createQuery("from User");
		List<User> l=q.getResultList();
		for(User ul:l)
		{
			System.out.println(ul);
		}
		
	}

}
