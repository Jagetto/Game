package com.jnh.game.gameObjects;

/**
 * Diese Klasse ist zur Kollisionsüberprüfung gedacht.
 * NOT FINISHED YET.
 * @author Henning
 */
public class Body {
	
	protected GameObject gameObject;
	protected float x, y, width, height;
	
	public Body(GameObject gameObject) {
		this.gameObject = gameObject;
		this.x = gameObject.getX();
		this.y = gameObject.getY();
		this.width = gameObject.getWidth();
		this.height = gameObject.getHeight();
	}
	
	public Body(GameObject gameObject, float x, float y, float width, float height) {
		this.gameObject = gameObject;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void tick(double deltaTime) {
		
	}
}