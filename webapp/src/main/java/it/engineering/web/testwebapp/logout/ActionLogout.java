package it.engineering.web.testwebapp.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.testwebapp.action.AbstractAction;
import it.engineering.web.testwebapp.constants.WebConstants;
import it.engineering.web.testwebapp.domain.User;
import it.engineering.web.testwebapp.repository.UserRepository;

public class ActionLogout extends AbstractAction{
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User logoutUser = (User) session.getAttribute("login_user");
		
		UserRepository.deleteLoggedUser(logoutUser);
		session.removeAttribute("loginUser");
		session.invalidate();
		session=request.getSession(false);
		return WebConstants.PAGE_INDEX;
	}
}
