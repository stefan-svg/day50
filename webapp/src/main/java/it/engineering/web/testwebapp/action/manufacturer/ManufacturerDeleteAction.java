package it.engineering.web.testwebapp.action.manufacturer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.Manufacturer;
import it.engineering.web.testwebapp.repository.ManufacturerRepository;

public class ManufacturerDeleteAction  extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		Manufacturer manufacturer = getManufacturer(Integer.parseInt(request.getParameter("pib")));
		List<Manufacturer> manufacturers = ManufacturerRepository.getAll();
		
		for(Manufacturer m:manufacturers) {
			if(manufacturer.getPib()==m.getPib()) {
				break;
			}
		}
		manufacturers.remove(manufacturer);
		ManufacturerRepository.delete(manufacturer);
		request.setAttribute("manufacturers", manufacturers);
		return WebConstants.PAGE_MANUFACTURERS;
	}
	
	private Manufacturer getManufacturer(Integer pib) {
		List<Manufacturer> manufacturers = ManufacturerRepository.getAll();
		
		for(Manufacturer m:manufacturers) {
			if(pib.intValue()==m.getPib()) return m;
		}
		return null;
	}
}
