package it.engineering.web.testwebapp.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.testwebapp.domain.User;
import it.engineering.web.testwebapp.persistence.MyEntityManagerFactory;

public class UserRepository {
	static List<User> loggedUser = new ArrayList<User>(); 
	@SuppressWarnings("unchecked")
	public static List<User> getAll(){
		EntityManager em = MyEntityManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		List<User> users = em.createNativeQuery("select * from user",User.class)
				.getResultList();

		em.close();

		return users;
	}
	public static List<User> getLoggedUsers(){
		return loggedUser;
	}
	public static void addLoggedUser(User user) {
		loggedUser.add(user);
	}
	public static void deleteLoggedUser(User user) {
		loggedUser.remove(user);
	
	}
}