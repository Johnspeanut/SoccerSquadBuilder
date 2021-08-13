package squad.model;

public class TeamTactics {
	protected int tactic_id;
	protected Team team;
	protected String defensive_style;
	protected int team_width;
	protected int depth;
	protected String offensive_style;
	protected int width;
	protected int players_in_box;
	protected int corners;
	protected int freekicks;
	public TeamTactics(int tactic_id, Team team, String defensive_style, int team_width, int depth,
			String offensive_style, int width, int players_in_box, int corners, int freekicks) {
		super();
		this.tactic_id = tactic_id;
		this.team = team;
		this.defensive_style = defensive_style;
		this.team_width = team_width;
		this.depth = depth;
		this.offensive_style = offensive_style;
		this.width = width;
		this.players_in_box = players_in_box;
		this.corners = corners;
		this.freekicks = freekicks;
	}
	public int getTactic_id() {
		return tactic_id;
	}
	public void setTactic_id(int tactic_id) {
		this.tactic_id = tactic_id;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public String getDefensive_style() {
		return defensive_style;
	}
	public void setDefensive_style(String defensive_style) {
		this.defensive_style = defensive_style;
	}
	public int getTeam_width() {
		return team_width;
	}
	public void setTeam_width(int team_width) {
		this.team_width = team_width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getOffensive_style() {
		return offensive_style;
	}
	public void setOffensive_style(String offensive_style) {
		this.offensive_style = offensive_style;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getPlayers_in_box() {
		return players_in_box;
	}
	public void setPlayers_in_box(int players_in_box) {
		this.players_in_box = players_in_box;
	}
	public int getCorners() {
		return corners;
	}
	public void setCorners(int corners) {
		this.corners = corners;
	}
	public int getFreekicks() {
		return freekicks;
	}
	public void setFreekicks(int freekicks) {
		this.freekicks = freekicks;
	}
	
	

}
