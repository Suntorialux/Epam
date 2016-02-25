package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.util.Map;
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
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.BookingException;
import by.gsu.epamlab.model.exceptions.HallException;
import by.gsu.epamlab.model.factories.BookingFactory;
import by.gsu.epamlab.model.factories.HallFactory;
import by.gsu.epamlab.model.ifaces.IBookingDAO;
import by.gsu.epamlab.model.ifaces.IHallDAO;

/**
 * Servlet implementation class OrderController
 */

@WebServlet(urlPatterns = "/booking")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {

		IHallDAO hallDAO = HallFactory.getClassFromFactory();
		ServletContext context = getServletContext();
		String filePath = context.getRealPath(Constants.RESOURSE_PATH + Constants.THEATER_HALL_XML);
		try {
			Map<String, int[]> hall = hallDAO.getHall(filePath);
			context.setAttribute(Constants.HALL, hall);
		} catch (HallException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IHallDAO hallDAO = HallFactory.getClassFromFactory();
		IBookingDAO bookingDAO = BookingFactory.getClassFromFactory();
		try {

			HttpSession session = request.getSession();
			Map<Integer, Play> playList = (Map<Integer, Play>) session.getAttribute(Constants.PLAYLIST);
			Integer idPlay = Integer.parseInt(request.getParameter(Constants.ID_PLAY));
			Play play = playList.get(idPlay);
			Map<String, int[]> hall = (Map<String, int[]>) getServletContext().getAttribute(Constants.HALL);
			Map<Integer, Booking> bookings = bookingDAO.getBookingsDB(idPlay);
			Map<String, Booking[][]> bookingHall = hallDAO.getBookingHall(hall, bookings);
			request.setAttribute(Constants.PLAY, play);
			request.setAttribute(Constants.BOOKING_HALL, bookingHall);
			jump(Constants.FOLDER_VIEWS + Constants.PAGE_BOOKING, request, response);
			
		} catch (BookingException e) {
			
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
