package com.jnh.game.world.rooms;

import com.jnh.game.gameObjects.objects.roomBoundaries.Floor;

public abstract class Room {
	
	public static final int ROOM_WIDTH =  10;
	public static final int ROOM_HEIGHT =  10;
	
	public RoomType type;
	public Room top, left, bottom, right;
	
	public Floor floor;
	
}
