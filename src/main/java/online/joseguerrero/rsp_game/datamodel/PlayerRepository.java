package online.joseguerrero.rsp_game.datamodel;

import java.util.HashMap;
import java.util.Map;

public class PlayerRepository {
	private static Map<String, Player> playerDB = new HashMap<String,Player> ();

	public static Map<String, Player> getPlayerDB() {
		return playerDB;
	}

}
