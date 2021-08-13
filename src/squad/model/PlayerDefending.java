package squad.model;

public class PlayerDefending {
	protected int defending_id;
	protected Player player;
	protected int defensive_awareness;
	protected int standing_tackle;
	protected int sliding_tackle;
	
	public PlayerDefending(int defending_id, Player player, int defensive_awareness, int standing_tackle,
			int sliding_tackle) {
		this.defending_id = defending_id;
		this.player = player;
		this.defensive_awareness = defensive_awareness;
		this.standing_tackle = standing_tackle;
		this.sliding_tackle = sliding_tackle;
	}

	public int getDefending_id() {
		return defending_id;
	}

	public void setDefending_id(int defending_id) {
		this.defending_id = defending_id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getDefensive_awareness() {
		return defensive_awareness;
	}

	public void setDefensive_awareness(int defensive_awareness) {
		this.defensive_awareness = defensive_awareness;
	}

	public int getStanding_tackle() {
		return standing_tackle;
	}

	public void setStanding_tackle(int standing_tackle) {
		this.standing_tackle = standing_tackle;
	}

	public int getSliding_tackle() {
		return sliding_tackle;
	}

	public void setSliding_tackle(int sliding_tackle) {
		this.sliding_tackle = sliding_tackle;
	}
	
	
	
	
}
