package it.engineering.web.testwebapp.factory;

import javax.servlet.http.HttpServletRequest;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.action.manufacturer.ActionManufacturers;
import it.engineering.web.testwebapp.action.manufacturer.ManufacturerViewAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.login.LoginGetAction;
import it.engineering.web.testwebapp.login.LoginPostAction;
import it.engineering.web.testwebapp.logout.ActionLogout;

public class ActionFactory {
	
	public static AbstractAction createAction(HttpServletRequest request) {
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
		}
		
		return null;
	}
}
