package com.jnh.game.state;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.jnh.game.Game;

public class MenuState extends State {
	
	private JPanel root;
	
	public MenuState(Game game) {
		super(game);
		root = new JPanel();
	}

	@Override
	public void load() {
		
	}

	@Override
	public void tick(double deltaTime) {
		
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
