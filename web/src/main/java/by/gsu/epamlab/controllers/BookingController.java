package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.model.beans.Constants;
import by.gsu.epamlab.model.beans.Play;

/**
 * Servlet implementation class OrderController
 */

@WebServlet("/booking")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	Map<Integer,int[]> zale=new TreeMap<>();
	
	{
	zale.put(1,new int[10]);
	zale.put(2,new int[10]);
	zale.get(2)[3]=1;
	zale.put(3,new int[10]);
	
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		List<Play> playList = (List<Play>) session.getAttribute("playlist");
		int id = Integer.parseInt(request.getParameter("id"));
		Play play = playList.get(id-1);
		request.setAttribute("play", play);
		
		request.setAttribute("zale", zale);
		request.getServletContext().getRequestDispatcher(Constants.FOLDER_VIEWS + "/booking.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("place");
		System.out.println(s);
		String [] places = s.split("_");
		int row = Integer.parseInt(places[0]);
		int place = Integer.parseInt(places[1]);
		String date = request.getParameter("date");
		String title = request.getParameter("title");		
		zale.get(row)[place-1]=1;
		doGet(request, response);
	}
}
