package squad.tools;

import squad.dal.*;
import squad.model.*;

import java.sql.SQLException;
import java.util.List;

public class Inserter {

	public static void main(String[] args) throws SQLException {
		// DAO instances.
		UsersDao usersDao = UsersDao.getInstance();
		PlayersDao playersDao = PlayersDao.getInstance();
		TeamDao teamDao = TeamDao.getInstance();
		CustomizedTeamsDao customizedTeamsDao = CustomizedTeamsDao.getInstance();

		// truncate tables to prevent issues
		customizedTeamsDao.truncate();
		usersDao.truncate();

		// INSERT objects from our model.
		Users user1 = new Users("001", "password");
		user1 = usersDao.insert(user1);
		Users user2 = new Users("002", "password");
		user2 = usersDao.insert(user2);
		Users user3 = new Users("Test", "password");
		user3 = usersDao.insert(user3);

		Team team1 = teamDao.getTeamById(1);
		Team team2 = teamDao.getTeamById(2);
		Team team3 = teamDao.getTeamById(3);
		Team team4 = teamDao.getTeamById(4);
		
		Player player1 = playersDao.getPlayerAllinfoByPlayerId(1);
		Player player2 = playersDao.getPlayerAllinfoByPlayerId(2);
		Player player3 = playersDao.getPlayerAllinfoByPlayerId(3);
		Player player4 = playersDao.getPlayerAllinfoByPlayerId(4);
		Player player5 = playersDao.getPlayerAllinfoByPlayerId(5);
		Player player6 = playersDao.getPlayerAllinfoByPlayerId(6);
		Player player7 = playersDao.getPlayerAllinfoByPlayerId(7);
		Player player8 = playersDao.getPlayerAllinfoByPlayerId(8);
		Player player9 = playersDao.getPlayerAllinfoByPlayerId(9);
		Player player10 = playersDao.getPlayerAllinfoByPlayerId(10);
		Player player11 = playersDao.getPlayerAllinfoByPlayerId(11);
		Player player12 = playersDao.getPlayerAllinfoByPlayerId(12);
		
		System.out.println(player1);

		

		CustomizedTeams ct1 = new CustomizedTeams(user1, player1, player2, player3, player4, player5, player6, player7,
				player8, player9, player10, player11);
		ct1 = customizedTeamsDao.create(ct1);
		CustomizedTeams ct2 = new CustomizedTeams(user1, player12, player2, player3, player4, player5, player6, player7,
				player8, player9, player10, player11);
		ct2 = customizedTeamsDao.create(ct2);
		CustomizedTeams ct3 = new CustomizedTeams(user1, player12, player2, player4, player3, player5, player6, player7,
				player8, player9, player10, player11);
		ct3 = customizedTeamsDao.create(ct3);

		ct1 = customizedTeamsDao.getCustomizedTeamsByUserName("001").get(0);
		// ct2 = customizedTeamsDao.getTeamById(2);
		// ct3 = customizedTeamsDao.getTeamById(3);

		// // READ User
		// Users u1 = usersDao.getUserByUserName("001");
		// System.out.format("Reading user: u:%s p:%s \n",
		// u1.getUserName(), u1.getPassword());

		// // DELETE User
		// usersDao.delete(user3);

		// //READ Team
		// System.out.format("Reading Team: id:%s n:%s l:%s o:%s a:%s m:%s d:%s i:%s
		// d:%s t:%s \n",
		// team1.getTeam_id(), team1.getTeam_name(), team1.getLeague(),
		// team1.getOverall(), team1.getAttack(), team1.getMid_field(),
		// team1.getDefence(),
		// team1.getInternational_prestige(), team1.getDomestic_prestige(),
		// team1.getTransfer_budget());
		//
		//
		// List<Team> t1List = teamDao.getTeamsByLeague("English Premier League (1)");
		// for(Team t : t1List) {
		// System.out.format("Looping teams: id:%s n:%s l:%s o:%s a:%s m:%s d:%s i:%s
		// d:%s t:%s \n",
		// t.getTeam_id(), t.getTeam_name(), t.getLeague(), t.getOverall(),
		// t.getAttack(), t.getMid_field(), t.getDefence(),
		// t.getInternational_prestige(), t.getDomestic_prestige(),
		// t.getTransfer_budget());
		// }
		//
		//
		// //READ Player
		// System.out.format("Reading Player: id:%s n:%s p:%s d:%s h:%s w:%s or:%s pr:%s
		// bp:%s bor:%s v:%s w:%s url:%s t:%s n:%s \n",
		// player1.getPlayer_id(), player1.getPlayer_name(), player1.getPositions(),
		// player1.getDate_of_birth(), player1.getHeight(), player1.getWeight(),
		// player1.getOverall_rating(),
		// player1.getPotential_rating(), player1.getBest_position(),
		// player1.getBest_overall_rating(), player1.getValue(), player1.getWage(),
		// player1.getPlayer_image_url(),
		// player1.getTeam().getTeam_id(),player1.getNationality());
		//
		//
		// List<Player> p1List = playersDao.getPlayersByPlayerName("Kevin De Bruyne");
		// for(Player p : p1List) {
		// System.out.format("Looping players: id:%s n:%s p:%s d:%s h:%s w:%s or:%s
		// pr:%s bp:%s bor:%s v:%s w:%s url:%s t:%s n:%s \n",
		// p.getPlayer_id(), p.getPlayer_name(), player1.getPositions(),
		// p.getDate_of_birth(), p.getHeight(), p.getWeight(), p.getOverall_rating(),
		// p.getPotential_rating(), p.getBest_position(), p.getBest_overall_rating(),
		// p.getValue(), p.getWage(), p.getPlayer_image_url(),
		// p.getTeam().getTeam_id(),p.getNationality());
		//
		// }

		// READ CT
		System.out.println(ct1);
//
//		List<CustomizedTeams> ct1List = customizedTeamsDao.getCustomizedTeamsByUserName("001");
//		for (CustomizedTeams ct : ct1List) {
//			System.out.println(ct);
//		}
	}
}
