package roujo.games.urist;

import java.awt.KeyboardFocusManager;

import roujo.games.urist.data.GameConfig;
import roujo.games.urist.data.GameState;
import roujo.games.urist.data.Player;
import roujo.games.urist.entities.Entity;
import roujo.games.urist.entities.PlayerEntity;
import roujo.games.urist.entities.util.EntityContainer;
import roujo.games.urist.input.Input;
import roujo.games.urist.input.KeyConfig;
import roujo.games.urist.input.KeyDefaults;
import roujo.games.urist.input.KeyboardInput;
import roujo.games.urist.ui.Drawer;
import roujo.games.urist.ui.GraphicsHandler;
import roujo.games.urist.ui.sprites.Character;

public class Game {
	private GraphicsHandler graphicsHandler;
	private KeyboardInput keyboardInput;
	private boolean running;
	private GameState gameState;

	public Game() {
		this.graphicsHandler = GraphicsHandler.getInstance();
		this.keyboardInput = new KeyboardInput();
	}
	
	public void start() {
		GameConfig.getInstance().load();
		graphicsHandler.init();
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(keyboardInput);
		
		gameState = GameState.getInstance();
		PlayerEntity p1Entity = new PlayerEntity(Character.P1, 10, 10);
		p1Entity.setVisible(true);
		Player p1 = new Player("Player 1", KeyDefaults.Arrows.getKeyConfig(), p1Entity);
		gameState.addPlayer(p1);
		
		gameState = GameState.getInstance();
		PlayerEntity p2Entity = new PlayerEntity(Character.P2, 40, 40);
		p2Entity.setVisible(true);
		Player p2 = new Player("Player 2", KeyDefaults.WASD.getKeyConfig(), p2Entity);
		gameState.addPlayer(p2);
		
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
		// Process Players
		for(Player player : gameState.getPlayers()) {
			KeyConfig config = player.getKeyConfig();
			PlayerEntity entity = player.getEntity();
			
			if(checkIfKeyPressed(config, Input.Up)) {
				entity.setY(entity.getY() - 1);
			}
			
			if(checkIfKeyPressed(config, Input.Down)) {
				entity.setY(entity.getY() + 1);
			}
			
			if(checkIfKeyPressed(config, Input.Left)) {
				entity.setX(entity.getX() - 1);
			}
			
			if(checkIfKeyPressed(config, Input.Right)) {
				entity.setX(entity.getX() + 1);
			}
			
			if(checkIfKeyPressed(config, Input.Quit)) {
				running = false;
				return;
			}
		}
	}
	
	private boolean checkIfKeyPressed(KeyConfig config, Input input) {
		return config.hasKey(input) && keyboardInput.keyDown(config.getKey(input));
	}
	
	private void drawScreen() {
		Drawer drawer = graphicsHandler.getDrawer();
		drawer.init();
		
		// Get the terrain first
		boolean[][] origTerrain = gameState.getTerrain();
		boolean[][] terrain = new boolean[origTerrain[0].length][];
		for(int y = 0; y < origTerrain.length; ++y)
			terrain[y] = origTerrain[y].clone();
			
		
		// Here we go: Master Draw Loop
		// For each entity container
		for(EntityContainer<? extends Entity> entityContainer : gameState.getEntityContainerList()) {
			// Take each entity in it
			for(Entity entity : entityContainer.getAll()) {
				// And if it's visible...
				if(entity.isVisible()) {
					// Draw it
					drawer.draw(entity);
					// And flag the terrain so that it won't get drawn over it
					terrain[entity.getY()][entity.getX()] = false;
				}
			}
		}
		
		// Now, it's terrain drawing time
		for(int y = 0; y < terrain.length; ++y) {
			for(int x = 0; x < terrain[y].length; ++x) {
				if(terrain[y][x]) {
					drawer.draw(Character.P3, x, y);
				}
			}
		}
		
		drawer.commit();
		graphicsHandler.getGameWindow().draw();
	}
}
