package com.jnh.game.ui;

import java.awt.Graphics;

public class UIManager {

	private Container root;
	
	public UIManager() {
		root = new Container();
	}
	
	public void render(Graphics g) {
		root.render(g);
	}
	
	public void tick(double deltaTime) {
		root.tick(deltaTime);
	}
	
	public Container getRoot() {
		return root;
	}

}
