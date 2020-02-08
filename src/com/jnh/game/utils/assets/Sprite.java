package com.jnh.game.utils.assets;

import java.awt.image.BufferedImage;

import com.sun.prism.Graphics;
import com.sun.prism.paint.Color;

public class Sprite {
	
	private BufferedImage image;
	
	private float rotation;
	private Color tint;
	
	public Sprite(BufferedImage image) {
		this.image = image;
		this.tint = new Color(0, 0, 0, 0);
		this.rotation = 0f;
	}
	
	public void render(Graphics g) {
		
	}
}
