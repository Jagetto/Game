package com.jnh.game.state;

import java.awt.Graphics;

import com.jnh.game.gameObjects.handling.GameObjectManager;
import com.jnh.game.gfx.cameras.GameCamera;

/**
 * Dies ist die GameState-Klasse, welche neben anderen States das eigenliche Spiel verwaltet.
 * @author Henning
 */
public class GameState extends State {
	
	private GameObjectManager gameObjectManager;
	private GameCamera camera;
	
	@Override
	public void load() {
		gameObjectManager = new GameObjectManager();
		camera = new GameCamera(100, 100, 1.2f, null);
	}

	@Override
	public void tick(double deltaTime) {
		gameObjectManager.tick(deltaTime);
		camera.tick(deltaTime);
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void dispose() {
		
	}

}
