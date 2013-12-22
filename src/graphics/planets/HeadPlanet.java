package graphics.planets;

import graphics.asteroid.AsteroidRing;
import graphics.avatar.AbstractAvatar;
import graphics.avatar.AvatarHead;

import java.util.ArrayList;

import controlP5.Println;
import processing.core.*;

// draws the planet and implements the collision detection with the avatar's head 
public class HeadPlanet extends AbstractPlanets
{
	PApplet p;
	
	// variable for the asteroid	
	AsteroidRing asteroid;	
	AbstractAvatar userHead; // will be used for the collision detection method
	
	public HeadPlanet(PApplet p)
	{
		this.p = p;
		asteroid = new AsteroidRing(p, 10, 150, 400, 255, 255, 0, 5); // instantiates the asteroid
		position = new PVector(100, 400); // set position to bottom left corner
		velocity = new PVector(0.5f, 0.5f); // set speed of hovering
		yHigh = 375; // set the highest range for hover motion		
		yLow = 425; // set the lowest range for hover motion	
		size = 100; // size of the planet
		userHead = new AvatarHead(p); // will use the avatar's head for collision detection
	}

	public void draw() 
	{ // draws planet
		
		p.noStroke();
		
		// general shape of planet
		p.fill(178, 28, 68);
		p.beginShape();
			p.curveVertex(position.x, position.y);
			p.curveVertex(position.x, position.y);
			p.curveVertex(position.x + 20, position.y - 75);
			p.curveVertex(position.x + 100, position.y - 50);
			p.curveVertex(position.x + 90, position.y + 25);
			p.curveVertex(position.x + 20, position.y + 50);
			p.curveVertex(position.x, position.y + 10);
			p.curveVertex(position.x, position.y + 10);
		p.endShape(p.CLOSE);
		
		// eyes
		p.fill(255); // sclera
		p.ellipse(position.x + 40, position.y, size/3, size/4);
		p.ellipse(position.x + 90, position.y - 10, size/6, size/8);
		p.fill(0); // pupils 
		p.ellipse(position.x + 45, position.y, size/6, size/8);
		p.ellipse(position.x + 95, position.y - 10, size/12, size/16);
		
		asteroid.draw(); // display asteroid
	}
}