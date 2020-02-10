package com.jnh.game.gfx.cameras;

import com.jnh.game.gameObjects.GameObject;

public class GameCamera {
	
	private GameObject centerObject;
	private float aimedX;
	private float aimedY;
	private float x;
	private float y;
	private float inertia;
	
	/**
	 * Erstellt eine neue Kamera mit den Parametern.
	 * @param x die x-Koordinate der Start-Position der Kamera
	 * @param y die y-Koordinate der Start-Position der Kamera
	 * @param inertia die Tr�gheit der Kamera
	 * @param centerObject das zu folgende Objekt (<code>null</null> f�r kein Objekt)
	 */
	public GameCamera(float x, float y, float inertia, GameObject centerObject) {
		this.x = x;
		this.y = y;
		this.aimedX = x;
		this.aimedY = y;
		this.inertia = inertia;
		this.centerObject = centerObject;
	}
	
	/**
	 * Diese Methode sollten jeden Tick aufgerufen werden und updatet die Position der Kamera.
	 * @param deltaTime die Zeit in Sekunden seit dem letzten Tick
	 */
	public void tick(double deltaTime) {
		if(centerObject != null) {
			aimedX = centerObject.getX();
			aimedY = centerObject.getY();
		}
		this.x = (this.aimedX + this.x * inertia) / (1 + inertia);
		this.y = (this.aimedY + this.y * inertia) / (1 + inertia);
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

	/**
	 * Gibt das Objekt zur�ck, dem die Kamera automatisch folgt.
	 * @return das zu folgende Objekt
	 */
	public GameObject getCenterObject() {
		return centerObject;
	}

	/**
	 * Setzt das zu folgende Objekt auf centerObject. Die Kamera wird nun automatisch die aimedPosition auf dieses Objekt setzen. Wenn das Objekt <code>null</code> ist, passiert gar nichts.
	 * @param centerObject das zu folgende Objekt
	 */
	public void setCenterObject(GameObject centerObject) {
		this.centerObject = centerObject;
	}
	
	
}
