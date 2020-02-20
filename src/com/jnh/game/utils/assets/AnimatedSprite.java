package com.jnh.game.utils.assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * NOT FINISHED YET
 * @author Henning
 *
 */
public class AnimatedSprite extends Sprite {

	private BufferedImage[] images;
	
	public AnimatedSprite(BufferedImage image) {
		super(image);
	}
	
	public void render(Graphics g, float x, float y, float width, float height) {
		
		super.render(g, x, y, width, height);
	}
	
	/**
	 * Setzt das Bild temporär zu Image bis zu nächstem Update.
	 * @param image das Bild
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	/**
	 * 
	 * @param index
	 * @throws ImageNotAvailableException wenn es kein Bild an der angegeben Position gibt
	 */
	public void setImage(int index) throws ImageNotAvailableException {
		try {
			image = images[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ImageNotAvailableException("there is no image at index "+index);
		}
	}
	
	public void setRandomImage() {
		image = images[(int) (images.length * Math.random())];
	}

}
