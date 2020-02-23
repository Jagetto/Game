package com.jnh.game.world.rooms;

import com.jnh.game.gameObjects.objects.roomBoundaries.Floor;
import com.jnh.game.gameObjects.objects.roomBoundaries.Wall;
import com.jnh.game.state.GameState;
import com.jnh.game.utils.assets.Assets;
import com.jnh.game.utils.assets.Sprite;
import com.jnh.game.world.Dungeon;

public class RandomRoom extends Room {

	public RandomRoom(GameState state, Dungeon dungeon) {
		super(state, dungeon);
	}

	@Override
	protected void generate() {
		
		setFloor(new Floor(getState(), this, 0.025f));
		
		//Generate outer walls
		//top
		for(int x = 1; x < ROOM_WIDTH - 1; x++) {
			new Wall(getState(), new Sprite(Assets.STONE_B), x, 0);
		}
		//top right
		new Wall(getState(), new Sprite(Assets.STONE_BL), ROOM_WIDTH - 1, 0);
		//right
		for(int y = 1; y < ROOM_HEIGHT - 1; y++) {
			new Wall(getState(), new Sprite(Assets.STONE_L), ROOM_WIDTH - 1, y);
		}
		//bottom right
		new Wall(getState(), new Sprite(Assets.STONE_LT), ROOM_WIDTH - 1, ROOM_HEIGHT - 1);
		//bottom
		for(int x = 1; x < ROOM_WIDTH - 1; x++) {
			new Wall(getState(), new Sprite(Assets.STONE_T), x, ROOM_HEIGHT - 1);
		}
		//bottom left
		new Wall(getState(), new Sprite(Assets.STONE_TR), 0, ROOM_HEIGHT - 1);
		//left
		for(int y = 1; y < ROOM_HEIGHT - 1; y++) {
			new Wall(getState(), new Sprite(Assets.STONE_R), 0, y);
		}
		//top left
		new Wall(getState(), new Sprite(Assets.STONE_BR), 0, 0);
		
	}
	
	

}
