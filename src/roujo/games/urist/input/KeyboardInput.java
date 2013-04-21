package roujo.games.urist.input;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

public class KeyboardInput implements KeyEventDispatcher {

	private static final int KEY_COUNT = 256;

	private enum KeyState {
		UP, // Up, but not for the first time
		DOWN, // Down, but not the first time
		PRESSED, // Down for the first time
		RELEASED // Up, just released
	}

	// Current state of the keyboard
	private boolean[] currentKeys = null;

	// Polled keyboard state
	private KeyState[] keys = null;

	public KeyboardInput() {
		currentKeys = new boolean[KEY_COUNT];
		keys = new KeyState[KEY_COUNT];
		for (int i = 0; i < KEY_COUNT; ++i) {
			keys[i] = KeyState.UP;
		}
	}

	public synchronized void poll() {
		for (int i = 0; i < KEY_COUNT; ++i) {
			// Set the key state
			if (currentKeys[i]) {
				// If the key is down now, but was not
				// down last frame, set it to DOWN_ONCE,
				// otherwise, set it to DOWN
				keys[i] = (keys[i] == KeyState.UP ? KeyState.PRESSED : KeyState.DOWN);
			} else {
				keys[i] = (keys[i] == KeyState.DOWN ? KeyState.RELEASED : KeyState.UP);
			}
		}
	}

	public boolean keyDown(int keyCode) {
		return keys[keyCode] == KeyState.PRESSED
				|| keys[keyCode] == KeyState.DOWN;
	}

	public boolean keyPressed(int keyCode) {
		return keys[keyCode] == KeyState.PRESSED;
	}
	
	public boolean keyUp(int keyCode) {
		return keys[keyCode] == KeyState.UP
				|| keys[keyCode] == KeyState.RELEASED;
	}
	
	public boolean keyReleased(int keyCode) {
		return keys[keyCode] == KeyState.RELEASED;
	}

	@Override
    public boolean dispatchKeyEvent(KeyEvent e) {
		currentKeys[e.getKeyCode()] = (e.getID() == KeyEvent.KEY_PRESSED);
		return true;
    }
}
