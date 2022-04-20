package it.engineering.web.testwebapp.action.city;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.City;
import it.engineering.web.testwebapp.repository.CityRepository;

public class CityCancelAction extends AbstractAction{
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		List<City> cities = CityRepository.getAll();
		request.setAttribute("cities", cities);
		return WebConstants.PAGE_CITIES;
	}
}
