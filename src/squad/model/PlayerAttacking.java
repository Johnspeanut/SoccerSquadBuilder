package squad.model;

public class PlayerAttacking {
	protected int attacking_id;
    protected Player player;
    protected int crossing;
    protected int finishing;
    protected int heading_accuracy;
    protected int short_passing;
    protected int volleys;
    
	public PlayerAttacking(int attacking_id, Player player, int crossing, int finishing, int heading_accuracy,
			int short_passing, int volleys) {
		this.attacking_id = attacking_id;
		this.player = player;
		this.crossing = crossing;
		this.finishing = finishing;
		this.heading_accuracy = heading_accuracy;
		this.short_passing = short_passing;
		this.volleys = volleys;
	}

	public int getAttacking_id() {
		return attacking_id;
	}

	public void setAttacking_id(int attacking_id) {
		this.attacking_id = attacking_id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getCrossing() {
		return crossing;
	}

	public void setCrossing(int crossing) {
		this.crossing = crossing;
	}

	public int getFinishing() {
		return finishing;
	}

	public void setFinishing(int finishing) {
		this.finishing = finishing;
	}

	public int getHeading_accuracy() {
		return heading_accuracy;
	}

	public void setHeading_accuracy(int heading_accuracy) {
		this.heading_accuracy = heading_accuracy;
	}

	public int getShort_passing() {
		return short_passing;
	}

	public void setShort_passing(int short_passing) {
		this.short_passing = short_passing;
	}

	public int getVolleys() {
		return volleys;
	}

	public void setVolleys(int volleys) {
		this.volleys = volleys;
	}
	
	
    
    
}
