package com.jnh.game.state;

import java.awt.Graphics;

public abstract class State {
	
	public abstract void load();
	
	public abstract void tick(double deltaTime);
	
	public abstract void render(Graphics g);
	
	public abstract void dispose();
}
