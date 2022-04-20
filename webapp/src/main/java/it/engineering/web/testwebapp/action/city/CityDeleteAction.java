package it.engineering.web.testwebapp.action.city;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.City;
import it.engineering.web.testwebapp.repository.CityRepository;

public class CityDeleteAction extends AbstractAction{
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		City city = getCity(Integer.parseInt(request.getParameter("zipCode")));
		List<City> cities = CityRepository.getAll();
		
		for(City currentCity: cities) {
			if(city.getZipCode()==currentCity.getZipCode()) {
				
				break;
			}
		}
		cities.remove(city);
		CityRepository.delete(city);
		request.setAttribute("cities", cities);
		return WebConstants.PAGE_CITIES;
		
	}
	
	private City getCity(Integer zipCode) {
		List<City> cities = CityRepository.getAll();
		
		for(City city:cities) {
			if(zipCode.intValue()==city.getZipCode()) return city;
		}
		return null;
	}

}
