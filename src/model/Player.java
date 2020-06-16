package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Player {
	
	PApplet window;
	
	//Auf Public geändert damit ich von der Main Klasse darauf zugreifen kann
	public float xPosPlayer;
	public float yPosPlayer;
	public float playerSpeed;
	public float playerRadius;
	public PImage player;
	
	
	public Player(PApplet window, float xPosPlayer, float yPosPlayer, float playerSpeed, float playerRadius) {
		this.window = window;
		this.xPosPlayer = xPosPlayer;
		this.yPosPlayer = yPosPlayer;
		this.playerSpeed = playerSpeed;
		this.playerRadius = playerRadius;
	}
	
	/**
	 * Der Player wird dargestellt
	 */
	public void displayPlayer() {
		player = window.loadImage("../images/player.png");
		window.fill(255, 255, 0);
		window.imageMode(3);
		window.image(player, window.mouseX, window.mouseY, playerRadius * 2, playerRadius * 2);
		//window.ellipse(xPosPlayer, yPosPlayer, playerRadius * 2, playerRadius * 2);
		
	}
	
	
	
	/**
	 * Falls der Player an der Fenstergrenze ankommt, dann setze die Position zurück
	 */
	public void edgeDetect() {
		
		if (xPosPlayer > window.width) {
			xPosPlayer = window.width -1 ;
		}else if (xPosPlayer < -0) {
			xPosPlayer = 0;
			
			
		}
		
		if (yPosPlayer < -0) {
			yPosPlayer = 0;
		}else if (yPosPlayer > window.height) {
			yPosPlayer = window.height -1;
		}
		
		
	}
	
}
