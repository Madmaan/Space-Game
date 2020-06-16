package main;

import model.Asteroids;
import model.Player;
import model.Points;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PApplet.main("main.Main");
	}
	
	
	Player p1;
	Points s1;
	Asteroids a1;
	int score = 0;
	int gamestate = 0;
	float distance;
	float sumRadius;
	float sumRadiusAsteroid;
	float[] distanceAsteroid = new float[5];
	PImage bg;
	PImage panel;
	int newScore;
	
	Asteroids[] asteroid = new Asteroids[5];
	
	
	
	public void settings() {		
		bg = loadImage("../images/space_background.png");
		size(1000, 800);
		for (int i = 0; i < asteroid.length; i++) {
			asteroid[i] = new Asteroids(this, random(100,900), random(100,700), 15, 15, 70);
			
			
		}
		
		p1 = new Player(this, 40, 400, 10, 40);
		s1 = new Points(this, random(10,900),random(10, 700), 35,random(1,5), random(1,5));	
		
		
	}
	
	public void setup() {
		frameRate(144);
	}
	
	
	/**
	 * Hier werden die gamestates bestimmt
	 */
	public void draw() {
		
		println(gamestate);
		
		if (gamestate == 0) {
			startScreen();
		}
		if (gamestate ==1) {
			gameScreen();
		}
		if (gamestate ==2) {
			
			gameOverScreen();
			
		}if (keyPressed) {
				if (key == 'r' || key == 'R') {
					gamestate = 1;
					
				}
		}
		
	}
	
	
	/**
	 * Zeigt die Punkteanzahl an
	 */
	public void displayScore() {
		textSize(25);
		fill(255);
		textAlign(CENTER);
		text("Your Score is "+score, 100, 35);
		
	}
	
	
	/**
	 * Startbildschirm
	 */
	public void startScreen() {
		background(0);
		textAlign(CENTER);
		textSize(30);
		text("Press Mouse Button to Start", width/2, height/2);
	}
	
	/**
	 * Hier wird alles gezeichnet, das Spiel läuft hier
	 */
	public void gameScreen() {
		s1.movementPoint();
		background(bg);
		s1.displayPoints();
		p1.displayPlayer();
		
		
		displayScore();
		distance();
		p1.edgeDetect();
		
		for (int i = 0; i < asteroid.length; i++) {
			asteroid[i].displayAsteroid();
		}
			
	}
	
	
	/**
	 * Endbildschirm falls man von einem Komet gertroffen wird
	 */
	public void gameOverScreen() {
		
		background(0);
		panel();
		fill(255);
		textSize(30);
		textAlign(CENTER);
		text("Game Over, press R to restart",width/2,height/2);
		text("Your Score is "+newScore, width / 2 , 480);
		
		
		
		}
	
	/**
	 * Panel für den Endscreen wird geladen
	 */
	public void panel() {
		rectMode(CENTER);
		
		panel = loadImage("../images/panel.png");
		image(panel, width / 2, height /2, 600,300);
	}
		
	
	/**
	 * wechselt in den Spielstatus falls Maustaste gedruckt wurde
	 */
	public void mouseClicked() {
		if (gamestate == 0) {
		gamestate = 1;
		}
	}
	
	
	
	/**
	 * Hier wird die Distantz vom mittelpunk bis zum Mittel Punkt des Players berechnet, falls die 
	 * Distanz kleiner ist als die Summer beider Radien(Asteroid und Player)
	 * dann verliert da beide Objekte kollidieren
	 */
	

	public void distance() {
		
		sumRadius = p1.playerRadius + s1.pointRadius;
		
		for (int i = 0; i < asteroid.length; i++) {
			sumRadiusAsteroid = p1.playerRadius + asteroid[i].asteroidRadius -20 ;
			}
		
		distance = dist(mouseX, mouseY, s1.xPosPoint, s1.yPosPoint);
		
		for (int i = 0; i < asteroid.length; i++) {
		distanceAsteroid[i] = dist(mouseX, mouseY, asteroid[i].asteroidXPos, asteroid[i].asteroidYPos);
		}
		
		
			for (int i = 0; i < asteroid.length; i++) 
				
				//restars the game by calling settings
				if (distanceAsteroid[i] < sumRadiusAsteroid) {
					gamestate = 2; 
					settings();
					score = 0;
					
					
			}
			
			if (distance < sumRadius) {
			addScore();
			//s1.newPoint();
		}
		
	}
	
	/**
	 *Der Score wird hinzugefügt 
	 */
	public void addScore() {
		newScore = score += 1;
		
	}
	
}
