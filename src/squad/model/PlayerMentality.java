package squad.model;

public class PlayerMentality {
	protected int mentality_id;
	protected Player player;
	protected int aggression;
	protected int interceptions;
	protected int positioning;
	protected int vision;
	protected int penalties;
	protected int composure;
	
	public PlayerMentality(int mentality_id, Player player, int aggression, int interceptions, int positioning,
			int vision, int penalties, int composure) {
		this.mentality_id = mentality_id;
		this.player = player;
		this.aggression = aggression;
		this.interceptions = interceptions;
		this.positioning = positioning;
		this.vision = vision;
		this.penalties = penalties;
		this.composure = composure;
	}

	public int getMentality_id() {
		return mentality_id;
	}

	public void setMentality_id(int mentality_id) {
		this.mentality_id = mentality_id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getAggression() {
		return aggression;
	}

	public void setAggression(int aggression) {
		this.aggression = aggression;
	}

	public int getInterceptions() {
		return interceptions;
	}

	public void setInterceptions(int interceptions) {
		this.interceptions = interceptions;
	}

	public int getPositioning() {
		return positioning;
	}

	public void setPositioning(int positioning) {
		this.positioning = positioning;
	}

	public int getVision() {
		return vision;
	}

	public void setVision(int vision) {
		this.vision = vision;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}

	public int getComposure() {
		return composure;
	}

	public void setComposure(int composure) {
		this.composure = composure;
	}
	
	
	
	
}
