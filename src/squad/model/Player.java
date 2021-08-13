package squad.model;

import java.util.Date;

public class Player {
	protected int player_id;
	protected String player_name;
	protected String positions;
	protected Date date_of_birth;
	protected int height;
	protected int weight;
	protected int overall_rating;
	protected int potential_rating;
	protected String best_position;
	protected int best_overall_rating;
	protected int value;
	protected int wage;
	protected String player_image_url;
	protected Team team;
	protected String nationality;
	protected String profile;
	protected String team_name;
	protected String team_url;
	protected int attack_score;
	protected int defence_score;
	protected int goalkeep_score;
	
	public Player(int player_id, String player_name, String positions, Date date_of_birth, int height, int weight,
			int overall_rating, int potential_rating, String best_position, int best_overall_rating, int value,
			int wage, String player_image_url, Team team, String nationality, int attack_score,
			int defence_score, int goalkeep_score) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
		this.positions = positions;
		this.date_of_birth = date_of_birth;
		this.height = height;
		this.weight = weight;
		this.overall_rating = overall_rating;
		this.potential_rating = potential_rating;
		this.best_position = best_position;
		this.best_overall_rating = best_overall_rating;
		this.value = value;
		this.wage = wage;
		this.player_image_url = player_image_url;
		this.team = team;
		this.nationality = nationality;
		this.attack_score = attack_score;
		this.defence_score = defence_score;
		this.goalkeep_score = goalkeep_score;
	}
	
	public Player(int player_id, String player_name, String positions, Date date_of_birth, int height, int weight,
			int overall_rating, int potential_rating, String best_position, int best_overall_rating, int value,
			int wage, String player_image_url, Team team, String nationality, String profile, String team_name, String team_url) {
		this.player_id = player_id;
		this.player_name = player_name;
		this.positions = positions;
		this.date_of_birth = date_of_birth;
		this.height = height;
		this.weight = weight;
		this.overall_rating = overall_rating;
		this.potential_rating = potential_rating;
		this.best_position = best_position;
		this.best_overall_rating = best_overall_rating;
		this.value = value;
		this.wage = wage;
		this.player_image_url = player_image_url;
		this.team = team;
		this.nationality = nationality;
		this.profile = profile;
		this.team_name = team_name;
		this.team_url = team_url;
	}

	public Player(int player_id, String player_name, String positions, Date date_of_birth, int height, int weight,
			int overall_rating, int potential_rating, String best_position, int best_overall_rating, int value,
			int wage, String player_image_url, Team team, String nationality, String profile) {
		this.player_id = player_id;
		this.player_name = player_name;
		this.positions = positions;
		this.date_of_birth = date_of_birth;
		this.height = height;
		this.weight = weight;
		this.overall_rating = overall_rating;
		this.potential_rating = potential_rating;
		this.best_position = best_position;
		this.best_overall_rating = best_overall_rating;
		this.value = value;
		this.wage = wage;
		this.player_image_url = player_image_url;
		this.team = team;
		this.nationality = nationality;
		this.profile = profile;
	}

	public Player(int player_id, String player_name, String positions, Date date_of_birth, int height, int weight,
			int overall_rating, int potential_rating, String best_position, int best_overall_rating, int value,
			int wage, String player_image_url, Team team, String nationality) {
		this.player_id = player_id;
		this.player_name = player_name;
		this.positions = positions;
		this.date_of_birth = date_of_birth;
		this.height = height;
		this.weight = weight;
		this.overall_rating = overall_rating;
		this.potential_rating = potential_rating;
		this.best_position = best_position;
		this.best_overall_rating = best_overall_rating;
		this.value = value;
		this.wage = wage;
		this.player_image_url = player_image_url;
		this.team = team;
		this.nationality = nationality;
	}
	
	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getOverall_rating() {
		return overall_rating;
	}

	public void setOverall_rating(int overall_rating) {
		this.overall_rating = overall_rating;
	}

	public int getPotential_rating() {
		return potential_rating;
	}

	public void setPotential_rating(int potential_rating) {
		this.potential_rating = potential_rating;
	}

	public String getBest_position() {
		return best_position;
	}

	public void setBest_position(String best_position) {
		this.best_position = best_position;
	}

	public int getBest_overall_rating() {
		return best_overall_rating;
	}

	public void setBest_overall_rating(int best_overall_rating) {
		this.best_overall_rating = best_overall_rating;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public String getPlayer_image_url() {
		return player_image_url;
	}

	public void setPlayer_image_url(String player_image_url) {
		this.player_image_url = player_image_url;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getProfile() {
		return profile;
	}
	
	public String getTeamName() {
		return team_name;
	}
	
	public String getTeamUrl() {
		return team_url;
	}
	
		public int getAttack_score() {
		return attack_score;
	}

	public void setAttack_score(int attack_score) {
		this.attack_score = attack_score;
	}

	public int getDefence_score() {
		return defence_score;
	}

	public void setDefence_score(int defence_score) {
		this.defence_score = defence_score;
	}

	public int getGoalkeep_score() {
		return goalkeep_score;
	}

	public void setGoalkeep_score(int goalkeep_score) {
		this.goalkeep_score = goalkeep_score;
	}

	

	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", player_name=" + player_name + ", positions=" + positions
				+ ", date_of_birth=" + date_of_birth + ", height=" + height + ", weight=" + weight + ", overall_rating="
				+ overall_rating + ", potential_rating=" + potential_rating + ", best_position=" + best_position
				+ ", best_overall_rating=" + best_overall_rating + ", value=" + value + ", wage=" + wage
				+ ", player_image_url=" + player_image_url + ", team=" + team + ", nationality=" + nationality + "attack: " + attack_score + "defend: " + defence_score + "goalkeep: " + goalkeep_score + "]";
	}

}
