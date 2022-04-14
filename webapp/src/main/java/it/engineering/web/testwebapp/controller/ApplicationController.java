package it.engineering.web.testwebapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.factory.ActionFactory;

public class ApplicationController {
public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		
		
		AbstractAction action = ActionFactory.createAction(request);
		
		
		return action.executeRequest(request, response);
	}
}
