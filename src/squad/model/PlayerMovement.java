package squad.model;

public class PlayerMovement {
	protected int movement_id;
	protected Player player;
	protected int acceleration;
	protected int sprint_speed;
	protected int agility;
	protected int reactions;
	protected int balance;
	
	public PlayerMovement(int movement_id, Player player, int acceleration, int sprint_speed, int agility,
			int reactions, int balance) {
		this.movement_id = movement_id;
		this.player = player;
		this.acceleration = acceleration;
		this.sprint_speed = sprint_speed;
		this.agility = agility;
		this.reactions = reactions;
		this.balance = balance;
	}

	public int getMovement_id() {
		return movement_id;
	}

	public void setMovement_id(int movement_id) {
		this.movement_id = movement_id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public int getSprint_speed() {
		return sprint_speed;
	}

	public void setSprint_speed(int sprint_speed) {
		this.sprint_speed = sprint_speed;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getReactions() {
		return reactions;
	}

	public void setReactions(int reactions) {
		this.reactions = reactions;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
}
