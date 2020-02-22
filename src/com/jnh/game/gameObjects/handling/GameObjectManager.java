package com.jnh.game.gameObjects.handling;

import java.awt.Graphics;
import java.util.LinkedList;

import com.jnh.game.gameObjects.GameObject;
import com.jnh.game.state.GameState;

/**
 * Diese Klasse ist zum Verwalten aller GameObjects in der GameState gedacht.
 * @see GameState
 * @author Henning
 */
public class GameObjectManager {
	
	private LinkedList<GameObject> gameObjects;
	private LinkedList<Collisionable> collisionables;
	private LinkedList<Collectable> collectables;
	private LinkedList<Interactable> interactables;
	
	/**
	 * Erzeugt einen neuen GameObjectManager.
	 */
	public GameObjectManager() {
		gameObjects = new LinkedList<GameObject>();
	}
	
	/**
	 * Ruft die tick-Methode aller aktiven GameObjects auf.
	 * @param deltaTime die Zeit seit dem letzten Tick in Sekunden
	 */
	public void tick(double deltaTime) {
		for (GameObject gameObject : gameObjects) {
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
	 */
	public void add(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	/**
	 * Registriert das Objekt als kollidierbar.
	 * @param collisionable das kollidierbare Objekt
	 */
	public void addCollisionable(Collisionable collisionable) {
		collisionables.add(collisionable);
	}
	
	/**
	 * Registriert das Objekt als sammelbar.
	 * @param collectable das sammelbare Objekt
	 */
	public void addCollectable(Collectable collectable) {
		collectables.add(collectable);
	}
	
	/**
	 * Registriert das Objekt als interagierbar.
	 * @param interactable das interagierbare Objekt
	 */
	public void addInteractable(Interactable interactable) {
		interactables.add(interactable);
	}
	
	
	
	
	/**
	 * L�scht das angegebene GameObjekt, wenn es noch vorhanden ist.
	 * @param gameObject das zu l�schende GameObjekt
	 */
	public void remove(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}
	
	/**
	 * L�scht das Objekt aus der Liste der kollidierbaren Objekte.
	 * @param collisionable das zu l�schende Objekt
	 */
	public void removeCollisionable(Collisionable collisionable) {
		collisionables.remove(collisionable);
	}
	
	/**
	 * L�scht das Objekt aus der Liste der sammelbaren Objekte.
	 * @param collectable das zu l�schende Objekt
	 */
	public void removeCollectable(Collectable collectable) {
		collectables.remove(collectable);
	}
	
	/**
	 * L�scht das Objekt aus der Liste der interagierbaren Objekte.
	 * @param interactable das zu l�schende Objekt
	 */
	public void removeCollectable(Interactable interactable) {
		interactables.remove(interactable);
	}
	
	
	
	
	/**
	 * @return Liste mit allen als kollidierbar registrierten Objekten
	 */
	public LinkedList<Collisionable> getCollisionables() {
		return collisionables;
	}
	
	/**
	 * @return Liste mit allen als sammelbar registrierten Objekten
	 */
	public LinkedList<Collectable> getCollectables() {
		return collectables;
	}
	
	/**
	 * @return Liste mit allen als interaktierbar registrierten Objekten
	 */
	public LinkedList<Interactable> getInteractables() {
		return interactables;
	}
}
