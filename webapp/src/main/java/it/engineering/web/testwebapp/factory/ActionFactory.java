package it.engineering.web.testwebapp.factory;

import javax.servlet.http.HttpServletRequest;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.action.city.ActionCities;
import it.engineering.web.testwebapp.action.city.CityAddGetAction;
import it.engineering.web.testwebapp.action.city.CityAddPostAction;
import it.engineering.web.testwebapp.action.city.CityCancelAction;
import it.engineering.web.testwebapp.action.city.CityDeleteAction;
import it.engineering.web.testwebapp.action.city.CityEditAction;
import it.engineering.web.testwebapp.action.city.CitySaveAction;
import it.engineering.web.testwebapp.action.city.CityViewAction;
import it.engineering.web.testwebapp.action.manufacturer.ActionManufacturers;
import it.engineering.web.testwebapp.action.manufacturer.ManufacturerAddGetAction;
import it.engineering.web.testwebapp.action.manufacturer.ManufacturerAddPostAction;
import it.engineering.web.testwebapp.action.manufacturer.ManufacturerCancelAction;
import it.engineering.web.testwebapp.action.manufacturer.ManufacturerDeleteAction;
import it.engineering.web.testwebapp.action.manufacturer.ManufacturerEditAction;
import it.engineering.web.testwebapp.action.manufacturer.ManufacturerSaveAction;
import it.engineering.web.testwebapp.action.manufacturer.ManufacturerViewAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.login.LoginGetAction;
import it.engineering.web.testwebapp.login.LoginPostAction;
import it.engineering.web.testwebapp.logout.ActionLogout;

public class ActionFactory {
	
	public static AbstractAction createAction(HttpServletRequest request) {
		if(request.getPathInfo().equals(WebConstants.PATH_LOGIN)) {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				return new LoginGetAction();
			}else if(request.getMethod().equalsIgnoreCase("POST")){
				return new LoginPostAction();
			}
		}else {
				if(request.getSession(true).getAttribute("login_user")==null) {
					return new LoginGetAction();
				}	
		}
		switch(request.getPathInfo()) {
		case WebConstants.PATH_LOGIN:
			if(request.getMethod().equalsIgnoreCase("GET")) {
				return new LoginGetAction();
			}else if(request.getMethod().equalsIgnoreCase("POST")){
				return new LoginPostAction();
			}
			break;
		case WebConstants.PATH_LOGOUT:
			return new ActionLogout();
		case WebConstants.PATH_MANUFACTURER:
			return new ActionManufacturers();
			
		case WebConstants.PATH_MANUFACTURER_VIEW:
			return new ManufacturerViewAction();
		case WebConstants.PATH_MANUFACTURER_SAVE:
			return new ManufacturerSaveAction();
		case WebConstants.PATH_MANUFACTURER_CANCEL:
			return new ManufacturerCancelAction();
		case WebConstants.PATH_MANUFACTURER_DELETE:
			return new ManufacturerDeleteAction();
		case WebConstants.PATH_MANUFACTURER_EDIT:
			return new ManufacturerEditAction();
		case WebConstants.PATH_MANUFACTURER_ADD:
			if(request.getMethod().equalsIgnoreCase("GET")) {
				return new ManufacturerAddGetAction();
		}else if(request.getMethod().equalsIgnoreCase("POST")){
			return new ManufacturerAddPostAction();
		}
			break;
		case WebConstants.PATH_CITY:
			return new ActionCities();
		case WebConstants.PATH_CITY_VIEW:
			return new CityViewAction();
		case WebConstants.PATH_CITY_EDIT:
			return new CityEditAction();
		case WebConstants.PATH_CITY_SAVE:
			return new CitySaveAction();
		case WebConstants.PATH_CITY_CANCEL:
			return new CityCancelAction();
		case WebConstants.PATH_CITY_DELETE:
			return new CityDeleteAction();
		case WebConstants.PATH_CITY_ADD:
			if(request.getMethod().equalsIgnoreCase("GET")) {
				return new CityAddGetAction();
			}else if(request.getMethod().equalsIgnoreCase("POST")){
				return new CityAddPostAction();
			}
			break;
		}
		
		return null;
	}
}
