package com.jnh.game.utils.assets;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import com.sun.prism.paint.Color;

public class Sprite {
	
	private BufferedImage image;
	
	private float rotation;
	private float transparency;
	private Color tint;
	
	public Sprite(BufferedImage image) {
		this.image = image;
		this.tint = new Color(0, 0, 0, 0);
		this.rotation = 0f;
	}
	
	public Sprite(BufferedImage image, Color tint, float rotation) {
		this.image = image;
		this.tint = tint;
		this.rotation = rotation;
	}
	
	public void render(Graphics g, float x, float y, float width, float height) {
		
		BufferedImage resizedImage = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_ARGB);
		AffineTransform atr = new AffineTransform();
		atr.scale(width / image.getWidth(), height / image.getHeight());
		AffineTransformOp scaleOp = new AffineTransformOp(atr, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		resizedImage = scaleOp.filter(image, resizedImage);
		
		final double rads = Math.toRadians(rotation);
		final double sin = Math.abs(Math.sin(rads));
		final double cos = Math.abs(Math.cos(rads));
		final int w = (int) Math.floor(resizedImage.getWidth() * cos + resizedImage.getHeight() * sin);
		final int h = (int) Math.floor(resizedImage.getHeight() * cos + resizedImage.getWidth() * sin);
		
		final BufferedImage rotatedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		final AffineTransform at = new AffineTransform();
		at.translate(w / 2, h / 2);
		at.rotate(rads, 0, 0);
		at.translate(-resizedImage.getWidth() / 2, -resizedImage.getHeight() / 2);
		final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		rotateOp.filter(resizedImage,rotatedImage);
		
		g.drawImage(rotatedImage, (int) x - w / 2, (int) y - h / 2, null);
	}

	
	public BufferedImage getImage() {
		return image;
	}

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

	public Color getTint() {
		return tint;
	}

	public void setTint(Color tint) {
		this.tint = tint;
	}
	
	
	
	
}
