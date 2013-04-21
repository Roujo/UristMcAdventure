package roujo.games.urist;

import roujo.games.urist.data.GameConfig;
import roujo.games.urist.ui.Character;
import roujo.games.urist.ui.Drawer;
import roujo.games.urist.ui.GraphicsHandler;
import roujo.lib.gui.windows.GraphicWindow;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello, world!");
		
		GameConfig.getInstance().load();
		
		GraphicsHandler gh = GraphicsHandler.getInstance();
		gh.init();
		GraphicWindow window = gh.getGameWindow();
		
		Drawer d = gh.getDrawer();
		d.init();
		int i = 0;
		for(Character c : Character.values())
			d.draw(c, ++i * 150, i * 150);
		d.commit();
		
		while(true){
			window.draw();
		}
	}

}
