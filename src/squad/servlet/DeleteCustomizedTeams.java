package squad.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import squad.dal.*;
import squad.model.*;

@WebServlet("/deletecustomizedteams")
public class DeleteCustomizedTeams extends HttpServlet {
	
	protected CustomizedTeamsDao customizedTeamsDao;
	
	public void init() throws ServletException {
		customizedTeamsDao = CustomizedTeamsDao.getInstance();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        messages.put("title", "Delete CustomizedTeams");        
        req.getRequestDispatcher("/DeleteCustomizedTeams.jsp").forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {

        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        String team_id = req.getParameter("teamId");
        if (team_id == null || team_id.trim().isEmpty()) {
            messages.put("title", "Invalid TeamId");
            messages.put("disableSubmit", "true");
        } else {
        	CustomizedTeams customizedTeams = new CustomizedTeams(Integer.parseInt(team_id));
	        try {
	        	customizedTeams = customizedTeamsDao.delete(customizedTeams);
	        	// Update the message.
		        if (customizedTeams == null) {
		            messages.put("title", "Successfully deleted " + team_id);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + team_id);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/DeleteCustomizedTeams.jsp").forward(req, resp);
    }
}
	

