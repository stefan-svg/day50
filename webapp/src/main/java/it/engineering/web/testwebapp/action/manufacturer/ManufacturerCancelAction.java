package it.engineering.web.testwebapp.action.manufacturer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.Manufacturer;
import it.engineering.web.testwebapp.repository.ManufacturerRepository;

public class ManufacturerCancelAction extends AbstractAction{
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		List<Manufacturer> manufacturers = ManufacturerRepository.getAll();
		request.setAttribute("manufacturers", manufacturers);
		return WebConstants.PAGE_MANUFACTURERS;
	}
}
