package com.jnh.game.utils.assets;

import java.awt.image.BufferedImage;

/**
 * Diese Klasse hilft ein Image als Spritesheet in mehrere Teile zu zerteilen.
 * 
 * @author Henning
 *
 */
public class SpriteSheet {
	
	private BufferedImage image;
	private int tileSize;
	
	/**
	 * Erstellt ein neues Spritesheet.
	 * @param image das Bild aus denen die einzelenen Bilder ausgeschnitten werden sollen.
	 * @param tileSize die Größe der einzelnen Teilbilder.
	 */
	public SpriteSheet(BufferedImage image, int tileSize) {
		this.image = image;
		this.tileSize = tileSize;
	}
	
	/**
	 * Mit dieser Methode können einzelne Teilbilder ausgeschnitten werden.
	 * @param x die x-Position
	 * @param y die y-Position
	 * @return das ausgeschnittene Bild
	 */
	public BufferedImage getAtPosition(int x, int y) {
		return image.getSubimage(x * tileSize, y * tileSize, tileSize, tileSize);
	}
}
