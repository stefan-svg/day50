package it.engineering.web.testwebapp.factory;

import javax.servlet.http.HttpServletRequest;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.login.LoginGetAction;
import it.engineering.web.testwebapp.login.LoginPostAction;

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
			
		}
		
		return null;
	}
}
