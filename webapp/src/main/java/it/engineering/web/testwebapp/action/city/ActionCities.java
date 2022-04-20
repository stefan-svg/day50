package it.engineering.web.testwebapp.action.city;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.repository.CityRepository;

public class ActionCities extends AbstractAction{
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("cities", CityRepository.getAll());
		return WebConstants.PAGE_CITIES;
	}
}
