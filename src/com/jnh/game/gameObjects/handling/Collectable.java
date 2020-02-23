package com.jnh.game.gameObjects.handling;

import com.jnh.game.gameObjects.GameObject;
import com.jnh.game.gameObjects.items.Item;

public interface Collectable {
	
	/**
	 * @param gameObject
	 * @return das Item, was eingesammelt werden soll
	 */
	public Item getItem(GameObject gameObject);
	
}