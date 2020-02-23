package com.jnh.game.utils.assets;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

import com.jnh.game.utils.FileLoader;

/**
 * Diese Klasse ist für das Laden aller Texturen verantwortlich.
 * 
 * @author Henning
 *
 */
public class Assets {
	
	public static BufferedImage TEST, PLAYER, DEBUG, FLOOR, STONE_B, STONE_L, STONE_T, STONE_R, STONE_BL, STONE_BT, STONE_BR, STONE_BLT, STONE_BLR, STONE_BTR, STONE_BLTR, STONE_LT, STONE_LR, STONE_TR;
	
	/**
	 * Lädt alle Texturen.
	 * @throws FileNotFoundException
	 */
	public static void init() throws FileNotFoundException {
		TEST = FileLoader.loadImage("test.png");
		PLAYER = FileLoader.loadImage("player.png");
		DEBUG = FileLoader.loadImage("debug.png");
		FLOOR = FileLoader.loadImage("floor.png");
		STONE_B = FileLoader.loadImage("Wall_Stonebrick_Bot.png");
		STONE_L = FileLoader.loadImage("Wall_Stonebrick_Left.png");
		STONE_T = FileLoader.loadImage("Wall_Stonebrick_Top.png");
		STONE_R = FileLoader.loadImage("Wall_Stonebrick_Right.png");
		STONE_BL = FileLoader.loadImage("Wall_Stonebrick_Bot+Left.png");
		STONE_BT = FileLoader.loadImage("Wall_Stonebrick_Bot+Top.png");
		STONE_BR = FileLoader.loadImage("Wall_Stonebrick_Bot+Right.png");
		STONE_BLT = FileLoader.loadImage("Wall_Stonebrick_Bot+Left+Top.png");
		STONE_BLR = FileLoader.loadImage("Wall_Stonebrick_Bot+Left+Right.png");
		STONE_BTR = FileLoader.loadImage("Wall_Stonebrick_Bot+Top+Right.png");
		STONE_BLTR = FileLoader.loadImage("Wall_Stonebrick_Bot+Left+Top+Right.png");
		STONE_LT = FileLoader.loadImage("Wall_Stonebrick_Left+Top.png");
		STONE_LR = FileLoader.loadImage("Wall_Stonebrick_Left+Right.png");
		STONE_TR = FileLoader.loadImage("Wall_Stonebrick_Top+Right.png");
	} 
}
