package com.jnh.game.utils.assets;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * Diese Klasse umfasst ein Bild, sowie Operationen um dessen Aussehehen beim Rendern zu Modifizieren, wie die Drehung.
 * @author Henning
 */
public class Sprite {
	
	protected BufferedImage image;
	
	protected float rotation;
	protected float transparency;
	protected boolean flip;
	
	/**
	 * Erstellt ein Sprite mit den Standard-Werten.
	 * @param image das Ausgangsbild
	 * @see Sprite#Sprite(BufferedImage, float, float, boolean, boolean)
	 */
	public Sprite(BufferedImage image) {
		this.image = image;
		this.transparency = 1f;
		this.rotation = 0f;
		this.flip = false;
	}
	
	/**
	 * Erstellt ein Sprite.
	 * @param image das Ausgangsbild
	 * @param transparency die Transparenz
	 * @param rotation die Drehung
	 * @param flip die horizontale Spiegelung
	 */
	public Sprite(BufferedImage image, float transparency, float rotation, boolean flip) {
		this.image = image;
		this.transparency = transparency;
		this.rotation = rotation;
		this.flip = flip;
	}
	
	/**
	 * Rendert das Sprite an den entsprechenden Koordinaten und in der entsprechenden Größe.
	 * @param g das Graphics-Objekt.
	 * @param x die x-Koordinate
	 * @param y die y-Koordinate
	 * @param width die Breite
	 * @param height die Höhe
	 */
	public void render(Graphics g, float x, float y, float width, float height) {
		BufferedImage manipulatedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		//Flipping
		if(flip) {
			AffineTransform at = new AffineTransform();
			at.concatenate(AffineTransform.getScaleInstance(1, -1));
	        at.concatenate(AffineTransform.getTranslateInstance(0, -image.getHeight()));
	        AffineTransformOp flipOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
	        manipulatedImage = flipOp.filter(image, manipulatedImage);
		} else {
			manipulatedImage = image;
		}

		if(rotation != 0f) {
			 //Resizing
			AffineTransform at = new AffineTransform();
			at.scale(width / manipulatedImage.getWidth(), height / manipulatedImage.getHeight());
			AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			manipulatedImage = scaleOp.filter(manipulatedImage, null);
			
			final double rads = Math.toRadians(rotation);
			final double sin = Math.abs(Math.sin(rads));
			final double cos = Math.abs(Math.cos(rads));
			final int w = (int) Math.floor(manipulatedImage.getWidth() * cos + manipulatedImage.getHeight() * sin);
			final int h = (int) Math.floor(manipulatedImage.getHeight() * cos + manipulatedImage.getWidth() * sin);
			final BufferedImage rotatedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			final AffineTransform atr = new AffineTransform();
			atr.translate(w / 2, h / 2);
			atr.rotate(rads, 0, 0);
			atr.translate(-manipulatedImage.getWidth() / 2, -manipulatedImage.getHeight() / 2);
			final AffineTransformOp rotateOp = new AffineTransformOp(atr, AffineTransformOp.TYPE_BILINEAR);
			rotateOp.filter(manipulatedImage,rotatedImage);
			
			((Graphics2D) (g)).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) transparency));
			g.drawImage(rotatedImage, (int) x, (int) y, null);
		} else {
			((Graphics2D) (g)).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) transparency));
			g.drawImage(manipulatedImage, (int) x, (int) y , (int) width, (int) height, null);
		}
		
	}

	/**
	 * Gibt das Bild zurück. Dieses enthält nicht die Grafik-Operationen.
	 * @return das Bild
	 */
	public BufferedImage getImage() {
		return image;
	}
	
	/**
	 * Setzt das Bild, auf das die Grafikoperationen im Render-Prozess angewendet werden sollen.
	 * @param image
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	/**
	 * Gibt die momentane Drehung gegenüber dem Anfangsbildzurück.
	 * @return der Winkel
	 */
	public float getRotation() {
		return rotation;
	}

	/**
	 * Setzt die Drehung des Bildes zu dem angebenen Winkel.
	 * @param rotation der Winkel
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
	/**
	 * Gibt die Transparenz des Sprites zurück.
	 * @return die Transparenz
	 */
	public float getTransparency() {
		return transparency;
	}
	
	/**
	 * Setzt die Transparenz des Sprites. Ein Wert zwischen 0 und 1 wird erwartet.
	 * @param transparency die Transparenz
	 */
	public void setTransparency(float transparency) {
		this.transparency = transparency;
	}

	/**
	 * Gibt zurück, ob das Sprite horizontal gespiegelt ist.
	 * @return die Spiegelung
	 */
	public boolean isFlip() {
		return flip;
	}

	/**
	 * Setzt die Spiegelung an der horizontalen Achse.
	 * @param flip die Spiegelung
	 */
	public void setFlip(boolean flip) {
		this.flip = flip;
	}
	
	
	
	
	
}
