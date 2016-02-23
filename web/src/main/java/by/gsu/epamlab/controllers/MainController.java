package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.util.List;
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
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.UserException;
import by.gsu.epamlab.model.factories.PlayFactory;
import by.gsu.epamlab.model.ifaces.IPlayDAO;

/**
 * Servlet implementation class MainController
 */

@WebServlet(urlPatterns = "/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {

		IPlayDAO playDAO = PlayFactory.getClassFromFactory();
		ServletContext context = getServletContext();
		String filePath = context.getRealPath("/WEB-INF/classes/" + Constants.PLAY_LIST_XML);
		try {
			List<Play> playlist = playDAO.getPlaysFromXML(filePath);
			playDAO.addPlaysDB(playlist);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IPlayDAO playDAO = PlayFactory.getClassFromFactory();
		try {
			Map<Integer, Play> playlist = playDAO.getPlaysFromDB();
			HttpSession session = request.getSession();
			session.setAttribute("playlist", playlist);
			jump(Constants.FOLDER_VIEWS + Constants.PAGE_MAIN, request, response);
			System.out.println("main");
		} catch (UserException e) {
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
