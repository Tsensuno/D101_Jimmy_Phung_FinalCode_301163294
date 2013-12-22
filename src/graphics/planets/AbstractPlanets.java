package graphics.planets;

import graphics.avatar.AbstractAvatar;

import java.util.ArrayList;

import processing.core.*;

// this abstract class will be the template for the planets
public abstract class AbstractPlanets 
{	
	PApplet p;
	protected PVector position, velocity;
	protected int yHigh, yLow; // sets the range for the planets' hover motion
	protected int size; // will hold size of planets
	
	public abstract void draw(); // each planet will have a unique drawing
	
	public void move()
	{ // each planet, if needed, will have the same hover motion; makes the planets hover up and down
		position.y += velocity.y;
		
		if(position.y < yHigh)
		{
			velocity.y *= -1;
		}
		
		if(position.y > yLow)
		{
			velocity.y *= -1;
		}
	}
	
	public boolean objectCollision(AbstractAvatar user) 
	{ /* each planet will need a collision detection checker; 
		the parameter will be instantiated accordingly within the subclasses.
		If the distance between the user's body part and the planet is less than the size of the planet and the user...*/
		
		if(p.dist(position.x, position.y, user.position.x, user.position.y ) 
				< size + (user.size/4))
		{
			return true;
		}
		
		return false;
	}
}
