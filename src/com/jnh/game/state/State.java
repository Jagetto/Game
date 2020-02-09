package com.jnh.game.state;

import java.awt.Graphics;

import com.jnh.game.Game;

/**
 * Die State-Klasse ist eine abstrakte Klasse, von der alle Ansichten des Spiels erben sollten. So sollte die Ansicht des Spiels oder beispielsweise eine Menü-Klasse einer erbende Klasse dieser sein.
 * @author Henning
 */
public abstract class State {
	
	protected Game game;
	
	/**
	 * Erzeugt einen neuen State.
	 * @param game das Game
	 * @see Game
	 */
	public State(Game game) {
		this.game = game;
	}
	
	/**
	 * Wird beim Laden des States aufgerufen.
	 */
	public abstract void load();
	
	/**
	 * Wird jeden Tick aufgerufen und sollte die Logik des Spiels modifizieren.
	 * @param deltaTime die Zeit in Sekunden seit dem letzten Tick
	 */
	public abstract void tick(double deltaTime);
	
	/**
	 * Wird jeden Tick direkt nach {@link #tick(double)} aufgerufen und sollte zum Rendern des Spiels verwendet werden.
	 * @param g das Graphics-Objekt das zum Zeichnen benutzt werden soll.
	 * @see Graphics
	 */
	public abstract void render(Graphics g);
	
	/**
	 * Wird aufgerufen, wenn sich die Größe des Spiels ändert.
	 * @param width die neue Breite
	 * @param height die neue Höhe
	 */
	public abstract void resize(int width, int height);
	
	/**
	 * Wird aufgerufen, bevor diese State gelöscht wird.
	 */
	public abstract void dispose();
}
