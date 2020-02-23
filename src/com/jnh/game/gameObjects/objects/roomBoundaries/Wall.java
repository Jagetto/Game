package com.jnh.game.gameObjects.objects.roomBoundaries;

import java.awt.geom.Rectangle2D;

import com.jnh.game.gameObjects.GameObject;
import com.jnh.game.gameObjects.handling.Collisionable;
import com.jnh.game.state.GameState;
import com.jnh.game.utils.assets.Sprite;


public class Wall extends GameObject implements Collisionable {
	
	
	public Wall(GameState state, Sprite sprite, float x, float y) {
		super(state, sprite, x, y, 1f, 1f);
		state.getGameObjectManager().addCollisionable(this);
	}

	@Override
	public void onCollision(GameObject gameObject) {
		
	}

	@Override
	public Rectangle2D getBounds() {
		return new Rectangle2D.Float(getX(), getY(), getWidth(), getHeight());
	}
}
