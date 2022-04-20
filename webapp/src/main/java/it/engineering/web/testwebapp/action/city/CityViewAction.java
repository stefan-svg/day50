package it.engineering.web.testwebapp.action.city;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.City;
import it.engineering.web.testwebapp.repository.CityRepository;

public class CityViewAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		City city = getCity(Integer.parseInt(request.getParameter("zipCode")));
		
		if(city!= null) {
			request.setAttribute("city", city);
			return WebConstants.PAGE_CITY_VIEW;
		}else {
			request.setAttribute("cities", CityRepository.getAll());
			return WebConstants.PAGE_CITIES;
		}
		
	}
	
	private City getCity(Integer zipCode) {
		List<City> cities = CityRepository.getAll();
		
		for(City city:cities) {
			if(zipCode.intValue()==city.getZipCode()) return city;
		}
		return null;
	}

}
