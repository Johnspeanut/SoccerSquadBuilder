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

@WebServlet("/queryplayers")
public class QueryPlayers extends HttpServlet {
	protected PlayersDao playersDao;
	
	public void init() throws ServletException{
		playersDao = PlayersDao.getInstance();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String,String>();
		req.setAttribute("messages", messages);
		req.setAttribute("PLAYER", " active");
		
		List<Player> players = new ArrayList<Player>();
		
		try {
			players = playersDao.getAllPlayers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException(e);
		}
		
		
		String playerName = req.getParameter("playername");
		if (playerName == null || playerName.trim().isEmpty()) {
		} else {
			try {
				players = playersDao.getPlayersByPlayerName(playerName);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success","Displaying results for "+ playerName);
		}
		
		
		String sortby = req.getParameter("sortby");
		if (sortby != null) {
			switch(sortby) {
			case "": break;
			case "name":
			case "age":
			case "wage":
			case "rating":
				try {
					players = playersDao.getPlayersOrderBy(sortby);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new IOException(e);
				}
			}
		}
		
		String popularsearch = req.getParameter("popularsearch");
		if (popularsearch != null) {
			switch(popularsearch) {
			case "": break;
			case "top20forwards":
			case "top20midfields":
			case "top20defenders":
			case "top20goalkeepers":
				try {
					players = playersDao.getPlayersByPopularSearch(popularsearch);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new IOException(e);
				}
			}
		}
		
		
		req.setAttribute("players", players);
		
		req.getRequestDispatcher("/QueryPlayers.jsp").forward(req, resp);
		
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String,String>();
		req.setAttribute("messages", messages);
		req.setAttribute("PLAYER", " active");
		
		List<Player> players = new ArrayList<Player>();
		
		try {
			players = playersDao.getAllPlayers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException(e);
		}
		
		
		String playerName = req.getParameter("playername");
		if (playerName == null || playerName.trim().isEmpty()) {
		} else {
			try {
				players = playersDao.getPlayersByPlayerName(playerName);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success","Displaying results for "+ playerName);
		}
		
		
		String sortby = req.getParameter("sortby");
		if (sortby != null) {
			switch(sortby) {
			case "": break;
			case "name":
			case "age":
			case "wage":
			case "rating":
				try {
					players = playersDao.getPlayersOrderBy(sortby);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new IOException(e);
				}
			}
		}
		
		String popularsearch = req.getParameter("popularsearch");
		if (popularsearch != null) {
			switch(popularsearch) {
			case "": break;
			case "top20forwards":
			case "top20midfields":
			case "top20defenders":
			case "top20goalkeepers":
				try {
					players = playersDao.getPlayersByPopularSearch(popularsearch);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new IOException(e);
				}
			}
		}
		
		
		req.setAttribute("players", players);
		
		req.getRequestDispatcher("/QueryPlayers.jsp").forward(req, resp);
	}

}