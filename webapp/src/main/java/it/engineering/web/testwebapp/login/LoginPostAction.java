package it.engineering.web.testwebapp.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.User;
import it.engineering.web.testwebapp.repository.UserRepository;

public class LoginPostAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		User user= login(request);
		List<User> loggedUser = UserRepository.getLoggedUsers();
		System.out.println("LOGGED");
		System.out.println(loggedUser);
		if (user!=null) {
			if(loggedUser.contains(user)) {
				request.setAttribute("error_message", "Korisnik je vec ulogovan!");
				return WebConstants.PAGE_LOGIN;
			}else {
				HttpSession session = request.getSession(true);
				User loginUser = user;
				UserRepository.addLoggedUser(user);
			    session.setAttribute("login_user",loginUser);
				return WebConstants.PAGE_HOME;
			}
			
			
		}else {
			//ubaciti poruku za korisnika
			request.setAttribute("error_message", "Korisnik ne postoji!");
			return WebConstants.PAGE_LOGIN;
		}
	}
	
	private User login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		List<User> users = UserRepository.getAll();
		for(User current:users) {
			if(current.equals(user)) return current;
		}
		
		return null;
	}

}
