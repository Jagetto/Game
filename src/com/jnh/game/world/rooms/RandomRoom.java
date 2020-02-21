package com.jnh.game.world.rooms;

import com.jnh.game.gameObjects.objects.roomBoundaries.Floor;
import com.jnh.game.state.GameState;
import com.jnh.game.world.Dungeon;

public class RandomRoom extends Room {

	public RandomRoom(GameState state, Dungeon dungeon) {
		super(state, dungeon);
	}

	@Override
	protected void generate() {
		
		floor = new Floor(getState(), this, 0.025f);
		if(getDungeon().getGenerator().nextBoolean()) {
			
		}
		if(getDungeon().getGenerator().nextBoolean()) {
			
		}
		if(getDungeon().getGenerator().nextBoolean()) {
	
}
		if(getDungeon().getGenerator().nextBoolean()) {
	
		}
		
	}
	
	

}
