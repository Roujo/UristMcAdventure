package roujo.games.urist.ui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;


public class ImageStore {
	private static ImageStore INSTANCE = new ImageStore();
	
	public static ImageStore getInstance() {
		return INSTANCE;
	}
	
	private Map<String, Image> images;
	
	private ImageStore() {
		images = new HashMap<String, Image>();
	}
	
	public Image getSpriteSheet(String sheetName) {
		if(images.containsKey(sheetName)) {
			return images.get(sheetName);
		} else {
			try {
				Image sheet = ImageIO.read(new File("res/" + sheetName + ".png"));
				images.put(sheetName, sheet);
				return sheet;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
