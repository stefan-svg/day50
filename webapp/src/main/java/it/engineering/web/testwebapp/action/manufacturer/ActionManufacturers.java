package it.engineering.web.testwebapp.action.manufacturer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.repository.ManufacturerRepository;

public class ActionManufacturers extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("manufacturers", ManufacturerRepository.getAll());
		return WebConstants.PAGE_MANUFACTURERS;
	}
	
}

