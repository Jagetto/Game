package com.jnh.game.gameObjects.objects.roomBoundaries;

import com.jnh.game.gameObjects.GameObject;
import com.jnh.game.state.GameState;
import com.jnh.game.utils.assets.Assets;
import com.jnh.game.utils.assets.Sprite;
import com.jnh.game.world.rooms.Room;

public class Floor extends GameObject {
	
	private float friction;
	
	public Floor(GameState state, Room room, float friction) {
		super(state, new Sprite(Assets.DEBUG), 0, 0, Room.ROOM_WIDTH, Room.ROOM_HEIGHT);
		this.friction = friction;
	}
	
	/**
	 * @return die Reibung
	 */
	public float getFriction() {
		return friction;
	}
	
}
