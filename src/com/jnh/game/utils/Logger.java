package com.jnh.game.utils;

/**
 * Diese Klasse vereinfacht das Ausgeben von Nachrichten oder Fehlermeldungen in die Konsole.
 * @author Hennning
 */
public class Logger {
	
	/**
	 * Gibt eine Status-Nachricht aus.
	 * @param context das momentane Objekt
	 * @param message die Nachricht
	 */
	public static void log(Object context, String message) {
		System.out.println("["+context.getClass()+"]: "+message);
	}
	
	/**
	 * Gibt eine Warn-Nachricht aus.
	 * @param context das momentane Objekt
	 * @param message die Nachricht
	 */
	public static void warn(Object context, String message) {
		System.out.println("WARN: "+"["+context.getClass()+"]: "+message);
	}
	
}
