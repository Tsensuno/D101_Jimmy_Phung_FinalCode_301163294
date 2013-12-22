package graphics.asteroid;

import processing.core.*;

// draws the generative art asteroids circling the planets
public class AsteroidRing extends PApplet
{
	PApplet p;
	
	float radius = 100; // rotation radius
	float ang = 0; // starting angle of asteroid's path
	int translateX; // variable to hold the X coordinate for translation
	int translateY; // variable to hold the Y coordinate for translation
	float x, y; // holds the coordinates of the starting angle
	float lastx; // holds the last angle's X coordinates
	float lasty; // holds the last angle's Y coordinates
	int strokeWeight; // stroke weight value
	float strokeColour1, strokeColour2, strokeColour3; // sets stroke colour
	int angSpeed; // speed of rotation

	public AsteroidRing(PApplet p, int strokeWeight, int translateX, int translateY, 
			float strokeColour1, float strokeColour2, float strokeColour3, int angSpeed)
	{
		this.p = p;
		lastx = radius * p.cos(p.radians(5));
		lasty = radius * p.sin(p.radians(5)); 
		this.strokeWeight = strokeWeight;
		this.translateX = translateX;
		this.translateY = translateY;
		this.strokeColour1 = strokeColour1;
		this.strokeColour2 = strokeColour2;
		this.strokeColour3 = strokeColour3;
		this.angSpeed = angSpeed;
	}
	
	public void draw()
	{
		p.stroke(strokeColour1, strokeColour2, strokeColour3);
		p.strokeWeight(strokeWeight); 
		p.smooth(); 
		if(ang <= 360) // if the starting angle of rotation is less than a full circle, rotate it
		{ 
			float rad = p.radians(ang); 

			p.pushMatrix(); 
			p.translate(translateX, translateY); 
			x = radius*p.cos(rad); 
			y = radius*p.sin(rad); 
			p.line(x, y, lastx, lasty); 
			p.popMatrix(); 

			lastx = x; 
			lasty = y; 
			ang += angSpeed;
		} 
		
		if(ang == 360) // if it reaches a full circle, restart its rotation
		{ 
			ang = 0; 
		} 
	}
}
