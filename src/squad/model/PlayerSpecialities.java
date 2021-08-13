package squad.model;

public class PlayerSpecialities {
	protected int speciality_id;
	protected Player player;
	protected String speciality;
	public PlayerSpecialities(int speciality_id, Player player, String speciality) {
		super();
		this.speciality_id = speciality_id;
		this.player = player;
		this.speciality = speciality;
	}
	public int getSpeciality_id() {
		return speciality_id;
	}
	public void setSpeciality_id(int speciality_id) {
		this.speciality_id = speciality_id;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	
}
