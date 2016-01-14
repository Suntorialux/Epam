package by.gsu.epamlab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.services.Operations;

@WebServlet("/controller")
public class Controller extends HttpServlet {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/start.jsp").forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String[] flags = request.getParameterValues("flag");
		String operation = request.getParameter("select");
		if(flags==null||!(Operations.isDataOk(flags))) {
			doGet(request, response);
		} else {		
			request.setAttribute("operation", operation);
			request.setAttribute("result", Operations.getResult(operation, flags));
			request.setAttribute("flags", flags);
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		}
	} 

}
