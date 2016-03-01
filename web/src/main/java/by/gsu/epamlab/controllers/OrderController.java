package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.constants.Constants;
import by.gsu.epamlab.model.exceptions.BookingException;
import by.gsu.epamlab.model.factories.BookingFactory;
import by.gsu.epamlab.model.ifaces.IBookingDAO;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/booking/order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER);
		List<String> parametrsBooking = getParametrsOrder(request);
		try {
			IBookingDAO bookingDAO = BookingFactory.getClassFromFactory();
			bookingDAO.addBookingDB(parametrsBooking, user);
			jump(Constants.FOLDER_VIEWS + Constants.PAGE_INFO_ORDER, request, response);
		} catch (BookingException e) {
			
			jumpError(e.getMessage(), request, response);
		}

	}

	private List<String> getParametrsOrder(HttpServletRequest request) {
		List<String> parametrs = new ArrayList<>();
		Enumeration<String> paramNamesBooking = request.getParameterNames();
		while (paramNamesBooking.hasMoreElements()) {
			String paramName = paramNamesBooking.nextElement();
			String paramValue = request.getParameter(paramName);
			parametrs.add(paramValue);
		}
		return parametrs;
	}

	protected void jump(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void jumpError(String message, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		jump(Constants.FOLDER_VIEWS + Constants.PAGE_ORDER, message, request, response);
	}

	protected void jump(String url, String message, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(Constants.ERROR, message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
