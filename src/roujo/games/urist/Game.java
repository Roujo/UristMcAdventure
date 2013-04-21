package roujo.games.urist;

import roujo.games.urist.data.GameConfig;
import roujo.games.urist.ui.Character;
import roujo.games.urist.ui.Drawer;
import roujo.games.urist.ui.GraphicsHandler;
import roujo.lib.gui.windows.GraphicWindow;

public class Game {
	private GraphicWindow window;
	private GraphicsHandler graphicsHandler;

	public void start() {
		GameConfig.getInstance().load();
		
		graphicsHandler = GraphicsHandler.getInstance();
		graphicsHandler.init();
		window = graphicsHandler.getGameWindow();
		
		while(true){
			getInput();
			processGameLogic();
			drawScreen();
		}
	}
	
	private void getInput() {
		
	}
	
	private void processGameLogic() {
		
	}
	
	private void drawScreen() {
		Drawer drawer = graphicsHandler.getDrawer();
		drawer.init();
		int i = 0;
		for(Character c : Character.values())
			drawer.draw(c, ++i * 150, i * 150);
		drawer.commit();
		window.draw();
	}			
	
}
