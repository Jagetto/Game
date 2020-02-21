package com.jnh.game.world;

import java.util.Random;

import com.jnh.game.state.GameState;
import com.jnh.game.world.rooms.RandomRoom;
import com.jnh.game.world.rooms.Room;

/**
 * Progressiv erstellte Karte für das Spiel.
 * @author Henning
 */
public class Dungeon {
	
	/**
	 * Nur ungerade Zahlen funktionieren richtig.
	 */
	public static final int DUNGEON_SIZE = 7;
	
	private GameState state;
	
	private long seed;
	
	private Room currentRoom;
	private Room[][] rooms;
	
	private int difficulty;
	
	private Random generator;
	
	
	/**
	 * Erzeugt einen neuen Dungeon mit den angegebenen Parametern.
	 * @param seed der Seed für die Generierung
	 * @param difficulty die Schwierigkeit des Dungeons
	 */
	public Dungeon(GameState state, long seed, int difficulty) {
		this.state = state;
		this.seed = seed;
		this.difficulty = difficulty;
		generate();
	}
	
	/**
	 * Generiert den Dungeon.
	 */
	private void generate() {
		rooms = new Room[DUNGEON_SIZE][DUNGEON_SIZE];
		
		generator = new Random(seed);
		
		rooms[DUNGEON_SIZE / 2][DUNGEON_SIZE / 2] = new RandomRoom(state, this);
		currentRoom = rooms[DUNGEON_SIZE / 2][DUNGEON_SIZE / 2];
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
	
	/**
	 * @return gibt das <code>Random</code>-Objekt zurück, mit dem die Karte progressiv erstellt wird
	 */
	public Random getGenerator() {
		return generator;
	}

	/**
	 * @return Gibt die Schwierigkeit dieses Dungeons zurück. Diese sollte ausschlaggebend für die Monster-Spawn-Rate oder Anzahl an Fallen etc. sein.
	 */
	public int getDifficulty() {
		return difficulty;
	}
	
	/**
	 * Gibt den Raum an der angegebenen Stelle zurück.
	 * @param x die x-Position
	 * @param y die y-Position
	 */
	public Room getRoomAt(int x, int y) {
		return rooms[x][y];
	}
	
}
