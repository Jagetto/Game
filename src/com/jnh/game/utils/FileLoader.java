package com.jnh.game.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

/**
 * Diese Klasse kann genutzt werden um Dateien zu Laden.
 * 
 * @author Henning
 *
 */
public class FileLoader {
	
	/**
	 * Lädt das Bild mit dem angegebenen Namen. NOTE: Das Bild muss sich im Ordner <code>src/assets/img</code> befinden.
	 * @param path der Name des Bilds
	 * @return das Bild
	 * @throws FileNotFoundException wenn das Bild nicht gefunden wurde
	 */
	public static BufferedImage loadImage(String path) throws FileNotFoundException {
		File file = new File("assets/img/"+path);
		BufferedImage img;
		try {
		   img = ImageIO.read(new File(file.toURI()));
		} catch (Exception e) {
			e.printStackTrace();
		    throw new FileNotFoundException();
		}
		return img;
	}
}