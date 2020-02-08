package com.jnh.game.utils.assets;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

import com.jnh.game.utils.FileLoader;

/**
 * Diese Klasse ist für das Laden aller Texturen verantwortlich.
 * 
 * @author Henning
 *
 */
public class Assets {
	
	/**
	 * TEST-IMAGE
	 */
	public static BufferedImage TEST;
	
	/**
	 * Lädt alle Texturen.
	 * @throws FileNotFoundException
	 */
	public static void init() throws FileNotFoundException {
		TEST = FileLoader.loadImage("test.png");
	}
}
