package com.jnh.game.gameObjects.objects.roomBoundaries;

import java.awt.Rectangle;

import com.jnh.game.gameObjects.GameObject;
import com.jnh.game.gameObjects.handling.Collisionable;
import com.jnh.game.state.GameState;
import com.jnh.game.utils.assets.Sprite;

public class Wall extends GameObject implements Collisionable {
	
	
	public Wall(GameState state, Sprite sprite, float x, float y) {
		super(state, sprite, x, y, 1f, 1f);
	}

	@Override
	public void onCollision(GameObject gameObject) {
		
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}
}
