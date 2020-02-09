package com.jnh.game.gameObjects.entities;

import com.jnh.game.state.GameState;
import com.jnh.game.utils.Direction;
import com.jnh.game.utils.assets.Assets;
import com.jnh.game.utils.assets.Sprite;

public class Player extends Entity {

	public Player(GameState state, Sprite sprite, float x, float y, float width, float height) {
		super(state, new Sprite(Assets.TEST, 1f, 0f, false), x, y, width, height);
	}

	@Override
	public void tick(double deltaTime) {
		if(state.getKeyManager().walkUp) {
			move(Direction.UP, deltaTime);
		}
		if(state.getKeyManager().walkLeft) {
			move(Direction.LEFT, deltaTime);
		}
		if(state.getKeyManager().walkDown) {
			move(Direction.DOWN, deltaTime);
		}
		if(state.getKeyManager().walkRight) {
			move(Direction.RIGHT, deltaTime);
		}
		super.tick(deltaTime);
	}

}