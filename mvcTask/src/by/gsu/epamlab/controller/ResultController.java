package by.gsu.epamlab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.services.Operations;

@WebServlet("/controller")
public class ResultController extends HttpServlet {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/start.jsp");  
		rd.forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String[] flags = request.getParameterValues("flag");
		String operation = request.getParameter("select");
		if(flags==null||!(Operations.isDataOk(flags))) {
			doGet(request, response);
		} else {
			StringBuilder num = Operations.printData(flags);
			request.setAttribute("operation", operation);
			request.setAttribute("result", Operations.getResult(operation, flags));
			request.setAttribute("numbers", num);
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		}
	} 

}
