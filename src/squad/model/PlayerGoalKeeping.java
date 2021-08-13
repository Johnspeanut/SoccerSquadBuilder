package squad.model;

public class PlayerGoalKeeping {
	protected int goalkeeping_id;
	protected Player player;
	protected int diving;
	protected int handling;
	protected int kicking;
	protected int positioning;
	protected int reflexes;
	
	public PlayerGoalKeeping(int goalkeeping_id, Player player, int diving, int handling, int kicking, int positioning,
			int reflexes) {
		this.goalkeeping_id = goalkeeping_id;
		this.player = player;
		this.diving = diving;
		this.handling = handling;
		this.kicking = kicking;
		this.positioning = positioning;
		this.reflexes = reflexes;
	}

	public int getGoalkeeping_id() {
		return goalkeeping_id;
	}

	public void setGoalkeeping_id(int goalkeeping_id) {
		this.goalkeeping_id = goalkeeping_id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getDiving() {
		return diving;
	}

	public void setDiving(int diving) {
		this.diving = diving;
	}

	public int getHandling() {
		return handling;
	}

	public void setHandling(int handling) {
		this.handling = handling;
	}

	public int getKicking() {
		return kicking;
	}

	public void setKicking(int kicking) {
		this.kicking = kicking;
	}

	public int getPositioning() {
		return positioning;
	}

	public void setPositioning(int positioning) {
		this.positioning = positioning;
	}

	public int getReflexes() {
		return reflexes;
	}

	public void setReflexes(int reflexes) {
		this.reflexes = reflexes;
	}
	
	
	
	
}
