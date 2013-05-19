package roujo.games.urist.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import roujo.games.urist.entities.Entity;
import roujo.games.urist.entities.PlayerEntity;
import roujo.games.urist.entities.util.EntityContainer;
import roujo.games.urist.ui.sprites.Sprite;
import roujo.games.urist.ui.sprites.Terrain;

public class GameState {
	private static GameState INSTANCE = new GameState();
	
	public static GameState getInstance() {
		return INSTANCE;
	}
	
	private List<EntityContainer<? extends Entity>> entityContainerList;
	private EntityContainer<PlayerEntity> playerEntities;
	
	private Sprite[][] terrain;
	
	private Map<String, Player> playerMap;
	
	private GameState() {
		entityContainerList = new ArrayList<EntityContainer<? extends Entity>>();
		playerEntities = new EntityContainer<PlayerEntity>();
		entityContainerList.add(playerEntities);
		
		playerMap = new TreeMap<String, Player>();		
		
		Terrain[] terrainSprites = Terrain.values();
		Random random = new Random();
		terrain = new Sprite[50][50];
		for(int y = 0; y < terrain.length; ++y)
			for(int x = 0; x < terrain[0].length; ++x)
				terrain[y][x] = terrainSprites[random.nextInt(terrainSprites.length)];
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
	
	public Sprite[][] getTerrain() {
		return terrain;
	}
}
