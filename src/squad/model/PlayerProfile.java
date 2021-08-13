package squad.model;

public class PlayerProfile {
	protected int profile_id;
	protected Player player;
	protected String preferred_foot;
	protected int weak_foot;
	protected int skill_moves;
	protected int international_reputations;
	protected String work_rate;
	protected String body_type;
	public PlayerProfile(int profile_id, Player player, String preferred_foot, int weak_foot, int skill_moves,
			int international_reputations, String work_rate, String body_type) {
		this.profile_id = profile_id;
		this.player = player;
		this.preferred_foot = preferred_foot;
		this.weak_foot = weak_foot;
		this.skill_moves = skill_moves;
		this.international_reputations = international_reputations;
		this.work_rate = work_rate;
		this.body_type = body_type;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getPreferred_foot() {
		return preferred_foot;
	}
	public void setPreferred_foot(String preferred_foot) {
		this.preferred_foot = preferred_foot;
	}
	public int getWeak_foot() {
		return weak_foot;
	}
	public void setWeak_foot(int weak_foot) {
		this.weak_foot = weak_foot;
	}
	public int getSkill_moves() {
		return skill_moves;
	}
	public void setSkill_moves(int skill_moves) {
		this.skill_moves = skill_moves;
	}
	public int getInternational_reputations() {
		return international_reputations;
	}
	public void setInternational_reputations(int international_reputations) {
		this.international_reputations = international_reputations;
	}
	public String getWork_rate() {
		return work_rate;
	}
	public void setWork_rate(String work_rate) {
		this.work_rate = work_rate;
	}
	public String getBody_type() {
		return body_type;
	}
	public void setBody_type(String body_type) {
		this.body_type = body_type;
	}
	
	
	
	
	
}
