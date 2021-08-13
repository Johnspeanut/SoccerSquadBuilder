package squad.servlet;

import squad.dal.*;
import squad.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="login",urlPatterns= {"/login"})
public class Login extends HttpServlet {
	protected LoginDao loginDao;
	
	public void init() throws ServletException{
		loginDao = loginDao.getInstance();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String,String>();
		request.setAttribute("messages", messages);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String encode_password = CryptoUtil.encode(password);
		/* HttpSession session = request.getSession(); */
		
	        try {
	        	Users user = loginDao.login(username, encode_password);
	        	if(user != null) {
	        		request.getSession().setAttribute("CURRENT_USER", user);
					/* messages.put("success","CURRENT_USER"+ username); */
					/* session.setAttribute("username", username); */
					
					 request.getRequestDispatcher("/FindCustomizedTeams.jsp").forward(request,response);
					 
						/* response.sendRedirect("/FindCustomizedTeams.jsp"); */
	        	}else {
	        		request.setAttribute("err", "Wrong username or password");
//	        		messages.put("success","Wrong username or password");
					request.getRequestDispatcher("/login.jsp").forward(request, response); 
					/* response.sendRedirect("/FindCustomizedTeams.jsp"); */
	        	}
	  
	        } catch (SQLException e) {
	        	request.setAttribute("err", "System error");
//	        	messages.put("success","System error");
	        	request.getRequestDispatcher("/login.jsp").forward(request, response); 
				/* response.sendRedirect("/FindCustomizedTeams.jsp"); */
        		return;
	        }
	}
	
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String,String>();
		request.setAttribute("messages", messages);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String encode_password = CryptoUtil.encode(password);
		/* HttpSession session = request.getSession(); */
		
	        try {
	        	Users user = loginDao.login(username, encode_password);
	        	if(user != null) {
	        		request.getSession().setAttribute("CURRENT_USER", user);
					/* messages.put("success","CURRENT_USER"+ username); */
					/* session.setAttribute("username", username); */
					
					 request.getRequestDispatcher("/FindCustomizedTeams.jsp").forward(request,response);
					 
						/* response.sendRedirect("/FindCustomizedTeams.jsp"); */
	        	}else {
	        		request.setAttribute("err", "Wrong username or password");
//	        		messages.put("success","Wrong username or password");
					request.getRequestDispatcher("/login.jsp").forward(request, response); 
					/* response.sendRedirect("/FindCustomizedTeams.jsp"); */
	        	}
	  
	        } catch (SQLException e) {
	        	request.setAttribute("err", "System error");
//	        	messages.put("success","System error");
	        	request.getRequestDispatcher("/login.jsp").forward(request, response); 
				/* response.sendRedirect("/FindCustomizedTeams.jsp"); */
        		return;
	        }
	}
}

