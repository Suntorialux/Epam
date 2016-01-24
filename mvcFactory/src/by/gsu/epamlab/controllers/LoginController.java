package by.gsu.epamlab.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.ifaces.IUserDAO;
import by.gsu.epamlab.model.factories.UserFactory;
import by.gsu.epamlab.model.impl.DaoException;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		String realPath = getServletConfig().getServletContext().getRealPath(
				Constants.NAME_PROJECT_ROOT)
				+ Constants.NAME_CLASSES_ROOT;
		UserFactory.classesRealPath = realPath;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		performTask(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		performTask(request, response);
	}

	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// получение данных формы
		String login = request.getParameter(ConstantsJSP.KEY_LOGIN);
		String password = request.getParameter(ConstantsJSP.KEY_PASSWORD);
		// проверка данных формы
		if (login == null || password == null) {
			jumpError(Constants.ERROR_NULL, request, response);
			return;
		}
		// преобразование и еще одна проверка данных формы
		login = login.trim();
		if (Constants.KEY_EMPTY.equals(login)) {
			jumpError(Constants.ERROR_EMPTY, request, response);
			return;
		}
		// создание объекта класса бизнес-логики
		IUserDAO userDAO = UserFactory.getClassFromFactory();
		try {
			// вызов метода и получение результата
			User user = userDAO.getUser(login, password);
			// передача результата в скоуп запроса
			request.setAttribute(Constants.KEY_USER, user);
			// вызов jsp–страницы
			jumpPage(Constants.JUMP_MAIN, request, response);
		} catch (DaoException e) {
			jumpError(e.getMessage(), request, response);
		}
	}

	// переход на следующую JSP страницу
	protected void jump(String url, String message, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// передача результата в скоуп запроса
		request.setAttribute(Constants.KEY_ERROR_MESSAGE, message);
		// вызов jsp–страницы
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	// переход на указанную JSP страницу
	protected void jumpPage(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		jump(url, Constants.KEY_EMPTY, request, response);
	}

	// переход на страницу, где отображаются ошибки
	protected void jumpError(String message, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		jump(Constants.JUMP_ERROR, message, request, response);
	}
}
