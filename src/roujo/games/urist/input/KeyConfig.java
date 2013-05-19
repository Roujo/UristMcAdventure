package roujo.games.urist.input;

import java.io.Serializable;
import java.util.Map;

public class KeyConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Map<Input, Integer> keyMap;

	public KeyConfig(Map<Input, Integer> keyMap) {
		this.keyMap = keyMap;
	}

	public boolean hasKey(Input key) {
		return keyMap.containsKey(key);
	}

	public Integer getKey(Input key) {
		return keyMap.get(key);
	}

	public void setKey(Input key, Integer chosenKey) {
		keyMap.put(key, chosenKey);
	}
}
