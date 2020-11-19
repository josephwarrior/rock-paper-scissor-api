package online.joseguerrero.rsp_game.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import online.joseguerrero.rsp_game.datamodel.Player;
import online.joseguerrero.rsp_game.services.PlayService;
import online.joseguerrero.rsp_game.services.PlayerService;

@Path("/")	
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MainResource {
	
	private PlayService playService=new PlayService();
	private PlayerService pService = new PlayerService();
	
	@GET
	@Path("/shoot")
	public Response shoot(@QueryParam("player_name") String pName, @QueryParam("play") String play)  {

		Response valResponse=playService.validateInput(pName, play);
		if(valResponse.getStatus()!=200) {
			return valResponse;
		}

		String result=playService.playAndGetResult(play);
		pService.registerResult(pName, result);
		
		return Response.status(Response.Status.OK).entity(pName + " " +result).build();
	}

	@GET
	@Path("/leaderboard")
	public List<Player> getPlayers(){
		return pService.getAllPlayers();
	}
}
