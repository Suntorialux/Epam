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
import by.gsu.epamlab.model.exceptions.ValidationException;
import by.gsu.epamlab.model.factories.UserFactory;
import by.gsu.epamlab.model.ifaces.IUserDAO;

/**
 * Servlet implementation class RegistrationControllers
 */

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		jump(Constants.FOLDER_VIEWS + Constants.PAGE_REGISTRATION, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		performTask(request, response);
	}

	
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter(Constants.KEY_LOGIN);
		String password = request.getParameter(Constants.KEY_PASSWORD);
		try {
			checkInput(login, password);
			IUserDAO userDAO = UserFactory.getClassFromFactory();

			User user = userDAO.addAndGetUser(login.trim(), password.trim());

			HttpSession session = request.getSession();
			session.setAttribute(Constants.USER, user);
			jump(Constants.FOLDER_VIEWS + Constants.PAGE_MAIN, request, response);

		} catch (ValidationException | UserException e) {
			jump(Constants.FOLDER_VIEWS + Constants.PAGE_REGISTRATION, e.getMessage(), request, response);
		}
	}

	private static void checkInput(String login, String password) throws ValidationException {
		if (login == null || password == null) {
			throw new ValidationException(Constants.LOGIN_OR_PASSWORD_ABSENT_ERROR);
		}
		login = login.trim();
		if (Constants.EMPTY.equals(login)) {
			throw new ValidationException(Constants.LOGIN_EMPTY_ERROR);
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
