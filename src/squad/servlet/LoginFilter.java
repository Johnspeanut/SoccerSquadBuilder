package squad.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/findcustomizedteams")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		if(session == null||session.getAttribute("CURRENT_USER") == null) {
			resp.sendRedirect(req.getContextPath()+"/login.jsp"); // No logged-in user found, so redirect to login page
		}else {
			chain.doFilter(request, response);  //Logged-in user found, so just continue request.
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// If you have any <init-param> in web.xml, then you could get them here by config.getInitParameter("name") and assign it as field.
		// TODO Auto-generated method stub
	}
	
	//basic validation of pages that do not require authentication
	private boolean needsAuthentication(String url) {
		String[] validNonAuthenticationUrls = {"Login.jsp", "Register.jsp"};
		for(String validUrl:validNonAuthenticationUrls) {
			if(url.endsWith(validUrl)) {
				return false;
			}
		}
		return true;
	}

}
