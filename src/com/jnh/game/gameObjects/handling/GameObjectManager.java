package com.jnh.game.gameObjects.handling;

import java.awt.Graphics;
import java.util.LinkedList;

import com.jnh.game.gameObjects.GameObject;
import com.jnh.game.state.GameState;

/**
 * Diese Klasse ist zum Verwalten aller GameObject in der GameState gedacht.
 * @see GameState
 * @author Henning
 */
public class GameObjectManager {
	
	private LinkedList<GameObject> gameObjects;
	private LinkedList<GameObject> activeGameObjects;
	
	/**
	 * Erzeugt einen neuen GameObjectManager.
	 */
	public GameObjectManager() {
		gameObjects = new LinkedList<GameObject>();
		activeGameObjects = new LinkedList<GameObject>();
	}
	
	/**
	 * Ruft die tick-Methode aller aktiven GameObjects auf.
	 * @param deltaTime die Zeit seit dem letzten Tick in Sekunden
	 */
	public void tick(double deltaTime) {
		for (GameObject gameObject : activeGameObjects) {
			gameObject.tick(deltaTime);
		}
	}
	
	/**
	 * Rendert alle GameObjects.
	 * @param g das Graphics-Objekts
	 * @see Graphics
	 */
	public void render(Graphics g) {
		for (GameObject gameObject : gameObjects) {
			gameObject.render(g);
		}
	}
	
	/**
	 * F�gt, dass GameObject dem Manager hinzu. Es wird dadurch der Welt hinzugef�gt und angezeigt.
	 * @param gameObject das hinzuzuf�gende GameObject
	 * @param isActive ob das GameObject tick-Methoden erhalten soll. Dies sollte nur bei Kreaturen und anderen interaktiven Dingen geschehen, nicht aber bei Objekten wie W�nden. Etwas wie Kollision sollte �ber das aktive Objekt, also �ber z.B. den Spieler festgestellt werden.
	 */
	public void add(GameObject gameObject, boolean isActive) {
		gameObjects.add(gameObject);
		if(isActive) {
			activeGameObjects.add(gameObject);
		}
	}
	
	/**
	 * L�scht das angegebene GameObjekt, wenn es noch vorhanden ist.
	 * @param gameObject das zu l�schende GameObjekt
	 */
	public void remove(GameObject gameObject) {
		gameObjects.remove(gameObject);
		activeGameObjects.remove(gameObject);
	}
}
