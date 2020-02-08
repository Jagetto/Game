package com.jnh.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.jnh.game.state.State;
import com.jnh.gfx.Display;

public class Game implements Runnable {

	private Thread thread;
	private boolean running = false;
	
	private Display display;
	
	private BufferStrategy bufferStrategy;
	private Graphics graphics;
	
	//TODO Resizing
	private int width = 1600;
	private int height = 1000;
	
	private State state;
	
	private void init() {
		//TODO init eventlistener
		display = new Display(this, "Game Title", width, height);
	}
	
	public void tick(double deltaTime) {
		System.out.println("tick");
		//TODO tick eventlistener
		if(state != null) {
			state.render(graphics);
		}
	}

	public void render() {
		bufferStrategy = display.getCanvas().getBufferStrategy();
		if(bufferStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		graphics = bufferStrategy.getDrawGraphics();
		graphics.clearRect(0, 0, width, height);
		
		graphics.drawString("Test 07.02.2020 LOL", 20, 20);
		if(state != null) {
			state.render(graphics);
		}
		
		bufferStrategy.show();
		graphics.dispose();
	}
	
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
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
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
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

}
