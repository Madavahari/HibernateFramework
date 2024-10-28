package ums;

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
		User u=new User(0,"hari","hari1",99067887,"123");
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
		System.out.println("USer Saved Successfully");
		
	}

}
