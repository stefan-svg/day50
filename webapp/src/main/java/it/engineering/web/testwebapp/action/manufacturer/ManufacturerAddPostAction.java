package it.engineering.web.testwebapp.action.manufacturer;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.City;
import it.engineering.web.testwebapp.domain.Manufacturer;
import it.engineering.web.testwebapp.repository.CityRepository;
import it.engineering.web.testwebapp.repository.ManufacturerRepository;

public class ManufacturerAddPostAction extends AbstractAction{
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		
		List<Manufacturer> manufacturers = ManufacturerRepository.getAll();
		City city = getCity(Integer.parseInt(request.getParameter("zipcode")));
		if(city==null) {
			request.setAttribute("error_message", "Ne postoji trazeni grad!");
			return WebConstants.PAGE_MANUFACTURER_ADD;
		}
		
		if(request.getParameter("pib")=="" || request.getParameter("matbr")=="" || request.getParameter("adresa")=="") {
			request.setAttribute("error_message", "Popunite sva polja!");
			request.setAttribute("cities", CityRepository.getAll());
		return WebConstants.PAGE_MANUFACTURER_ADD;
		}
		
		
		Manufacturer manufacturer = new Manufacturer(Integer.parseInt(request.getParameter("pib")),
				Integer.parseInt(request.getParameter("matbr")),request.getParameter("adresa"),city);
		
		for(Manufacturer currentManufacturer:manufacturers) {
			if(currentManufacturer.getPib()==manufacturer.getPib()) {
				request.setAttribute("error_message", "Proizvodjac vec postoji");
				return WebConstants.PAGE_MANUFACTURER_ADD;
			}
			if(currentManufacturer.getMatbr()==manufacturer.getMatbr()) {
				request.setAttribute("error_message", "Postoji proizvodjac sa tim maticnim brojem");
				return WebConstants.PAGE_MANUFACTURER_ADD;
			}
		}
		
		manufacturers.add(manufacturer);
		ManufacturerRepository.save(manufacturer);
		
		request.setAttribute("manufacturers", manufacturers);
		return WebConstants.PAGE_MANUFACTURERS;
	}
	
	private City getCity(Integer zipCode) {
		List<City> cities = CityRepository.getAll();
		
		for(City city:cities) {
			if(zipCode.equals(city.getZipCode())) return city;
		}
		return null;
	}

}
