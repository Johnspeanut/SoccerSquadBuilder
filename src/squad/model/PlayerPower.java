package squad.model;

public class PlayerPower {
	protected int power_id;
	protected Player player;
	protected int shot_power;
	protected int jumping;
	protected int stamina;
	protected int strength;
	protected int long_shots;
	public PlayerPower(int power_id, Player player, int shot_power, int jumping, int stamina, int strength,
			int long_shots) {
		this.power_id = power_id;
		this.player = player;
		this.shot_power = shot_power;
		this.jumping = jumping;
		this.stamina = stamina;
		this.strength = strength;
		this.long_shots = long_shots;
	}
	public int getPower_id() {
		return power_id;
	}
	public void setPower_id(int power_id) {
		this.power_id = power_id;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getShot_power() {
		return shot_power;
	}
	public void setShot_power(int shot_power) {
		this.shot_power = shot_power;
	}
	public int getJumping() {
		return jumping;
	}
	public void setJumping(int jumping) {
		this.jumping = jumping;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getLong_shots() {
		return long_shots;
	}
	public void setLong_shots(int long_shots) {
		this.long_shots = long_shots;
	}
	
	
	
	
}
