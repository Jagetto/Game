package com.jnh.game.gameObjects.entities;

import com.jnh.game.gameObjects.GameObject;
import com.jnh.game.state.GameState;
import com.jnh.game.utils.Logger;
import com.jnh.game.utils.assets.Sprite;

/**
 * Dies ist die Klasse zur Verwaltung aller lebender und sich bewegender Lebewesen. Dazu gehören Menschen, der Player, Monster, Tiere usw., aber keine Pflanzen, die sich ja nicht bewegen können und kein wirkliches Health-System benötigen.
 * 
 * @author Henning
 *
 */
public abstract class Entity extends GameObject {
	
	private int maxHealth;
	private int health;
	private float speed;
	
	public Entity(GameState state, Sprite sprite, float x, float y, float width, float height) {
		super(state, sprite, x, y, width, height);
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
