package com.jnh.game.gameObjects.entities;

import com.jnh.game.state.GameState;
import com.jnh.game.utils.Direction;
import com.jnh.game.utils.assets.Assets;
import com.jnh.game.utils.assets.Sprite;

public class Player extends Entity {

	//TODO add inventar
	
	public Player(GameState state, float x, float y) {
		super(state, new Sprite(Assets.PLAYER, 1f, 0f, false), x, y, Player.DEFAULT_ENTITY_SIZE, Player.DEFAULT_ENTITY_SIZE);
	}

	@Override
	public void tick(double deltaTime) {
		super.tick(deltaTime);
		if(state.getKeyManager().walkUp) {
			move(Direction.UP, deltaTime);
		} else if(state.getKeyManager().walkLeft) {
			move(Direction.LEFT, deltaTime);
		} else if(state.getKeyManager().walkDown) {
			move(Direction.DOWN, deltaTime);
		} else if(state.getKeyManager().walkRight) {
			move(Direction.RIGHT, deltaTime);
		}
	}

}