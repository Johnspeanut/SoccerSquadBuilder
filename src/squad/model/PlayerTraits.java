package squad.model;

public class PlayerTraits {
	protected int trait_id;
	protected Player player;
	protected String trait;
	public PlayerTraits(int trait_id, Player player, String trait) {
		super();
		this.trait_id = trait_id;
		this.player = player;
		this.trait = trait;
	}
	public int getTrait_id() {
		return trait_id;
	}
	public void setTrait_id(int trait_id) {
		this.trait_id = trait_id;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getTrait() {
		return trait;
	}
	public void setTrait(String trait) {
		this.trait = trait;
	}
	
	
}
