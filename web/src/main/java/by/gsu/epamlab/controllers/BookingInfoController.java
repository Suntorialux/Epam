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
@WebServlet("/booking/info")
public class BookingInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String [] querry = request.getParameter("place").split("_");
		Integer idPlay = Integer.parseInt(querry[0]);
		String sector = querry[1];
		Integer row = Integer.parseInt(querry[2]);
		Integer place = Integer.parseInt(querry[3]);
		Integer price = Integer.parseInt(querry[4]);
		HttpSession session = request.getSession();
		Map<Integer, Play> playList = (Map<Integer, Play>) session.getAttribute("playlist");
		Play play = playList.get(idPlay);
		Booking booking = new Booking(sector, row, place, price, "free");
		session.setAttribute("play", play);
		session.setAttribute("booking", booking);
		
		jump(Constants.FOLDER_VIEWS+"/bookingInfo.jsp", request, response);
		
		}
	
	protected void jump(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
