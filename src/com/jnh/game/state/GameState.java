package com.jnh.game.state;

import java.awt.Graphics;

import com.jnh.game.Game;
import com.jnh.game.gameObjects.entities.Player;
import com.jnh.game.gameObjects.handling.GameObjectManager;
import com.jnh.game.gfx.cameras.GameCamera;
import com.jnh.game.input.GameKeyManager;
import com.jnh.game.world.Dungeon;

/**
 * Dies ist die GameState-Klasse, welche neben anderen States das eigenliche Spiel verwaltet.
 * @author Henning
 */
public class GameState extends State {
	
	private GameObjectManager gameObjectManager;
	private GameKeyManager keyManager;
	private GameCamera camera;
	
	private Dungeon dungeon;
	
	private Player player;
	
	private int width, height;
	
	/**
	 * Erzeugt einen neuen GameState.
	 * @param game das Spiel
	 * @see Game
	 */
	public GameState(Game game) {
		super(game);
	}


	@Override
	public void load() {
		
		keyManager = new GameKeyManager();
		game.getDisplay().getCanvas().addKeyListener(keyManager);
		
		gameObjectManager = new GameObjectManager();
		
		dungeon = new Dungeon(this, System.currentTimeMillis(), 1);
		
		//TEMP
		for(int i = 0; i < 3000; i++) {
			//gameObjectManager.add(new GameObject(this, new Sprite(Assets.DEBUG), (float) (Math.random() * 10), (float) (Math.random() * 10), 1, 1));
		}
		
		player = new Player(this, 3, 3);
		//gameObjectManager.add(player);
		
		camera = new GameCamera(0, 0, 5f, null);
		camera.setCenterObject(player);
	}

	@Override
	public void tick(double deltaTime) {
		keyManager.tick();
		gameObjectManager.tick(deltaTime);
		camera.tick(deltaTime);
	}

	@Override
	public void render(Graphics g) {
		gameObjectManager.render(g);
	}

	@Override
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void dispose() {
		game.getDisplay().getCanvas().removeKeyListener(keyManager);
	}

	/**
	 * @return der Key-Manager, der die Tastatur-Eingaben verwaltet
	 */
	public GameKeyManager getKeyManager() {
		return keyManager;
	}
	
	/**
	 * @return der GameObject-Manager, der die GameObjects verwaltet
	 */
	public GameObjectManager getGameObjectManager() {
		return gameObjectManager;
	}

	/**
	 * @return die Kamera
	 */
	public GameCamera getCamera() {
		return camera;
	}
	
	/**
	 * 
	 * @return die Breite des Fensters
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * 
	 * @return die H�he des Fensters
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return gibt den momentanen Dungeon zur�ck
	 */
	public Dungeon getDungeon() {
		return dungeon;
	}
	
}
