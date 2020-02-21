package com.jnh.game.gameObjects.objects.roomBoundaries;

import com.jnh.game.gameObjects.GameObject;
import com.jnh.game.state.GameState;
import com.jnh.game.utils.assets.Assets;
import com.jnh.game.utils.assets.Sprite;

public class Wall extends GameObject {
	
	
	public Wall(GameState state, Sprite sprite, float x, float y) {
		super(state, new Sprite(Assets.DEBUG), x, y, 1f, 1f);
	}
}
