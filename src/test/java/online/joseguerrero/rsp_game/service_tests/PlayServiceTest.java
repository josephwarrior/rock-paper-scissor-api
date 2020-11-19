package online.joseguerrero.rsp_game.service_tests;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.Test;

import online.joseguerrero.rsp_game.services.PlayService;

public class PlayServiceTest {
	
	PlayService playService=new PlayService();

	@Test
	public void testValidateInput1() {
		String pName="",play="paper";
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), playService.validateInput(pName, play).getStatus());
		assertEquals("Input fields can not be empty", playService.validateInput(pName, play).getEntity().toString());
	}
	
	@Test
	public void testValidateInput2() {
		String pName="John",play="";
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), playService.validateInput(pName, play).getStatus());
		assertEquals("Input fields can not be empty", playService.validateInput(pName, play).getEntity().toString());
	}
	
	@Test
	public void testIsValidPlay1() {
		String pName="John",play="hammer";
		assertEquals(Response.Status.FORBIDDEN.getStatusCode(), playService.validateInput(pName, play).getStatus());
		assertEquals("Only words accepted (case insensitive): Rock, Paper or Scissors", playService.validateInput(pName, play).getEntity().toString());
	}
	
	@Test
	public void testGetPlayerResult1() {
		String userPlay="rock",gamePlay="scissors";
		assertEquals("wins",playService.getPlayerResult(userPlay, gamePlay));
	}
	
	@Test
	public void testGetPlayerResult2() {
		String userPlay="rock",gamePlay="rock";
		assertEquals("ties the round",playService.getPlayerResult(userPlay, gamePlay));
	}
	
	@Test
	public void testGetPlayerResult3() {
		String userPlay="rock",gamePlay="paper";
		assertEquals("loses",playService.getPlayerResult(userPlay, gamePlay));
	}
	
	@Test
	public void testGetPlayerResult4() {
		String userPlay="paper",gamePlay="rock";
		assertEquals("wins",playService.getPlayerResult(userPlay, gamePlay));
	}
	
	@Test
	public void testGetPlayerResult5() {
		String userPlay="paper",gamePlay="paper";
		assertEquals("ties the round",playService.getPlayerResult(userPlay, gamePlay));
	}
	
	@Test
	public void testGetPlayerResult6() {
		String userPlay="paper",gamePlay="scissors";
		assertEquals("loses",playService.getPlayerResult(userPlay, gamePlay));
	}
	
	@Test
	public void testGetPlayerResult7() {
		String userPlay="scissors",gamePlay="paper";
		assertEquals("wins",playService.getPlayerResult(userPlay, gamePlay));
	}
	
	@Test
	public void testGetPlayerResult8() {
		String userPlay="scissors",gamePlay="scissors";
		assertEquals("ties the round",playService.getPlayerResult(userPlay, gamePlay));
	}
	
	@Test
	public void testGetPlayerResult9() {
		String userPlay="scissors",gamePlay="rock";
		assertEquals("loses",playService.getPlayerResult(userPlay, gamePlay));
	}
	
	@Test
	public void testGetGamePickedWord() {
		String referenceWord=playService.getGamePickedWord();
		String compareWord;
		int differentWordsCheck=0;
		
		for(int i=0;i<20;i++) {
			compareWord=playService.getGamePickedWord();
			if(referenceWord.equals(compareWord)) {
				differentWordsCheck=1;
			}	
		}	
		assertEquals(1,differentWordsCheck);
	}
}
