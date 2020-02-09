package com.jnh.game.gameObjects;

import java.awt.Graphics;

import com.jnh.game.state.GameState;
import com.jnh.game.utils.Global;
import com.jnh.game.utils.assets.Sprite;

/**
 * Die grundlegende Klasse für alle Objekte im Spiel. Darunter fallen Lebewesen, Monster, der Spieler, Gegenstände, Wände etc.
 * @author Henning
 */
public abstract class GameObject {
	
	protected GameState state;
	private Sprite sprite;
	private float x;
	private float y;
	private float width;
	private float height;
	
	/**
	 * Erstellt ein neues GameObject.
	 * @param sprite das {@link Sprite} zum Anzeigen der Textur etc.
	 * @param x die x-Position
	 * @param y die y-Position
	 * @param width die Breite
	 * @param height die Höhe
	 */
	public GameObject(GameState state, Sprite sprite, float x, float y, float width, float height) {
		this.state = state;
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Rendert das Sprite.
	 * @param g das Graphics-Objekt zum Zeichnen
	 */
	public void render(Graphics g) {
		sprite.render(g, (x - state.getCamera().getX()) * Global.SCALE, (y - state.getCamera().getY()) * Global.SCALE, width * Global.SCALE, height * Global.SCALE);
	}
	
	/**
	 * Game-Tick für das GameObject. Hier nur, wenn unbedingt nötig komplexe Dinge ausführen, berechnen etc., weil es Hunderte GameObjects geben kann.
	 * @param deltaTime die Zeit seit dem letzten Objekt
	 */
	public void tick(double deltaTime) {
		
	}
	
	/**
	 * @return das Sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}
	
	/**
	 * @param sprite das Sprite
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	/**
	 * @return die x-Koordinate
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * @param x die x-Koordinate
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * @return die y-Koordinate
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * @param y die y-Koordinate
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * @return die Breite
	 */
	public float getWidth() {
		return width;
	}
	
	/**
	 * @param width die Breite
	 */
	public void setWidth(float width) {
		this.width = width;
	}
	
	/**
	 * @return die Höhe
	 */
	public float getHeight() {
		return height;
	}
	
	/**
	 * @param height die Höhe
	 */
	public void setHeight(float height) {
		this.height = height;
	}
	
	
}
