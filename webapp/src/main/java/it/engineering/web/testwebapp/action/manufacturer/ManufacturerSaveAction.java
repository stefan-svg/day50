package it.engineering.web.testwebapp.action.manufacturer;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.Manufacturer;
import it.engineering.web.testwebapp.repository.ManufacturerRepository;

public class ManufacturerSaveAction extends AbstractAction{
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		List<Manufacturer> manufacturers = ManufacturerRepository.getAll();
		
		Manufacturer manufacturer = getManufacturer(Integer.parseInt(request.getParameter("pib")));
		for(Manufacturer m:manufacturers) {
			if(manufacturer.getPib()==m.getPib()) {
				int matb=Integer.parseInt(request.getParameter("matbr"));
				for(Manufacturer man:manufacturers) {
					if(man.getMatbr()==matb) {
						request.setAttribute("error_message", "Proizvodjac sa tim maticnim brojem vec postoji!");
						request.setAttribute("manufacturer", manufacturer);
						return WebConstants.PAGE_MANUFACTURER_VIEW;
					}
				}
				m.setMatbr(Integer.parseInt(request.getParameter("matbr")));
				m.setAdresa(request.getParameter("adresa"));
				ManufacturerRepository.saveOrUpdate(m);
			}
		}
		
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