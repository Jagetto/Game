package com.jnh.game.state;

import java.awt.Graphics;

import com.jnh.game.Game;
import com.jnh.game.gameObjects.handling.GameObjectManager;
import com.jnh.game.gfx.cameras.GameCamera;
import com.jnh.game.input.GameKeyManager;
import com.jnh.game.utils.Logger;

/**
 * Dies ist die GameState-Klasse, welche neben anderen States das eigenliche Spiel verwaltet.
 * @author Henning
 */
public class GameState extends State {
	
	/**
	 * Erzeugt einen neuen GameState.
	 * @param game das Spiel
	 * @see Game
	 */
	public GameState(Game game) {
		super(game);
	}

	private GameObjectManager gameObjectManager;
	private GameKeyManager keyManager;
	private GameCamera camera;
	
	@Override
	public void load() {
		keyManager = new GameKeyManager();
		game.getDisplay().getFrame().addKeyListener(keyManager);
		game.getDisplay().getCanvas().addKeyListener(keyManager);
		gameObjectManager = new GameObjectManager();
		camera = new GameCamera(100, 100, 1.2f, null);
	}

	@Override
	public void tick(double deltaTime) {
		keyManager.tick();
		gameObjectManager.tick(deltaTime);
		camera.tick(deltaTime);
		//TEMP
		Logger.log(this,""+keyManager.walkLeft);
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

	/**
	 * @return der Key-Manager, der die Tastatur-Eingaben verwaltet
	 */
	public GameKeyManager getKeyManager() {
		return keyManager;
	}

	/**
	 * @return die Kamera
	 */
	public GameCamera getCamera() {
		return camera;
	}
	
	

}
