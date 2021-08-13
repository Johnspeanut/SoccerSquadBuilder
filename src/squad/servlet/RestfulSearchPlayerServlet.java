package squad.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import squad.dal.CustomizedTeamsDao;
import squad.dal.PlayersDao;
import squad.model.Player;
import squad.model.QueryTerms;

public class RestfulSearchPlayerServlet extends HttpServlet {

	private static final long serialVersionUID = -5763286335074457149L;

	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	protected CustomizedTeamsDao customizedTeamsDao;
	protected PlayersDao playersDao;

	@Override
	public void init() throws ServletException {
		customizedTeamsDao = CustomizedTeamsDao.getInstance();
		playersDao = PlayersDao.getInstance();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String payload = getPayload(request);
		QueryTerms queryTerms = gson.fromJson(payload, QueryTerms.class);
		queryTerms.toLower();

		System.out.println(queryTerms);

		List<Player> players = getPlayersByQueryTermsHelper(queryTerms);

		System.out.println(players);

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(gson.toJson(players));
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

	private List<Player> getPlayersByQueryTermsHelper(final QueryTerms queryTerms) {
		System.out.println("Getting players with query terms: " + queryTerms);
		try {
			return playersDao.getPlayersByQueryTerms(queryTerms);
		} catch (SQLException exception) {
			exception.printStackTrace();
			return Collections.emptyList();
		}
	}
}
