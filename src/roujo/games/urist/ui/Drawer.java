package roujo.games.urist.ui;


public interface Drawer {
	void init();

	void draw(Sprite sprite, int x, int y);

	void commit();
}
