package roujo.games.urist.input;

import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.TreeMap;

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
		Map<Input, Integer> keyMap = new TreeMap<Input, Integer>();
		keyMap.put(Input.Up, up);
		keyMap.put(Input.Down, down);
		keyMap.put(Input.Left, left);
		keyMap.put(Input.Right, right);
		keyMap.put(Input.Action, action);
		keyMap.put(Input.Quit, quit);
		keyConfig = new KeyConfig(keyMap);
	}
	
	public KeyConfig getKeyConfig(){
		return keyConfig;
	}
}