package online.joseguerrero.rsp_game.service_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import online.joseguerrero.rsp_game.services.PlayerService;

public class PlayerServiceTest {
	
	private final String WIN_STRING="wins";
	private final String TIE_STRING="ties the round";
	private final String LOS_STRING="losses";
	

	@Test
	public void testRegisterResult1() {
		PlayerService playerService=new PlayerService();
		String pName="John",result1=this.WIN_STRING,result2=this.WIN_STRING;
		playerService.registerResult(pName, result1);
		playerService.registerResult(pName, result2);
		
		assertEquals(2, playerService.getPlayerScore(pName));
	}
	
	@Test
	public void testRegisterResult2() {
		PlayerService playerService=new PlayerService();
		String pName="Martha",result1=this.WIN_STRING,result2=this.TIE_STRING;
		playerService.registerResult(pName, result1);
		playerService.registerResult(pName, result2);
		
		assertEquals(1, playerService.getPlayerScore(pName));
	}
	
	@Test
	public void testRegisterResult3() {
		PlayerService playerService=new PlayerService();
		String pName="Viktor",result1=this.WIN_STRING,result2=this.LOS_STRING;
		playerService.registerResult(pName, result1);
		playerService.registerResult(pName, result2);
		
		assertEquals(1, playerService.getPlayerScore(pName));
	}

}
