package roujo.games.urist.data;

import roujo.games.urist.entities.Player;
import roujo.games.urist.entities.util.EntityContainer;

public class GameState {
	private static GameState INSTANCE = new GameState();
	
	public static GameState getInstance() {
		return INSTANCE;
	}
	
	private EntityContainer<Player> players;
	
	private GameState() {
		players = new EntityContainer<Player>();
	}
	
	public EntityContainer<Player> getPlayerContainer() {
		return players;
	}
}
