package squad.model;

import java.util.Date;

public class TeamUrls {
	protected Team team;
	protected String url;
	protected Date crawled;
	public TeamUrls(Team team, String url, Date crawled) {
		super();
		this.team = team;
		this.url = url;
		this.crawled = crawled;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCrawled() {
		return crawled;
	}
	public void setCrawled(Date crawled) {
		this.crawled = crawled;
	}
	
	

}
