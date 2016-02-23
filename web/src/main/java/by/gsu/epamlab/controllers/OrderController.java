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

import by.gsu.epamlab.model.beans.Constants;
import by.gsu.epamlab.model.beans.User;
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
		// TODO Auto-generated method stub
		/*
		 * create table orders ( idOrder int (10) AUTO_INCREMENT, id_user int
		 * (10) NOT NULL, id_play int (10) NOT NULL, sector varchar(50) NOT
		 * NULL, row int (10) NOT NULL, place int (10) NOT NULL, price int (10)
		 * NOT NULL, status varchar (20) NOT NULL, PRIMARY KEY (idOrder),
		 * FOREIGN KEY (id_user) REFERENCES users (idUser), FOREIGN KEY
		 * (id_play) REFERENCES plays (idPlay) );
		 */

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<String> parametrsBooking = getParametrsOrder(request);
		try {
			IBookingDAO bookingDAO = BookingFactory.getClassFromFactory();
			bookingDAO.addBookingDB(parametrsBooking, user);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(Constants.FOLDER_VIEWS + "/orderInfo.jsp");
			rd.forward(request, response);
		} catch (BookingException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = getServletContext().getRequestDispatcher(Constants.FOLDER_VIEWS + "/order.jsp");
			rd.forward(request, response);
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

}
