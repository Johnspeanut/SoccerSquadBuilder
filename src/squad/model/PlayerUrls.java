package squad.model;

import java.util.Date;

public class PlayerUrls {
	protected Player player;
	protected String url;
	protected Date crawled;
	public PlayerUrls(Player player, String url, Date crawled) {
		super();
		this.player = player;
		this.url = url;
		this.crawled = crawled;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
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
