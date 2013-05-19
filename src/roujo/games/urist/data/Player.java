package roujo.games.urist.data;

import roujo.games.urist.entities.PlayerEntity;
import roujo.games.urist.input.KeyConfig;

public class Player {
	private String name;
	private KeyConfig keyConfig;
	private int score;
	private PlayerEntity entity;

	public Player(String name, KeyConfig keyConfig, PlayerEntity entity) {
		this.name = name;
		this.keyConfig = keyConfig;
		this.score = 0;
		this.entity = entity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public KeyConfig getKeyConfig() {
		return keyConfig;
	}

	public void setKeyConfig(KeyConfig keyConfig) {
		this.keyConfig = keyConfig;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public PlayerEntity getEntity() {
		return entity;
	}

	public void setEntity(PlayerEntity entity) {
		this.entity = entity;
	}
}
