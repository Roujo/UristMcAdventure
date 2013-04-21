package roujo.games.urist.ui;

import roujo.games.urist.entities.Entity;
import roujo.games.urist.ui.sprites.Sprite;


public interface Drawer {
	void init();

	void draw(Sprite sprite, int x, int y);

	void draw(Entity entity);
	
	void commit();
}
