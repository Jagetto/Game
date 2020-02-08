package com.jnh.game.utils.assets;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

import com.jnh.game.utils.FileLoader;

/**
 * Diese Klasse ist f�r das Laden aller Texturen verantwortlich.
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
	 * L�dt alle Texturen.
	 * @throws FileNotFoundException
	 */
	public static void init() throws FileNotFoundException {
		TEST = FileLoader.loadImage("test.png");
	}
}
