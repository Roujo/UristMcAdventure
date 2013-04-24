package roujo.games.urist.data;

import java.util.ArrayList;
import java.util.Arrays;
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
	private boolean[][] terrain;
	
	private GameState() {
		entityContainerList = new ArrayList<EntityContainer<? extends Entity>>();
		players = new EntityContainer<Player>();
		entityContainerList.add(players);
		
		terrain = new boolean[50][50];
		for(boolean[] row : terrain)
			Arrays.fill(row, true);
	}
	
	public List<EntityContainer<? extends Entity>> getEntityContainerList() {
		return entityContainerList;
	}
	
	public EntityContainer<Player> getPlayerContainer() {
		return players;
	}
	
	public boolean[][] getTerrain() {
		return terrain;
	}
}
