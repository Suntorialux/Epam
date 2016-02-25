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
import by.gsu.epamlab.model.beans.Constants;
import by.gsu.epamlab.model.beans.Play;

/**
 * Servlet implementation class OrderController
 */
@WebServlet(urlPatterns="/booking/info")
public class BookingInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final int INDEX_PLAY = 0;
	private final int INDEX_SECTOR = 1;
	private final int INDEX_ROW = 2;
	private final int INDEX_PLACE = 3;
	private final int INDEX_PRICE = 4;
	private final String STATUS_FREE = "free";
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String [] paramBooking = request.getParameter(Constants.PLACE).split(Constants.SEPARATOR);
		Integer idPlay = Integer.parseInt(paramBooking[INDEX_PLAY]);
		String sector = paramBooking[INDEX_SECTOR];
		Integer row = Integer.parseInt(paramBooking[INDEX_ROW]);
		Integer place = Integer.parseInt(paramBooking[INDEX_PLACE]);
		Integer price = Integer.parseInt(paramBooking[INDEX_PRICE]);
		HttpSession session = request.getSession();
		Map<Integer, Play> playList = (Map<Integer, Play>) session.getAttribute(Constants.PLAYLIST);
		Play play = playList.get(idPlay);
		Booking booking = new Booking(sector, row, place, price, STATUS_FREE);
		session.setAttribute(Constants.PLAY, play);
		session.setAttribute(Constants.BOOKING, booking);
		
		jump(Constants.FOLDER_VIEWS + Constants.PAGE_BOOKING_INFO, request, response);
		
		}
	
	protected void jump(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
