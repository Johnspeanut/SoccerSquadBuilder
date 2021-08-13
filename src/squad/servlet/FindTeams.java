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

@WebServlet("/findteams")
public class FindTeams extends HttpServlet {
	protected TeamDao teamsDao;
	
	public void init() throws ServletException{
		teamsDao = TeamDao.getInstance();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String,String>();
		req.setAttribute("TEAM", " active");
		req.setAttribute("messages", messages);
		
		List<Team> teams = new ArrayList<Team>();
		
		
		try {
			teams = teamsDao.getAllTeams();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		
		
		String teamName = req.getParameter("teamname");
		if (teamName == null || teamName.trim().isEmpty()) {
		} else {
			try {
				teams = teamsDao.getTeamsByTeamName(teamName);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success","Displaying results for "+ teamName);
			messages.put("previouTeamName", teamName);
		}
		
		
		String sortby = req.getParameter("sortby");
		if (sortby != null) {
			switch(sortby) {
			case "": break;
			case "name":
			case "defence":
			case "attack":
			case "score":
			case "transferbudget":
				try {
					teams = teamsDao.getTeamsOrderBy(sortby);
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException(e);
				}
			}
		}
		
		
		req.setAttribute("Teams", teams);
		
		req.getRequestDispatcher("/FindTeams.jsp").forward(req, resp);
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String,String>();
		req.setAttribute("messages", messages);
		req.setAttribute("TEAM", " active");
		
		List<Team> teams = new ArrayList<Team>();
		
		
		try {
			teams = teamsDao.getAllTeams();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		
		
		String teamName = req.getParameter("teamname");
		if (teamName == null || teamName.trim().isEmpty()) {
		} else {
			try {
				teams = teamsDao.getTeamsByTeamName(teamName);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success","Displaying results for "+ teamName);
			messages.put("previouTeamName", teamName);
		}
		
		
		String sortby = req.getParameter("sortby");
		if (sortby != null) {
			switch(sortby) {
			case "": break;
			case "name":
			case "defence":
			case "attack":
			case "score":
			case "transferbudget":
				try {
					teams = teamsDao.getTeamsOrderBy(sortby);
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException(e);
				}
			}
		}
		
		
		req.setAttribute("Teams", teams);
		
		req.getRequestDispatcher("/FindTeams.jsp").forward(req, resp);
	}

}