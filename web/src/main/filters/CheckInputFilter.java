

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.model.constants.Constants;

/**
 * Servlet Filter implementation class CheckInputFilter
 */
@WebFilter(urlPatterns = { "/login", "/registration", "/booking/*"})

public class CheckInputFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
	
		Enumeration<String> enumeration = httpRequest.getParameterNames();
		if (!enumeration.hasMoreElements()) {
			httpResponse.sendRedirect(httpRequest.getContextPath());
			return;
		}

		
		while (enumeration.hasMoreElements()) {
			String parametrName = enumeration.nextElement();
			String parametrValue = httpRequest.getParameter(parametrName);
			if (Constants.EMPTY.equals(parametrValue)) {
				httpResponse.sendRedirect(httpRequest.getContextPath());
				return;
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
