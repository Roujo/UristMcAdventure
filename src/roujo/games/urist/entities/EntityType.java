package roujo.games.urist.entities;

public enum EntityType {
	Player(Player.class);
	
	private Class<? extends Entity> entityClass;
	
	private EntityType(Class<? extends Entity> entityClass) {
		this.entityClass = entityClass;
	}
	
	public Class<? extends Entity> getEntityClass() {
		return entityClass;
	}
}
