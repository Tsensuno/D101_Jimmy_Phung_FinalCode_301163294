package graphics.planets;

import graphics.asteroid.AsteroidRing;
import graphics.avatar.AbstractAvatar;
import graphics.avatar.AvatarHead;
import graphics.avatar.AvatarTorso;

import java.util.ArrayList;

import processing.core.*;

// draws the general shape of the planet to be decorated and implements the collision detection with the avatar's torso
public class TorsoPlanet extends AbstractPlanets 
{
	PApplet p;
	AsteroidRing asteroid; // hold asteroid
	AbstractAvatar userTorso; // will be used for the collision detection method
	
	public TorsoPlanet(PApplet p)
	{
		this.p = p;
		asteroid = new AsteroidRing(p, 10, 620, 240, 255, 0, 255, 9); // instantiate asteroid
		position = new PVector(600, 200); // set position to bottom left corner
		velocity = new PVector(1, 1); // set hover speed
		yHigh = 175; // set the highest range for hover motion		
		yLow = 225; // set the lowest range for hover motion
		size = 80; // average size of the planet for collision detection
		userTorso = new AvatarTorso(p);  // will use the avatar's torso for collision detection
	}

	@Override
	public void draw() 
	{ // draws the planet's general shape
		
		p.fill(0, 150, 180);
		p.noStroke();
		p.pushMatrix();
			p.translate(position.x, position.y);
			p.scale(0.75f);
			p.beginShape();
				p.vertex(0, 0);
				p.vertex(54, 0);
				p.vertex(89, 34);
				p.vertex(71, 71);
				p.vertex(54, 90);
				p.vertex(35, 179);
				p.vertex(0, 196); // end of right side
				
				p.vertex(-35, 179); // start left side
				p.vertex(-54, 90);
				p.vertex(-71, 71);
				p.vertex(-89, 34);
				p.vertex(-54, 0);
			p.endShape(p.CLOSE);
		p.popMatrix();
		
		asteroid.draw(); // display asteroid	
		
		move(); // makes the planet hover
	}
}
