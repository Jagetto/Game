package com.jnh.game.gfx;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import com.jnh.game.Game;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	private Game game;
	
	public Display(Game game, String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.game = game;
		createDisplay();
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(Color.WHITE);
		//frame.setContentPane(new JLayeredPane());
		frame.getContentPane().setBackground(Color.WHITE);
		
		//RESIZING
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				resizedFrame((int) frame.getSize().getWidth(),(int) frame.getSize().getHeight());
			}
		});
		
		//CANVAS
		canvas = new Canvas();
		canvas.setFocusable(true);
		resizedFrame(width, height);
		frame.add(canvas);
		//canvas.setVisible(false);
		frame.pack();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setSize(int width, int height) {
		frame.setSize(width, height);
	}
	
	private void resizedFrame(int width, int height) {
		this.width = width;
		this.height = height;
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		game.resize((int) frame.getSize().getWidth(), (int) frame.getSize().getHeight());
	}
	
}
