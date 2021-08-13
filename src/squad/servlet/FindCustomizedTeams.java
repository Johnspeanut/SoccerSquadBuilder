package squad.servlet;

import squad.dal.*;
import squad.model.*;

import java.io.IOException;
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

@WebServlet("/findcustomizedteams")
public class FindCustomizedTeams extends HttpServlet {
	protected CustomizedTeamsDao customizedTeamsDao;
	
	public void init() throws ServletException{
		customizedTeamsDao = CustomizedTeamsDao.getInstance();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String,String>();
		req.setAttribute("messages", messages);
		req.setAttribute("CUSTOMIZEDTEAM", " active");
		
		List<CustomizedTeams> customizedTeams = new ArrayList<CustomizedTeams>();
		
		
		String userName = req.getParameter("username");
		if (userName == null || userName.trim().isEmpty()) {
			messages.put("success", "Please enter a valid username.");
		} else {
			try {
				customizedTeams = customizedTeamsDao.getCustomizedTeamsByUserName(userName);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success","Displaying all customized teams for "+ userName);
			messages.put("previousUserName", userName);
		}
		req.setAttribute("customizedTeams", customizedTeams);
		
		req.getRequestDispatcher("/FindCustomizedTeams.jsp").forward(req, resp);
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String,String>();
		req.setAttribute("messages", messages);
		req.setAttribute("CUSTOMIZEDTEAM", " active");
		
		List<CustomizedTeams> customizedTeams = new ArrayList <CustomizedTeams>();
		String userName = req.getParameter("username");
		if (userName == null || userName.trim().isEmpty()) {
			messages.put("success", "Please enter a valid username.");
		} else {
			try {
				customizedTeams = customizedTeamsDao.getCustomizedTeamsByUserName(userName);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success","Displaying all customized teams for "+ userName);

		}
		req.setAttribute("customizedTeams", customizedTeams);
		
		req.getRequestDispatcher("/FindCustomizedTeams.jsp").forward(req, resp);
	}

}
