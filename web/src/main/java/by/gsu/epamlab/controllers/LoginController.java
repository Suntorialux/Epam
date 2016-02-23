package by.gsu.epamlab.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.model.beans.Constants;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.exceptions.UserException;
import by.gsu.epamlab.model.factories.UserFactory;
import by.gsu.epamlab.model.ifaces.IUserDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter(Constants.KEY_LOGIN);
		String password = request.getParameter(Constants.KEY_PASSWORD);
		try {
			IUserDAO userDAO = UserFactory.getClassFromFactory();
			User user = userDAO.getUser(login.trim(), password.trim());
			HttpSession session = request.getSession();
			session.setAttribute(Constants.USER, user);
			jump("/main", request, response);
		} catch (UserException e) {
			jumpError(e.getMessage(), request, response);
		}
	}
	

	
	protected void jump(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void jumpError(String message, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		jump(Constants.PAGE_INDEX, message, request, response);
	}

	protected void jump(String url, String message, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(Constants.ERROR, message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
