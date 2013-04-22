package roujo.games.urist.data;

import java.util.HashMap;
import java.util.Map;

import roujo.games.urist.entities.Entity;
import roujo.games.urist.entities.EntityType;
import roujo.games.urist.entities.Player;
import roujo.games.urist.entities.util.EntityContainer;

public class GameState {
	private static GameState INSTANCE = new GameState();
	
	public static GameState getInstance() {
		return INSTANCE;
	}
	
	private Map<EntityType, EntityContainer<? extends Entity>> containers;
	
	private GameState() {
		containers = new HashMap<EntityType, EntityContainer<? extends Entity>>();
		containers.put(EntityType.Player, new EntityContainer<Player>());
	}
	
	public EntityContainer<? extends Entity> getContainer(EntityType type) {
		return containers.get(type);
	}
}
