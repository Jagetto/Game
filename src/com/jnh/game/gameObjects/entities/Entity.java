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
	
	private float maxSpeed;
	private float xSpeed;
	private float ySpeed;
	
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
		
		this.xSpeed = 0f;
		this.ySpeed = 0f;
		
		this.maxSpeed = 0.3f;
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
	 * Beschleunigt die Entity um weitere <code>speed * speedMultiplier</code> Einheiten in die entsprechende Richtung.
	 * @param direction die Richtung
	 * @param speedMultiplier der Geschwindigkeitsfaktor.
	 * @param deltaTime die Zeit in Sekunden seit dem letzten Tick
	 * @see #move(Direction, double)
	 * @see Direction
	 */
	public void move(Direction direction, float speedMultiplier, double deltaTime) {
		switch (direction) {
		case UP:
			if(-ySpeed < maxSpeed) {
				ySpeed = ySpeed - 0.03f * speedMultiplier;
			}
			break;
		case LEFT:
			if(-xSpeed < maxSpeed) {
				xSpeed = xSpeed - 0.03f * speedMultiplier;
			}
			break;
		case DOWN:
			if(ySpeed < maxSpeed) {
				ySpeed = ySpeed + 0.03f * speedMultiplier;
			}
			break;
		case RIGHT:
			if(xSpeed < maxSpeed) {
				xSpeed = xSpeed + 0.03f * speedMultiplier;
			}
			break;
		default:
			break;
		}
	}
	
	
	
	@Override
	public void tick(double deltaTime) {
		super.tick(deltaTime);
		if(Math.abs(xSpeed) > state.getDungeon().getCurrentRoom().getFloor().getFriction()) {
			xSpeed = xSpeed - (Math.abs(xSpeed) / xSpeed) * state.getDungeon().getCurrentRoom().getFloor().getFriction();
		} else {
			xSpeed = 0;
		}
		if(Math.abs(ySpeed) > state.getDungeon().getCurrentRoom().getFloor().getFriction()) {
			ySpeed = ySpeed - (Math.abs(ySpeed) / ySpeed) * state.getDungeon().getCurrentRoom().getFloor().getFriction();
		} else {
			ySpeed = 0;
		}
		setY(getY() + ySpeed);
		setX(getX() + xSpeed);
		
	}
	
	public void takeDamage(int damage, boolean ignoreArmor) {
		this.health = this.health - (damage - rüstung.getResistance());
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
	 * @return die momentane x-Geschwindigkeit
	 */
	public float getXSpeed() {
		return xSpeed;
	}

	/**
	 * @param die momentane x-Geschwindigkeit
	 */
	public void setXSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	/**
	 * @return die momentane y-Geschwindigkeit
	 */
	public float getYSpeed() {
		return ySpeed;
	}

	/**
	 * @param die momentane y-Geschwindigkeit
	 */
	public void setYSpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}

	/**
	 * @return die auf natürlichem Wege maximal erreichbare Geschwindigkeit in jede Richtung
	 */
	public float getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @param maxSpeed die auf natürlichem Wege maximal erreichbare Geschwindigkeit in jede Richtung
	 */
	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	
	
}
