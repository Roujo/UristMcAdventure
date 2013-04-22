package roujo.games.urist.entities.util;

import java.util.ArrayList;
import java.util.List;

import roujo.games.urist.entities.Entity;


public class EntityContainer<T extends Entity> {
	private List<T> entities;
	
	public EntityContainer() {
		entities = new ArrayList<T>();
	}
	
	public boolean add(T entity) {
		return entities.add(entity);
	}
	
	public boolean remove(T entity) {
		return entities.remove(entity);
	}
	
	public List<T> getAll() {
		return entities;
	}
}
