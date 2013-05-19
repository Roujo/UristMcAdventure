package roujo.games.urist.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import roujo.games.urist.entities.Entity;
import roujo.games.urist.entities.PlayerEntity;
import roujo.games.urist.entities.util.EntityContainer;

public class GameState {
	private static GameState INSTANCE = new GameState();
	
	public static GameState getInstance() {
		return INSTANCE;
	}
	
	private List<EntityContainer<? extends Entity>> entityContainerList;
	private EntityContainer<PlayerEntity> playerEntities;
	private boolean[][] terrain;
	
	private Map<String, Player> playerMap;
	
	private GameState() {
		entityContainerList = new ArrayList<EntityContainer<? extends Entity>>();
		playerEntities = new EntityContainer<PlayerEntity>();
		entityContainerList.add(playerEntities);
		
		playerMap = new TreeMap<String, Player>();
		
		terrain = new boolean[50][50];
		for(boolean[] row : terrain)
			Arrays.fill(row, true);
	}
	
	public List<EntityContainer<? extends Entity>> getEntityContainerList() {
		return entityContainerList;
	}

	public void addPlayer(Player player) {
		playerMap.put(player.getName(), player);
		playerEntities.add(player.getEntity());
	}
	
	public Collection<Player> getPlayers() {
		return playerMap.values();
	}
	
	public boolean[][] getTerrain() {
		return terrain;
	}
}
