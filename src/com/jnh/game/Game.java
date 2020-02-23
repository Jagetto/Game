package com.jnh.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.FileNotFoundException;

import com.jnh.game.gfx.Display;
import com.jnh.game.state.GameState;
import com.jnh.game.state.State;
import com.jnh.game.utils.assets.Assets;

/**
 * Die Klasse die das Spiel und den Render / Tick - Loop und andere Events sowie den Thread verwaltet.
 * @author Henning
 */
public class Game implements Runnable {

	private Thread thread;
	private boolean running = false;
	
	private Display display;
	
	private BufferStrategy bufferStrategy;
	private Graphics graphics;
	
	private int width = 1600;
	private int height = 1000;
	
	private State state;
	
	/**
	 * Wird beim Erstellen des Ticks aufgerufen und initialisiert einige Dinge, wenn es zu einem Fehler kommt wird das Programm beendet.
	 * TODO error message
	 */
	private void init() {
		System.setProperty("sun.java2d.opengl", "True");
		try {
			Assets.init();
		} catch (FileNotFoundException e) {
			System.out.println("could not load textures");
			e.printStackTrace();
			System.exit(0);
		}
		display = new Display(this, "Game Title", width, height);
		
		setState(new GameState(this));
	}
	
	/**
	 * Wird jedes Frame aufgerufen und ist für das Verwalten von Ereignissen verantwortlich.
	 * @param deltaTime die Zeit in Sekunden seit dem letzten Tick
	 */
	public void tick(double deltaTime) {
		if(state != null) {
			state.tick(deltaTime);
		}
	}
	
	/**
	 * Wird jedes Frame aufgerufen und ist für das Rendern zuständig.
	 */
	public void render() {
		bufferStrategy = display.getCanvas().getBufferStrategy();
		if(bufferStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		graphics = bufferStrategy.getDrawGraphics();
		graphics.clearRect(0, 0, width, height);
		
		if(state != null) {
			state.render(graphics);
		}
		
		bufferStrategy.show();
		graphics.dispose();
	}
	
	/**
	 * Wird aufgerufen, um das Spiel zu resizen.
	 * @param width
	 * @param height
	 */
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
		if(state != null) {
			state.resize(width, height);
		}
	}
	
	/**
	 * Wird aufgerufen, wenn der Thread läuft und enthält den Render-Loop.
	 */
	@Override
	public void run() {
		init();	
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		long ticks = 0;
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1) {
				tick(delta);
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
	}
	
	/**
	 * Startet den Thread.
	 */
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Stoppt den Thread.
	 */
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Diese Methode setzt den State des Spiels zu den angegeben und ruft {@link State.load()} sowie ggf. {@link State.dispose()} beim alten auf.
	 * @param state der neue State
	 */
	public void setState(State state) {
		if(this.state != null) {
			this.state.dispose();
		}
		this.state = state;
		state.load();
	}
	
	/**
	 * Diese Methode gibt den momentanen State zurück.
	 * @return den momentanen State
	 */
	public State getState() {
		return state;
	}

	/**
	 * @return das Display
	 */
	public Display getDisplay() {
		return display;
	}
	

}
