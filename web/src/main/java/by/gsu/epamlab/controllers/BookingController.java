package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.util.Map;
import java.util.Set;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.model.beans.Booking;
import by.gsu.epamlab.model.beans.Constants;
import by.gsu.epamlab.model.beans.Place;
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.BookingException;
import by.gsu.epamlab.model.exceptions.UserException;
import by.gsu.epamlab.model.factories.BookingFactory;
import by.gsu.epamlab.model.factories.PlayFactory;
import by.gsu.epamlab.model.ifaces.IBookingDAO;
import by.gsu.epamlab.model.ifaces.IPlayDAO;

/**
 * Servlet implementation class OrderController
 */

@WebServlet("/booking")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		IPlayDAO playDAO = PlayFactory.getClassFromFactory();
		ServletContext context = getServletContext();
		String filePath = context.getRealPath("WEB-INF/classes/" + "theaterHall.xml");
		IBookingDAO bookingDAO = BookingFactory.getClassFromFactory(); 
		try {
			Map<String, Place> hall = playDAO.getHall(filePath);
			Set<Booking> bookings = bookingDAO.getBookingsDB(); 
			HttpSession session = request.getSession();
			Map<Integer, Play> playList = (Map<Integer, Play>) session.getAttribute("playlist");
			Integer id = Integer.parseInt(request.getParameter("ID"));
			Play play = playList.get(id);
			Set<Booking> bookingFree = playDAO.getShemaHall(hall, id);
			request.setAttribute("bookingFree", bookingFree);
			request.setAttribute("play", play);
			request.setAttribute("hall", hall);
			request.setAttribute("bookings", bookings);
			jump(Constants.FOLDER_VIEWS + "/booking.jsp", request, response);
		} catch (UserException | BookingException e) {
			// TODO Auto-generated catch block
			jump("/main", e.getMessage(), request, response);
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
