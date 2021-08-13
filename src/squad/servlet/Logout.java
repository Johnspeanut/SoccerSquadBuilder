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

@WebServlet(name="logout",urlPatterns= {"/logout"})
public class Logout extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		resp.sendRedirect(req.getContextPath()+"/QueryPlayers.jsp");

	}
}

