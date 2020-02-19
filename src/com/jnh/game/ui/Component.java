package com.jnh.game.ui;

import java.awt.Graphics;

public class Component {
	
	private boolean visible;
	private boolean active;
	
	public Component() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
	public void tick(double deltaTime) {
		
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
