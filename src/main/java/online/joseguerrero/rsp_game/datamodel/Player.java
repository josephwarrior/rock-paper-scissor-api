package online.joseguerrero.rsp_game.datamodel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player implements Comparable<Player> {
	private String name;
	private int wonRounds;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWonRounds() {
		return wonRounds;
	}
	public void setWonRounds(int wonRounds) {
		this.wonRounds = wonRounds;
	}
	
	@Override
	public int compareTo(Player otherPlayer) {
		return otherPlayer.getWonRounds()-this.getWonRounds();
	}
	
	
}
