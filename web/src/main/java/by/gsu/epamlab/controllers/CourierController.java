package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.gsu.epamlab.model.beans.Booking;
import by.gsu.epamlab.model.beans.Constants;
import by.gsu.epamlab.model.exceptions.BookingException;
import by.gsu.epamlab.model.factories.BookingFactory;
import by.gsu.epamlab.model.ifaces.IBookingDAO;

/**
 * Servlet implementation class CourierController
 */
@WebServlet(urlPatterns="/courier")
public class CourierController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<Integer, Booking> bookings = new HashMap<>();
	private int flag;
	private String login;
	private Integer id;
	private String status;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourierController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		IBookingDAO bookingDAO = BookingFactory.getClassFromFactory();
		try {
			Set<String> logins = bookingDAO.getUserLoginFromBooking();
			request.setAttribute(Constants.LOGINS, logins);
			jump(Constants.FOLDER_VIEWS+Constants.PAGE_COURIER, request, response);
		} catch (BookingException e) {
			// TODO Auto-generated catch block
			jumpError(e.getMessage(), request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = request.getParameter("operation");
		IBookingDAO bookingDAO = BookingFactory.getClassFromFactory();
		try {
			switch (operation) {
			case "all": {
				bookings = bookingDAO.getBookingsDB();
				flag = 1;
				break;
			}
			case Constants.PLAY: {
				int idPlay = Integer.parseInt(request.getParameter(Constants.ID_PLAY));
				bookings = bookingDAO.getBookingsDB(idPlay);
				flag = 2;
				id = idPlay;
				break;
			}
			case Constants.USER: {
				String userLogin = request.getParameter("userLogin");
				bookings = bookingDAO.getBookingsDB(userLogin);
				flag = 3;
				login = userLogin;
				break;
			}
			case "status": {
				String statusBook = request.getParameter("status");
				bookings = bookingDAO.getBookingsByStatus(statusBook);
				flag = 4;
				status = statusBook;
				break;
			}
			case "change on isBought": {
				int idBooking = Integer.parseInt(request.getParameter("idBooking"));
				bookingDAO.changeStatusBooking(idBooking);
				setBookings(bookingDAO);
				break;
			}
			case "delete": {
				int idBooking = Integer.parseInt(request.getParameter("idBooking"));
				bookingDAO.deleteBooking(idBooking);
				setBookings(bookingDAO);
				break;
			}
			case "print": {
				response.setContentType("text/plain");
				response.setHeader("Content-Disposition","attachment;filename=bookings.csv");
				PrintWriter printWriter = response.getWriter();
				for(Map.Entry<Integer, Booking> entry : bookings.entrySet()) {
					printWriter.write(""+entry.getKey()+";"+entry.getValue().toString()+"\n");
					printWriter.flush();					
				}			
				printWriter.close();
				break;
			}

			}
			Set<String> logins = bookingDAO.getUserLoginFromBooking();
			request.setAttribute(Constants.LOGINS, logins);
			request.setAttribute(Constants.BOOKINGS, bookings);
			jump(Constants.FOLDER_VIEWS+Constants.PAGE_COURIER, request, response);
		} catch (BookingException e) {
			jumpError(e.getMessage(), request, response);
		}

	}

	private void setBookings(IBookingDAO bookingDAO) throws BookingException {
		switch (flag) {
		case 1: {
			bookings = bookingDAO.getBookingsDB();
			break;
		}
		case 2: {
			bookings = bookingDAO.getBookingsDB(id);
			break;
		}
		case 3: {
			bookings = bookingDAO.getBookingsDB(login);
			break;
		}
		case 4: {
			bookings = bookingDAO.getBookingsByStatus(status);
			break;
		}
		}
	}
	
	protected void jump(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.include(request, response);

		
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
