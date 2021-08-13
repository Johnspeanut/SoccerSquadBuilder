package squad.model;

public class PlayerSkill {
	protected int skill_id;
	protected Player player;
	protected int dribbling;
	protected int curve;
	protected int fk_accuracy;
	protected int long_passing;
	protected int ball_control;
	public PlayerSkill(int skill_id, Player player, int dribbling, int curve, int fk_accuracy, int long_passing,
			int ball_control) {
		this.skill_id = skill_id;
		this.player = player;
		this.dribbling = dribbling;
		this.curve = curve;
		this.fk_accuracy = fk_accuracy;
		this.long_passing = long_passing;
		this.ball_control = ball_control;
	}
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getDribbling() {
		return dribbling;
	}
	public void setDribbling(int dribbling) {
		this.dribbling = dribbling;
	}
	public int getCurve() {
		return curve;
	}
	public void setCurve(int curve) {
		this.curve = curve;
	}
	public int getFk_accuracy() {
		return fk_accuracy;
	}
	public void setFk_accuracy(int fk_accuracy) {
		this.fk_accuracy = fk_accuracy;
	}
	public int getLong_passing() {
		return long_passing;
	}
	public void setLong_passing(int long_passing) {
		this.long_passing = long_passing;
	}
	public int getBall_control() {
		return ball_control;
	}
	public void setBall_control(int ball_control) {
		this.ball_control = ball_control;
	}
	
	
	
	
}
