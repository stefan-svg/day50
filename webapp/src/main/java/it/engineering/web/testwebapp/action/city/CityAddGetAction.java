package it.engineering.web.testwebapp.action.city;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;

public class CityAddGetAction extends AbstractAction{
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		return WebConstants.PAGE_CITY_ADD;
	}
}
