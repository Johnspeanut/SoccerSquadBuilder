package squad.model;

public class CustomizedTeams {
	protected int team_id;
	protected Users user;
	protected Player p1;
	protected Player p2;
	protected Player p3;
	protected Player p4;
	protected Player p5;
	protected Player p6;
	protected Player p7;
	protected Player p8;
	protected Player p9;
	protected Player p10;
	protected Player p11;

	

	public CustomizedTeams(int team_id, Users user, Player p1, Player p2, Player p3, Player p4, Player p5, Player p6,
			Player p7, Player p8, Player p9, Player p10, Player p11) {
		super();
		this.team_id = team_id;
		this.user = user;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
		this.p6 = p6;
		this.p7 = p7;
		this.p8 = p8;
		this.p9 = p9;
		this.p10 = p10;
		this.p11 = p11;
	}
	

	public CustomizedTeams(Users user, Player p1, Player p2, Player p3, Player p4, Player p5, Player p6, Player p7,
			Player p8, Player p9, Player p10, Player p11) {
		super();
		this.user = user;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
		this.p6 = p6;
		this.p7 = p7;
		this.p8 = p8;
		this.p9 = p9;
		this.p10 = p10;
		this.p11 = p11;
	}
	
	public CustomizedTeams(int team_id) {
		super();
		this.team_id = team_id;
	}
	

	public int getTeam_id() {
		return team_id;
	}


	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public Player getP1() {
		return p1;
	}


	public void setP1(Player p1) {
		this.p1 = p1;
	}


	public Player getP2() {
		return p2;
	}


	public void setP2(Player p2) {
		this.p2 = p2;
	}


	public Player getP3() {
		return p3;
	}


	public void setP3(Player p3) {
		this.p3 = p3;
	}


	public Player getP4() {
		return p4;
	}


	public void setP4(Player p4) {
		this.p4 = p4;
	}


	public Player getP5() {
		return p5;
	}


	public void setP5(Player p5) {
		this.p5 = p5;
	}


	public Player getP6() {
		return p6;
	}


	public void setP6(Player p6) {
		this.p6 = p6;
	}


	public Player getP7() {
		return p7;
	}


	public void setP7(Player p7) {
		this.p7 = p7;
	}


	public Player getP8() {
		return p8;
	}


	public void setP8(Player p8) {
		this.p8 = p8;
	}


	public Player getP9() {
		return p9;
	}


	public void setP9(Player p9) {
		this.p9 = p9;
	}


	public Player getP10() {
		return p10;
	}


	public void setP10(Player p10) {
		this.p10 = p10;
	}


	public Player getP11() {
		return p11;
	}


	public void setP11(Player p11) {
		this.p11 = p11;
	}
	
	public double getGoalKeepScore() {
		return p1.getGoalkeep_score();
	}
	
	public double getAttackScore() {
		return p7.getAttack_score() * 0.2 + p11.getAttack_score() * 0.2 + p9.getAttack_score() * 0.4 + p8.getAttack_score() * 0.1 + p10.getAttack_score() * 0.1;
	}
	
	public double getDefenceScore() {
		return p4.getDefence_score() * 0.3 + p5.getDefence_score() * 0.3 + p3.getDefence_score() * 0.15 + p2.getDefence_score() * 0.15 + p6.getDefence_score() * 0.1;
	}
	
	public double getOverallScore() {
		return (getGoalKeepScore() + getAttackScore() + getDefenceScore()) / 3.0;
	}
	
	public double getTotalBudgets() {
		return p1.getWage() + p2.getWage() + p3.getWage() + p4.getWage() + 
				p5.getWage() + p6.getWage() + p7.getWage() + p8.getWage() + p9.getWage() + p10.getWage() + p11.getWage();
	}


	@Override
	public String toString() {
		return "CustomizedTeams [team_id=" + team_id + ", user=" + user + ", p1=" + p1 + ", p2=" + p2 + ", p3=" + p3
				+ ", p4=" + p4 + ", p5=" + p5 + ", p6=" + p6 + ", p7=" + p7 + ", p8=" + p8 + ", p9=" + p9
				+ ", p10=" + p10 + ", p11=" + p11 + "]";
	}

}
