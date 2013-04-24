package roujo.games.urist.ui;

import java.awt.Graphics2D;

import roujo.games.urist.entities.Entity;
import roujo.games.urist.ui.sprites.Sprite;
import roujo.lib.gui.windows.GraphicWindow;

public class DrawerG2D implements Drawer {
	private GraphicWindow gameWindow;
	private Graphics2D g2d;
	private ImageStore imageStore;

	public DrawerG2D() {
		imageStore = ImageStore.getInstance();
	}

	@Override
	public void init() {
		this.gameWindow = GraphicsHandler.getInstance().getGameWindow();
		this.g2d = this.gameWindow.getG2D();
	}
	
	@Override
	public void draw(Sprite sprite, int x, int y) {
		int size = sprite.getSize();
		int row = sprite.getRowIndex();
		int column = sprite.getColumnIndex();
		g2d.drawImage(imageStore.getSpriteSheet(sprite.getSheetName()), x * size, y * size, (x + 1) * size - 1, (y + 1) * size - 1, column * size, row * size, (column + 1) * size, (row + 1) * size, gameWindow);
	}
	
	@Override
	public void draw(Entity entity) {
		draw(entity.getSprite(), entity.getX(), entity.getY());
	}

	@Override
	public void commit() {
		this.gameWindow.draw();
		this.g2d = null;
	}

}
