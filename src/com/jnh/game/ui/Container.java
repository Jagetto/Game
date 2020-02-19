package com.jnh.game.ui;

import java.awt.Graphics;
import java.util.LinkedList;

public class Container extends Component {
	
	private LinkedList<Component> children;
	
	public Container() {
		children = new LinkedList<Component>();
	}

	@Override
	public void render(Graphics g) {
		for(Component component : children) {
			if(component.isVisible()) {
				component.render(g);
			}
		}
	}

	@Override
	public void tick(double deltaTime) {
		for(Component component : children) {
			if(component.isActive()) {
				component.tick(deltaTime);
			}
		}
	}
	
	

}
