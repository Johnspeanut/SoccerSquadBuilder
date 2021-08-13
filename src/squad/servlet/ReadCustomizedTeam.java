package squad.servlet;

import squad.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import squad.dal.CustomizedTeamsDao;
import squad.dal.PlayersDao;

@WebServlet("/readcustomizedteam")
public class ReadCustomizedTeam extends HttpServlet {

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

		CustomizedTeams customizedTeam = null;

		try {
			final String customizedTeamdId = req.getParameter("customizedTeamId");
			customizedTeam = customizedTeamsDao.getTeamById(Integer.parseInt(customizedTeamdId));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		} finally {
			System.out.println("Finished customized team loading: " + customizedTeam);
		}

		req.setAttribute("customizedTeam", customizedTeam);
		req.getRequestDispatcher("/ReadCustomizedTeam.jsp").forward(req, resp);
	}
}
