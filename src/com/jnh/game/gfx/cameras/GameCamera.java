package com.jnh.game.gfx.cameras;

public class GameCamera {
	
	private float aimedX;
	private float aimedY;
	private float x;
	private float y;
	private float inertia;
	
	public GameCamera(float x, float y, float inertia) {
		this.x = x;
		this.y = y;
		this.aimedX = x;
		this.aimedY = y;
		this.inertia = inertia;
	}
	
	/**
	 * Setzt die Ziel-Position zu den angegebenen Werten.
	 * @param aimedX die x-Koordinate des Ziels
	 * @param aimedY die y-Koordinate des Ziels
	 */
	public void setAimedPosition(float aimedX, float aimedY) {
		this.aimedX = aimedX;
		this.aimedY = aimedY;
	}
	
	/**
	 * Gibt den momentanen x-Wert der Kamera zur�ck.
	 * @return der x-Wert
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * Gibt den momentanen y-Wert der Kamera zur�ck.
	 * @return der y-Wert
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Setzt die Kamera-Position und <i>ohne �bergang</i> zu den angegebenen Werten.
	 * @param x die neue x-Koordinate
	 * @param y die neue y-Koordinate
	 */
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gibt die Tr�gheit der Kamera zur�ck, d.h. wie schnell sich die Kamera zu der Ziel-Position bewegt. H�here Werte bedeuten gr��ere Tr�gheit.
	 * @return die Tr�gheit
	 */
	public float getInertia() {
		return inertia;
	}
	
	/**
	 * Setzt die Tr�gheit der Kamera, d.h. wie schnell sich die Kamera zu der Ziel-Position bewegt. H�here Werte bedeuten gr��ere Tr�gheit, wobei <code>1</code> keiner Tr�gheit entspricht. Werte kleiner null sollten nicht verwendet werden.
	 * @param inertia die Tr�gheit
	 */
	public void setInertia(float inertia) {
		this.inertia = inertia;
	}
	
	
}
