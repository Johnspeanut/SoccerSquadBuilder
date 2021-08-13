package squad.servlet;

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

import squad.dal.CustomizedTeamsDao;
import squad.dal.PlayersDao;

@WebServlet("/createcustomizedteam")
public class CreateCustomizedTeam extends HttpServlet {

	protected CustomizedTeamsDao customizedTeamsDao;
	protected PlayersDao playersDao;

	@Override
	public void init() throws ServletException {
		customizedTeamsDao = CustomizedTeamsDao.getInstance();
		playersDao = PlayersDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final Map<String, String> dataMap = new HashMap<>();
		req.setAttribute("dataMap", dataMap);
		req.getRequestDispatcher("/CreateCustomizedTeam.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomizedTeams customizedTeam = null;

		// Retrieve and validate name.
		String userName = req.getParameter("username");
		String p1Id = req.getParameter("p1Id");
		String p2Id = req.getParameter("p2Id");
		String p3Id = req.getParameter("p3Id");
		String p4Id = req.getParameter("p4Id");
		String p5Id = req.getParameter("p5Id");
		String p6Id = req.getParameter("p6Id");
		String p7Id = req.getParameter("p7Id");
		String p8Id = req.getParameter("p8Id");
		String p9Id = req.getParameter("p9Id");
		String p10Id = req.getParameter("p10Id");
		String p11Id = req.getParameter("p11Id");
		

		try {
			Player player1 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p1Id));
			Player player2 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p2Id));
			Player player3 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p3Id));
			Player player4 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p4Id));
			Player player5 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p5Id));
			Player player6 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p6Id));
			Player player7 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p7Id));
			Player player8 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p8Id));
			Player player9 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p9Id));
			Player player10 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p10Id));
			Player player11 = playersDao.getPlayerAllinfoByPlayerId(Integer.parseInt(p11Id));
			

			Users user = new Users(userName, null);
			customizedTeam = new CustomizedTeams(user, player1, player2, player3, player4, player5, player6, player7,
					player8, player9, player10, player11);
			customizedTeam = customizedTeamsDao.create(customizedTeam);
		} catch (SQLException exception) {
			exception.printStackTrace();
			throw new IOException(exception);
		} finally {
			System.out.println("Finished customized team creation: " + customizedTeam);
		}
		
		
		req.getRequestDispatcher("/CreateCustomizedTeam.jsp").forward(req, resp);
	}
}
