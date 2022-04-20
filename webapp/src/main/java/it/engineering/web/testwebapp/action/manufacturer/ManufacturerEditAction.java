package it.engineering.web.testwebapp.action.manufacturer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.Manufacturer;
import it.engineering.web.testwebapp.repository.CityRepository;
import it.engineering.web.testwebapp.repository.ManufacturerRepository;

public class ManufacturerEditAction extends AbstractAction{
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		List<Manufacturer> manufacturers = ManufacturerRepository.getAll();
		Manufacturer manufacturer = getManufacturer(Integer.parseInt(request.getParameter("pib")));
		
		if(manufacturer!=null) {
			request.setAttribute("manufacturer", manufacturer);
			request.setAttribute("cities", CityRepository.getAll());
			return WebConstants.PAGE_MANUFACTURER_EDIT;
		}else {
			request.setAttribute("manufacturers", manufacturers);
			return WebConstants.PAGE_MANUFACTURERS;
		}
	}
	private Manufacturer getManufacturer(Integer pib) {
		List<Manufacturer> manufacturers = ManufacturerRepository.getAll();
		
		for(Manufacturer m:manufacturers) {
			if(pib.intValue()==m.getPib()) return m;
		}
		return null;
	}
}
