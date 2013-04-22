package roujo.games.urist;

import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import roujo.games.urist.data.GameConfig;
import roujo.games.urist.data.GameState;
import roujo.games.urist.entities.Entity;
import roujo.games.urist.entities.Player;
import roujo.games.urist.entities.util.EntityContainer;
import roujo.games.urist.input.KeyboardInput;
import roujo.games.urist.ui.Drawer;
import roujo.games.urist.ui.GraphicsHandler;
import roujo.games.urist.ui.sprites.Character;

public class Game {
	private GraphicsHandler graphicsHandler;
	private KeyboardInput keyboardInput;
	private boolean running;
	private GameState gameState;
	private Player p1, p2;

	public Game() {
		this.graphicsHandler = GraphicsHandler.getInstance();
		this.keyboardInput = new KeyboardInput();
	}
	
	public void start() {
		GameConfig.getInstance().load();
		graphicsHandler.init();
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(keyboardInput);
		
		p1 = new Player(Character.P1, 100, 100);
		p1.setVisible(true);
		p2 = new Player(Character.P2, 700, 700);
		p2.setVisible(true);
		
		gameState = GameState.getInstance();
		EntityContainer<Player> players = gameState.getPlayerContainer();
		players.add(p1);
		players.add(p2);
		
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
		
		if(keyboardInput.keyDown(KeyEvent.VK_LEFT)) {
			p1.setX(p1.getX() - 10);
		}
		
		if(keyboardInput.keyDown(KeyEvent.VK_A)) {
			p2.setX(p2.getX() - 10);
		}
	}
	
	private void drawScreen() {
		Drawer drawer = graphicsHandler.getDrawer();
		drawer.init();
		
		// Here we go: Master Draw Loop
		for(EntityContainer<? extends Entity> entityContainer : gameState.getEntityContainerList())
			for(Entity entity : entityContainer.getAll())
				if(entity.isVisible())
					drawer.draw(entity);
		
		drawer.commit();
		graphicsHandler.getGameWindow().draw();
	}
}
