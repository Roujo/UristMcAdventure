package roujo.games.urist.data;

import java.util.ArrayList;
import java.util.List;

import roujo.games.urist.entities.Entity;
import roujo.games.urist.entities.Player;
import roujo.games.urist.entities.util.EntityContainer;

public class GameState {
	private static GameState INSTANCE = new GameState();
	
	public static GameState getInstance() {
		return INSTANCE;
	}
	
	private List<EntityContainer<? extends Entity>> entityContainerList;
	private EntityContainer<Player> players;
	
	private GameState() {
		entityContainerList = new ArrayList<EntityContainer<? extends Entity>>();
		
		players = new EntityContainer<Player>();
		entityContainerList.add(players);
	}
	
	public List<EntityContainer<? extends Entity>> getEntityContainerList() {
		return entityContainerList;
	}
	
	public EntityContainer<Player> getPlayerContainer() {
		return players;
	}
}
