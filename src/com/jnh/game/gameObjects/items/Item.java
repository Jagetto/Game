package com.jnh.game.gameObjects.items;

import java.awt.Graphics;

import com.jnh.game.gameObjects.GameObject;
import com.jnh.game.state.GameState;
import com.jnh.game.utils.assets.Sprite;

public abstract class Item extends GameObject {
	
	public Item(GameState state, Sprite sprite, float x, float y, float width, float height) {
		super(state, sprite, x, y, width, height);
	}

	public void render(Graphics g) {
		super.render(g);
	}
	
	public void tick(double deltaTime) {
		super.tick(deltaTime);
	}
	

}
