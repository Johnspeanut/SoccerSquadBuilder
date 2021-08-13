package squad.model;

public class Team {
	protected int team_id;
	protected String team_name;
	protected String league;
	protected int overall;
	protected int attack;
	protected int mid_field;
	protected int defence;
	protected int international_prestige;
	protected int domestic_prestige;
	protected int transfer_budget;
	protected String team_url;
	
	public Team(int team_id, String team_name, String league, int overall, int attack, int mid_field, int defence,
			int international_prestige, int domestic_prestige, int transfer_budget, String team_url) {
		this.team_id = team_id;
		this.team_name = team_name;
		this.league = league;
		this.overall = overall;
		this.attack = attack;
		this.mid_field = mid_field;
		this.defence = defence;
		this.international_prestige = international_prestige;
		this.domestic_prestige = domestic_prestige;
		this.transfer_budget = transfer_budget;
		this.team_url = team_url;
	}
	
	public Team(int team_id, String team_name, String league, int overall, int attack, int mid_field, int defence,
			int international_prestige, int domestic_prestige, int transfer_budget) {
		this.team_id = team_id;
		this.team_name = team_name;
		this.league = league;
		this.overall = overall;
		this.attack = attack;
		this.mid_field = mid_field;
		this.defence = defence;
		this.international_prestige = international_prestige;
		this.domestic_prestige = domestic_prestige;
		this.transfer_budget = transfer_budget;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public int getOverall() {
		return overall;
	}

	public void setOverall(int overall) {
		this.overall = overall;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getMid_field() {
		return mid_field;
	}

	public void setMid_field(int mid_field) {
		this.mid_field = mid_field;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getInternational_prestige() {
		return international_prestige;
	}

	public void setInternational_prestige(int international_prestige) {
		this.international_prestige = international_prestige;
	}

	public int getDomestic_prestige() {
		return domestic_prestige;
	}

	public void setDomestic_prestige(int domestic_prestige) {
		this.domestic_prestige = domestic_prestige;
	}

	public int getTransfer_budget() {
		return transfer_budget;
	}

	public void setTransfer_budget(int transfer_budget) {
		this.transfer_budget = transfer_budget;
	}
	
	public String getTeam_url() {
		return team_url;
	}
	
	
	
	

}
