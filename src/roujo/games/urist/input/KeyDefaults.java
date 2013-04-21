package roujo.games.urist.input;

import java.awt.event.KeyEvent;

public enum KeyDefaults{
	Arrows(
		KeyEvent.VK_UP,		// up
		KeyEvent.VK_DOWN,	// down
		KeyEvent.VK_LEFT,	// left
		KeyEvent.VK_RIGHT,	// right
		KeyEvent.VK_Z,		// action 
		KeyEvent.VK_ESCAPE	// quit
	),
	
	WASD(
		KeyEvent.VK_W,
		KeyEvent.VK_S,
		KeyEvent.VK_A,
		KeyEvent.VK_D,
		KeyEvent.VK_M,
		KeyEvent.VK_ESCAPE);
	
	private final KeyConfig keyConfig;
	
	private KeyDefaults(int up, int down, int left, int right, int action, int quit){
		keyConfig = new KeyConfig(new int[]{up, down, left, right, action, quit});
	}
	
	public KeyConfig getKeyConfig(){
		return keyConfig;
	}
}