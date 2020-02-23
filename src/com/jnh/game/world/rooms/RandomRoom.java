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
		for(int x = 0; x < ROOM_WIDTH; x++) {
			for(int y = 0; y < 2; y++) {
				getState().getGameObjectManager().add(new Wall(getState(), new Sprite(Assets.STONE_B), x, y * 4));
			}
		}
		
	}
	
	

}
