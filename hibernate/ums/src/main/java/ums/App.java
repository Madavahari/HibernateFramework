package ums;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("Enter Option :");
			System.out.println("1 Login");
			System.out.println("2 create Account");
			System.out.println("3 Delete Account By Id");
			System.out.println("4 View All accounts");
			System.out.println("5 Exit");

			switch (s.nextInt()) {
			case 1:
				login();
				break;
			case 2:
				createbyaccount();
				break;
			case 3:
				deleteAccountById();
				break;
			case 4:
				viewAll();
				break;
			case 5:
				System.out.println("thank you for using app");
				System.exit(0);

				break;

			default:
				break;
			}
		}

	}

	static void login() {
		System.out.println("Enter Username");
		String username = s.next();
		System.out.println("Enter Password");
		String password = s.next();
		Query q = em.createQuery("select u from User u where u.username=?1 and u.password=?2");
		q.setParameter(1, username);
		q.setParameter(2, password);
		List<User> l = q.getResultList();
		System.out.println(l);

	}

	static void createbyaccount() {
		System.out.println("Enter name");
		String name = s.next();
		System.out.println("Enter username");
		String username = s.next();
		System.out.println("Enter phone");
		long phone = s.nextLong();
		System.out.println("Enter password");
		String password = s.next();

		User u = new User(0, name, username, phone, password);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(u);
		et.commit();
		System.out.println("USer Saved Successfully");
	}

	static void deleteAccountById() {
		System.out.println("Enter id");
		int id = s.nextInt();
		User u = em.find(User.class, id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(u);
		et.commit();
		System.out.println("User Deleted Successfully");
	}

	static void viewAll() {
		Query q = em.createQuery("from User u");
		List<User> l = q.getResultList();
		for (User i : l) {
			System.out.println(i);
		}

	}

}
