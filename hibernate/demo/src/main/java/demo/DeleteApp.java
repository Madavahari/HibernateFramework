package demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteApp
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		System.out.println("Enter User Id to delete");
		int id=new Scanner(System.in).nextInt();
		
		User u=em.find(User.class, id);
		
		if(u!=null)
		{
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.remove(u);
			et.commit();
		}
		else
		{
			System.out.println("Invalid User Id");
		}
		
	}

}
