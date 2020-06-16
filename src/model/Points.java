package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Points {
	
	PApplet window;
	
	//Auf Public geändert damit ich von der Main Klasse darauf zugreifen kann
	public float xPosPoint;
	public float yPosPoint;
	public float pointRadius;
	public float pointSpeedX;
	public float pointSpeedY;
	public PImage planet;
	
	public Points(PApplet window, float xPosPoint, float yPosPoint, float pointRadius, float pointSpeedX, float pointSpeedY) {
		this.window = window;
		this.xPosPoint = xPosPoint;
		this.yPosPoint = yPosPoint;
		this.pointRadius = pointRadius;
		this.pointSpeedX = pointSpeedX;
		this.pointSpeedY = pointSpeedY;
	}
	
	
		/**
		 * Der Planet wird dargestellt
		 */
		public void displayPoints() {
		planet = window.loadImage("../images/planet.png");
		window.fill(255, 0, 0);
		window.image(planet,xPosPoint, yPosPoint, pointRadius * 2, pointRadius * 2);
		
		
	}
	/**
	 * Falls der Planet die Kante erreicht, dann setze die Position zurück
	 */
		public void movementPoint() {
			xPosPoint += pointSpeedX;
			yPosPoint += pointSpeedY;
			
			if (xPosPoint > window.width || xPosPoint < 0) {
				pointSpeedX = pointSpeedX * -1;
			} 
			if (yPosPoint > window.height || yPosPoint < 0) {
				pointSpeedY = pointSpeedY * -1;
				
			}
			
		}
	
	

}
