package com.jnh.game.world.rooms;

import com.jnh.game.gameObjects.objects.roomBoundaries.Floor;
import com.jnh.game.state.GameState;
import com.jnh.game.world.Dungeon;

/**
 * Ein Raum des Dungeons.
 * @author Henning
 * @see Dungeon
 */
public abstract class Room {
	
	public static final int ROOM_WIDTH =  10;
	public static final int ROOM_HEIGHT =  10;
	
	private GameState state;
	private Dungeon dungeon;
	
	private RoomType type;
	private Room top, left, bottom, right;
	
	private Floor floor;
	
	public Room(GameState state, Dungeon dungeon) {
		this.state = state;
		this.dungeon = dungeon;
		generate();
	}
	
	protected abstract void generate();
	
	
	/**
	 * @param floor der neue Boden
	 */
	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	/**
	 * @return der Boden
	 */
	public Floor getFloor() {
		return floor;
	}
	
	protected GameState getState() {
		return state;
	}
	
	protected Dungeon getDungeon() {
		return dungeon;
	}
	
}
