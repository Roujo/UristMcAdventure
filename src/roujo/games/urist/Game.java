package roujo.games.urist;

import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import roujo.games.urist.data.GameConfig;
import roujo.games.urist.input.KeyboardInput;
import roujo.games.urist.ui.Drawer;
import roujo.games.urist.ui.GraphicsHandler;
import roujo.games.urist.ui.sprites.Character;

public class Game {
	private GraphicsHandler graphicsHandler;
	private KeyboardInput keyboardInput;
	private boolean running;

	public Game() {
		this.graphicsHandler = GraphicsHandler.getInstance();
		this.keyboardInput = new KeyboardInput();
	}
	
	public void start() {
		GameConfig.getInstance().load();
		graphicsHandler.init();
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(keyboardInput);
		
		running = true;
		while(running){
			getInput();
			processGameLogic();
			drawScreen();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
		}
		
		graphicsHandler.cleanup();
	}
	
	private void getInput() {
		// Tout périphérique devant être "pollé" à chaque cycle
		// devrait être pollé ici
		keyboardInput.poll();
	}
	
	private void processGameLogic() {
		if(keyboardInput.keyDown(KeyEvent.VK_ESCAPE)) {
			running = false;
			return;
		}
	}
	
	private void drawScreen() {
		Drawer drawer = graphicsHandler.getDrawer();
		drawer.init();
		int i = 0;
		for(Character c : Character.values())
			drawer.draw(c, ++i * 150, i * 150);
		drawer.commit();
		graphicsHandler.getGameWindow().draw();
	}
}
