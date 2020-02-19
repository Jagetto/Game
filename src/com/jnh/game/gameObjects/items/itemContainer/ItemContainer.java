package com.jnh.game.gameObjects.items.itemContainer;

import java.util.LinkedList;

import com.jnh.game.gameObjects.items.Item;

public class ItemContainer {
	
	private LinkedList<Item> items;
	private int size;
	
	public ItemContainer(int size) {
		this.size = size;
	}
	
	public boolean addItem(Item item) {
		if(items.size() >= size) {
			return false;
		} else {
			items.add(item);
			return true;
		}
	}
	
	public boolean removeItem(Item item) {
		return items.remove(item);
	}

}
