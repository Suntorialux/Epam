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

import by.gsu.epamlab.model.beans.Constants;
import by.gsu.epamlab.model.beans.Place;
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.UserException;
import by.gsu.epamlab.model.factories.PlayFactory;
import by.gsu.epamlab.model.ifaces.IPlayDAO;

/**
 * Servlet implementation class OrderController
 */

@WebServlet("/booking")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		IPlayDAO playDAO = PlayFactory.getClassFromFactory();
		ServletContext context = getServletContext();
		String filePath = context.getRealPath("WEB-INF/classes/" + "theaterHall.xml");

		try {
			Map<String, Place> hall = playDAO.getHall(filePath);
			HttpSession session = request.getSession();
			Map<Integer, Play> playList = (Map<Integer, Play>) session.getAttribute("playlist");
			Integer id = Integer.parseInt(request.getParameter("id"));
			Play play = playList.get(id);
			request.setAttribute("play", play);
			request.setAttribute("hall", hall);
			jump(Constants.FOLDER_VIEWS + "/booking.jsp", request, response);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			jump(Constants.FOLDER_VIEWS + Constants.PAGE_LOGIN, e.getMessage(), request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
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
