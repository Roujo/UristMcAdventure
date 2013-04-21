package roujo.games.urist.ui;

import javax.swing.JFrame;

import roujo.games.urist.data.GameConfig;
import roujo.lib.gui.windows.GraphicWindow;

public class GraphicsHandler {
	private static GraphicsHandler instance = new GraphicsHandler();

	public static GraphicsHandler getInstance() {
		return instance;
	}

	private GraphicWindow gameWindow;
	private GameConfig gameConfig;
	private Drawer drawer;

	private GraphicsHandler() {
	}
	
	public void init() {
		gameConfig = GameConfig.getInstance();
		gameWindow = new GraphicWindow("Urist McAdventure", gameConfig.getWidth(),
				gameConfig.getHeight());
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setVisible(true);
		drawer = new DrawerG2D();
	}

	public Drawer getDrawer() {
		return drawer;
	}
	
	public GraphicWindow getGameWindow() {
		return gameWindow;
	}

	public void cleanup() {
		gameWindow.dispose();		
	}
}
