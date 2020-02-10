package com.jnh.game.gameObjects.entities;

import com.jnh.game.gameObjects.GameObject;
import com.jnh.game.state.GameState;
import com.jnh.game.utils.Direction;
import com.jnh.game.utils.assets.Sprite;

/**
 * Dies ist die Klasse zur Verwaltung aller lebender und sich bewegender Lebewesen. Dazu gehören Menschen, der Player, Monster, Tiere usw., aber keine Pflanzen, die sich ja nicht bewegen können und kein wirkliches Health-System benötigen.
 * @author Henning
 */
public abstract class Entity extends GameObject {
	
	protected static final float DEFAULT_ENTITY_SIZE = 0.9f;
	
	private int maxHealth;
	private int health;
	private float speed;
	
	/**
	 * Erezeugt ein neues Entity-Objekt mit den angegebenen Parametern.
	 * @param state der GameState
	 * @param sprite das Sprite
	 * @param x die x-Koordinate
	 * @param y die y-Koordinate
	 * @param width die Breite
	 * @param height die Höhe
	 */
	public Entity(GameState state, Sprite sprite, float x, float y, float width, float height) {
		super(state, sprite, x, y, width, height);
		this.speed = 0.3f;
		this.maxHealth = 100;
		this.health = 100;
	}
	
	/**
	 * Bewegt die Entity um <code>speed</code> Einheiten in die entsprechende Richtung.
	 * @param direction die Richtung
	 * @param deltaTime die Zeit in Sekunden seit dem letzten Tick
	 * @see #move(Direction, float, double)
	 * @see Direction
	 */
	public void move(Direction direction, double deltaTime) {
		move(direction, 1f, deltaTime);
	}
	
	/**
	 * Bewegt die Entity um <code>speed * speedMultiplier</code> Einheiten in die entsprechende Richtung.
	 * @param direction die Richtung
	 * @param speedMultiplier der Geschwindigkeitsfaktor.
	 * @param deltaTime die Zeit in Sekunden seit dem letzten Tick
	 * @see #move(Direction, double)
	 * @see Direction
	 */
	public void move(Direction direction, float speedMultiplier, double deltaTime) {
		switch (direction) {
		case UP:
			setY((float) (getY() - speed * speedMultiplier));
			break;
		case LEFT:
			setX((float) (getX() - speed * speedMultiplier));
			break;
		case DOWN:
			setY((float) (getY() + speed * speedMultiplier));
			break;
		case RIGHT:
			setX((float) (getX() + speed * speedMultiplier));
			break;
		default:
			break;
		}
	}
	
	/**
	 * @return die maximale Anzahl an Gesundheit, die die Entity erhalten kann. Theoretisch kann das umgangen werden, aber dies sollte nur bei Dingen wie Magie geschehen, aber natürliche Regeneration sollte das nicht erlauben.
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @param maxHealth die maximale Anzahl an Gesundheit, die die Entity erhalten kann. Theoretisch kann das umgangen werden, aber dies sollte nur bei Dingen wie Magie geschehen, aber natürliche Regeneration sollte das nicht erlauben.
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * @return der momentante Betrag an Gesundheit
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health der momentane Betrag an Gesundheit
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return die Geschwindigkeit
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param die Geschwindigkeit
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	
}
