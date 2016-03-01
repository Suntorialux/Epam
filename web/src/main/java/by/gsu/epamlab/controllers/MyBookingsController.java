package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.gsu.epamlab.model.beans.Booking;
import by.gsu.epamlab.model.beans.User;
import by.gsu.epamlab.model.constants.Constants;
import by.gsu.epamlab.model.exceptions.BookingException;
import by.gsu.epamlab.model.factories.BookingFactory;
import by.gsu.epamlab.model.ifaces.IBookingDAO;

/**
 * Servlet implementation class MyBookings
 */
@WebServlet("/myBookings")
public class MyBookingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBookingDAO bookingDAO = BookingFactory.getClassFromFactory();
		try {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.USER); 
			Map<Integer, Booking> bookings = bookingDAO.getBookingsDB(user.getLogin());
			request.setAttribute(Constants.BOOKINGS, bookings);
			jump(Constants.FOLDER_VIEWS+Constants.PAGE_MY_BOOKINGS, request, response);
		} catch (BookingException e) {
			// TODO Auto-generated catch block
			jumpError(e.getMessage(), request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idBooking = Integer.parseInt(request.getParameter(Constants.ID_BOOKING));
		IBookingDAO bookingDAO = BookingFactory.getClassFromFactory();
		try {
			bookingDAO.deleteBooking(idBooking);
			doGet(request, response);
		} catch (BookingException e) {
			// TODO Auto-generated catch block
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
