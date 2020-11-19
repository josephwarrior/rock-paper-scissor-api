package online.joseguerrero.rsp_game.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import online.joseguerrero.rsp_game.datamodel.Player;
import online.joseguerrero.rsp_game.datamodel.PlayerRepository;

public class PlayerService {
	private Map<String,Player> playerDB;
	
	public PlayerService() {
		playerDB= PlayerRepository.getPlayerDB();
	}
	
	
	public void registerResult(String pName, String result) {
		pName=pName.toLowerCase().trim();
		if(result.equals("wins")) {
			checkPlayerAndIncrementScore(pName);
		}else {
		    checkPlayer(pName);
		}
	}
	
	
	private void checkPlayerAndIncrementScore(String pName) {
		checkPlayer(pName);
		incrementScore(pName);
	}
	
	private void checkPlayer(String pName) {
		if(!playerDB.keySet().contains(pName)) {	
			Player newPlayer=new Player();
			newPlayer.setName(pName);
			newPlayer.setWonRounds(0);
			playerDB.put(pName,newPlayer);
		}
	}
	
	private void incrementScore(String pName) {
		Player player=playerDB.get(pName);
		int wonRounds=player.getWonRounds();
		playerDB.get(pName).setWonRounds(wonRounds+1);
	}
	
	public List<Player> getAllPlayers(){
		List<Player> players=new ArrayList<Player>(playerDB.values());
		Collections.sort(players);
		return players;
	}
	
}
