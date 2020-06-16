package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Asteroids {
	
	private static final int CENTER = 0;
	PApplet window;
	public float asteroidXPos;
	public float asteroidYPos;
	public float asteroidSpeedX;
	public float asteroidSpeedY;
	public float asteroidRadius;
	public PImage asteroid;
	
	public Asteroids(PApplet window, float asteroidXPos, float asteroidYPos, float asteroidSpeedX, float asteroidSpeedY, float asteroidRadius) {
		this.window = window;
		this.asteroidXPos = asteroidXPos;
		this.asteroidYPos = asteroidYPos;
		this.asteroidSpeedX = asteroidSpeedX;
		this.asteroidSpeedY = asteroidSpeedY;
		this.asteroidRadius = asteroidRadius;
	}
	
	/**
	 * Die Asteroiden werden hier dargestlellt
	 */
	public void displayAsteroid() {
		
		asteroid = window.loadImage("../images/asteroid.png");
		
		
		window.image(asteroid,asteroidXPos, asteroidYPos, asteroidRadius * 2, asteroidRadius * 2);
		asteroidMovement();
		window.fill(255);
		
		
		
	}
	
	
	/**
	 * Die Bewegung der Asteroiden und die Grenzen im Fenster werden erstellt
	 */
	public void asteroidMovement() {
		
		
		asteroidXPos += asteroidSpeedX; 
		asteroidYPos += asteroidSpeedY; 
		
		if (asteroidXPos > window.width || asteroidXPos < 0) {
			asteroidSpeedX = asteroidSpeedX * -1;
		} 
		if (asteroidYPos > window.height || asteroidYPos < 0) {
			asteroidSpeedY = asteroidSpeedY * -1;
			
		}
		
		
		
	}

}
