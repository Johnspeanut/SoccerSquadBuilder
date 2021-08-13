package squad.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import squad.dal.CustomizedTeamsDao;
import squad.dal.PlayersDao;
import squad.model.CustomizedTeams;

public class RestfulCustomizedTeamServlet extends HttpServlet {

	private static final long serialVersionUID = 7552625439321101462L;
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	protected CustomizedTeamsDao customizedTeamsDao;
	protected PlayersDao playersDao;

	@Override
	public void init() throws ServletException {
		customizedTeamsDao = CustomizedTeamsDao.getInstance();
		playersDao = PlayersDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String requestUrl = request.getRequestURI();
		final Pattern teamIdPattern = Pattern.compile("(?<=customized-team/).*");
		final Matcher teamIdMatcher = teamIdPattern.matcher(requestUrl);
		final String teamId = teamIdMatcher.find() ? teamIdMatcher.group() : null;

		if (teamId == null || !isNumeric(teamId)) {
			response.sendError(500);
			return;
		}

		final CustomizedTeams team = getCustomizedTeamByIdHelper(Integer.parseInt(teamId));

		if (team == null) {
			response.sendError(500);
			return;
		}

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(gson.toJson(team));
		return;
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String payload = getPayload(request);

		CustomizedTeams teamWithIdsOnly = gson.fromJson(payload, CustomizedTeams.class);
		System.out.println(teamWithIdsOnly);

		CustomizedTeams updatedTeam = updateCustomizedTeamHelper(teamWithIdsOnly);

		if (updatedTeam == null) {
			response.sendError(500);
			return;
		}

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(gson.toJson(updatedTeam));
		return;
	}

	private static String getPayload(HttpServletRequest request) throws IOException {

		String payload = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		payload = stringBuilder.toString();
		return payload;
	}

	private CustomizedTeams getCustomizedTeamByIdHelper(final int teamId) {
		System.out.println("Getting team Id: " + teamId);
		try {
			return customizedTeamsDao.getTeamById(teamId);
		} catch (SQLException exception) {
			exception.printStackTrace();
			return null;
		}
	}

	private CustomizedTeams updateCustomizedTeamHelper(final CustomizedTeams team) {
		System.out.println("Updating team Id: " + team.getTeam_id());
		try {
			return customizedTeamsDao.updateTeamById(team);
		} catch (SQLException exception) {
			exception.printStackTrace();
			return null;
		}
	}

	private boolean isNumeric(String strNum) {
		final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		if (strNum == null) {
			return false;
		}
		return pattern.matcher(strNum).matches();
	}
}
