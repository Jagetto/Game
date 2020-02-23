package com.jnh.game.gameObjects.handling;

import java.awt.Rectangle;

import com.jnh.game.gameObjects.GameObject;

/**
 * Dieses Interface ist f�r alle Objekte gedacht, die kollidierbar sein sollten.
 * @see Collectable
 * @see Interactable
 * @author Henning
 */
public interface Collisionable {
	
	/**
	 * Wird bei der Kollision aufgerufen.
	 * @param gameObject das GameObject mit dem es zur Kollision kommt
	 */
	public void onCollision(GameObject gameObject);
	
	/**
	 * Gibt ein Recteck mit der Gr��e das Objekts zur�ckgeben.
	 * @return das Rechteck
	 */
	public Rectangle getBounds();
	
}
