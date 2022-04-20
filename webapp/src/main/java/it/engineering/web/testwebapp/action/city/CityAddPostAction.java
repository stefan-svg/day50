package it.engineering.web.testwebapp.action.city;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.City;
import it.engineering.web.testwebapp.repository.CityRepository;

public class CityAddPostAction extends AbstractAction{
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		List<City> cities = CityRepository.getAll();
	
		
		City city = new City(Integer.parseInt(request.getParameter("zipCode")),request.getParameter("name"));
		
		for(City currentCity:cities) {
			if(city.getZipCode()==currentCity.getZipCode()) {
				request.setAttribute("error_message", "Grad vec postoji");
				return WebConstants.PAGE_CITY_ADD;
			}
		}
		cities.add(city);
		CityRepository.save(city);
		request.setAttribute("cities", cities);
		return WebConstants.PAGE_CITIES;
	}
}
