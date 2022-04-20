package it.engineering.web.testwebapp.repository;


import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.testwebapp.domain.City;
import it.engineering.web.testwebapp.domain.Manufacturer;
import it.engineering.web.testwebapp.persistence.MyEntityManagerFactory;

public class CityRepository {
	@SuppressWarnings("unchecked")
	public static List<City> getAll(){
		EntityManager em = MyEntityManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		//JPQL
		List<City> cities = em.createNativeQuery("select * from city",City.class)
				.getResultList();
		em.close();

		return cities;
	}
	
	public static void saveOrUpdate (City city) {
		EntityManager em = MyEntityManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		em.getTransaction().begin();
		//dodaj proizvodjaca
		City contextCity = em.merge(city);
		em.flush();
		System.out.println(contextCity);

		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void save (City city) {
		EntityManager em = MyEntityManagerFactory
				.getEntityManagerFactory()
				.createEntityManager();
		
		em.getTransaction().begin();
		//dodaj proizvodjaca
		City contextCity = em.merge(city);
		em.flush();
		System.out.println(contextCity);
		
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static void delete(City city) {
		EntityManager em=MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		City currentCity= em.find(City.class, city.getZipCode());
		List<Manufacturer> manufacturers = ManufacturerRepository.getAll();
		
		for(Manufacturer m:manufacturers) {
				if(m.getCity().equals(currentCity)) {
					m.setCity(null);
				ManufacturerRepository.delete(m);
				}
		}
		
		em.getTransaction().begin();
		em.remove(currentCity);
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}
}