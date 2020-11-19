package online.joseguerrero.rsp_game.services;

import java.util.Random;

import javax.ws.rs.core.Response;

public class PlayService {
	
	public final int PLAYER_WINS=1;
	public final int PLAYER_TIES=0;
	public final int PLAYER_LOSES=-1;
	private String[] results= {"loses","ties the round","wins"};
	
	
	private final String ROCK_STR="rock";
	private final String PAPER_STR="paper";
	private final String SCISSORS_STR="scissors";
	String[] playArray= {ROCK_STR,PAPER_STR,SCISSORS_STR};
	private int rockValue=1;
	private int paperValue=2;
	private int scissorsValue=3;
	

	private boolean isValidPlay(String play) {
		play=play.toLowerCase().trim();
		if(play.equals(ROCK_STR)||play.equals(PAPER_STR)||play.equals(SCISSORS_STR)) {
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
		
		String result=getPlayerResult(playerPickedWord,gamePickedWord);
		
		return result;
		
	}
	
	public String getPlayerResult(String userPlay, String gamePlay) {
		applyLogic(userPlay);
		
		int userPlayValue=getStringValue(userPlay);
		int gamePlayValue=getStringValue(gamePlay);
		
		int resultIndex=userPlayValue-gamePlayValue+1;
		
		return results[resultIndex];
	}
	
	
	public String getGamePickedWord() {
		Random random=new Random();
		int randomIndex = random.nextInt(3);
		return playArray[randomIndex];
	}
	
	
	private void applyLogic(String userPlay) {
		switch(userPlay) {
		case ROCK_STR:
			this.scissorsValue=1;
			this.rockValue=2;
			this.paperValue=3;
			break;
		case PAPER_STR:
			this.rockValue=1;
			this.paperValue=2;
			this.scissorsValue=3;
			break;
		case SCISSORS_STR:
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

	private int getStringValue(String playString) {
		playString=playString.toLowerCase().trim();
		switch(playString) {
		case ROCK_STR:
			return rockValue;
		case PAPER_STR:
			return paperValue;
		case SCISSORS_STR:
			return scissorsValue;
		default:
			return 2;
		}
	
	}
	
}
