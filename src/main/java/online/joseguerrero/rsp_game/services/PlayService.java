package online.joseguerrero.rsp_game.services;

import java.util.Random;

import javax.ws.rs.core.Response;

public class PlayService {
	
	public final int PLAYER_WINS=1;
	public final int PLAYER_TIES=0;
	public final int PLAYER_LOSES=-1;
	private String[] results= {"loses","ties the round","wins"};
	
	String[] playArray= {"rock","paper","scissors"};
	private int rockValue=1;
	private int paperValue=2;
	private int scissorsValue=3;
	

	private boolean isValidPlay(String play) {
		play=play.toLowerCase().trim();
		if(play.equals("rock")||play.equals("paper")||play.equals("scissors")) {
			return true;
		}
		return false;
	}
	
	public Response validateInput(String pName, String play) { 
		if(pName.isEmpty() || play.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Input fields can not be empty").build();
		}
		if(!isValidPlay(play)) {
			return Response.status(Response.Status.FORBIDDEN).entity("Only words accepted (case insensitive): Rock, Paper or Scissors").build();
		}
		
		return Response.status(Response.Status.OK).build();
	}
	
	public String playAndGetResult(String play) {
		String playerPickedWord = play.toLowerCase().trim();
		String gamePickedWord= getGamePickedWord();
		
		applyLogic(playerPickedWord);
		
		int playerPickedWordValue= getStringValue(playerPickedWord);
		int gamePickedWordValue= getStringValue(gamePickedWord);
		
		int resultIndex= (playerPickedWordValue-gamePickedWordValue)+1;
		
		return results[resultIndex];
		
	}
	
	
	public String getGamePickedWord() {
		Random random=new Random();
		int randomIndex = random.nextInt(3);
		return playArray[randomIndex];
	}
	
	
	public void applyLogic(String play) {
		switch(play) {
		case "rock":
			this.scissorsValue=1;
			this.rockValue=2;
			this.paperValue=3;
			break;
		case "paper":
			this.rockValue=1;
			this.paperValue=2;
			this.scissorsValue=3;
			break;
		case "scissors":
			this.paperValue=1;
			this.scissorsValue=2;
			this.rockValue=3;		
		    break;
		default:
			this.rockValue=1;
			this.paperValue=2;
			this.scissorsValue=3;;
		
		}
	}

	public int getStringValue(String playString) {
		playString=playString.toLowerCase().trim();
		switch(playString) {
		case "rock":
			return rockValue;
		case "paper":
			return paperValue;
		case "scissors":
			return scissorsValue;
		default:
			return 2;
		}
	
	}
	
}
