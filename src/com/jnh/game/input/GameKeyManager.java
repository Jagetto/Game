package com.jnh.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Diese Klasse ist für die Verwaltung von Tastatur-Eingaben zuständig.
 * @author Henning
 */
public class GameKeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean walkUp, walkLeft, walkDown, walkRight;
	
	public GameKeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		walkUp = keys[KeyEvent.VK_W];
		walkLeft = keys[KeyEvent.VK_A];
		walkDown = keys[KeyEvent.VK_S];
		walkRight = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
