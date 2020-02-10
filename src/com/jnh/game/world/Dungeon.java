package com.jnh.game.world;

import com.jnh.game.world.rooms.Room;

/**
 * Progressiv erstellte Karte für das Spiel.
 * @author Guest
 *
 */
public class Dungeon {
	
	private long seed;
	
	private Room startRoom;
	private Room currentRoom;
	
	private int difficulty;
	
	/**
	 * Erzeugt einen neuen Dungeon mit den angegebenen Parametern.
	 * @param seed der Seed für die Generierung
	 * @param difficulty die Schwierigkeit des Dungeons
	 */
	public Dungeon(long seed, int difficulty) {
		this.seed = seed;
		this.difficulty = difficulty;
	}
	
	/**
	 * Generiert den Dungeon.
	 */
	public void generate() {
		
	}
	
	/**
	 * Setzt den momentan sichtbaren Raum zu dem angegebenen.
	 * @param room der neue Raum
	 */
	public void setCurrentRoom(Room room) {
		this.currentRoom = room;
	}
	
	/**
	 * @return der momentan sichtbare Raum
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
}
