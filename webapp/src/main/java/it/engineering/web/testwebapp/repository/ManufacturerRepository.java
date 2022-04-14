package it.engineering.web.testwebapp.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.testwebapp.domain.Manufacturer;
import it.engineering.web.testwebapp.persistence.MyEntityManagerFactory;

public class ManufacturerRepository {
	
	@SuppressWarnings("unchecked")
	public static List<Manufacturer> getAll(){
		EntityManager em = MyEntityManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		List<Manufacturer> manufactures = em.createNativeQuery("select * from manufacturer",Manufacturer.class)
				.getResultList();
		em.close();
		return manufactures;
	}
	
	public static void save (Manufacturer manufacturer) {
		EntityManager em = MyEntityManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		em.getTransaction().begin();
		//dodaj proizvodjaca
		Manufacturer contextManufacturer = em.merge(manufacturer);
		em.flush();
		System.out.println(contextManufacturer);
		
		
		em.getTransaction().commit();
		em.close();
	}

	
	
	public static void saveOrUpdate (Manufacturer manufacturer) {
		EntityManager em = MyEntityManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		em.getTransaction().begin();
		//dodaj proizvodjaca
		Manufacturer contextManufacturer = em.merge(manufacturer);
		em.flush();
		System.out.println(contextManufacturer);

		
		em.getTransaction().commit();
		em.close();
	}


	
	public static void delete(Manufacturer manufacturer) {
		EntityManager em=MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		Manufacturer currentManufacturer= em.find(Manufacturer.class, manufacturer.getPib());
		em.getTransaction().begin();
		em.remove(currentManufacturer);
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}
	
	
}
