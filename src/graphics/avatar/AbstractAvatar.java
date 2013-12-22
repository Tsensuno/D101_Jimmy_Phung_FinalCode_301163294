package graphics.avatar;

import processing.core.*;

// this abstract class will be the template for each of the avatar's body part classes
public abstract class AbstractAvatar extends PApplet
{
	PApplet p;	
	public int size = 50; // holds the average size of body parts for collision detection
	public PVector position, velocity; // position is for where to translate the objetcs; velocity for hovering movement
	
	public AbstractAvatar(PApplet p)
	{
		this.p = p;
		
		position = new PVector(400, 300); // set position to center of screen
		velocity = new PVector(2, 2); // set velocity to 2		
	}

	public abstract void draw(); // each drawing will be custom to the subclasses
	
	public void moveRight() // each subclass will need the same inherited movement
	{
		if(velocity.x < 0) // move right if velocity less than 0
		{
			velocity.x *= -1;
		}
		position.x += velocity.x;
	}
	
	public void moveLeft() // move left if velocity more than 0
	{
		if(velocity.x > 0)
		{			
			velocity.x *= -1;			
		}			
		position.x += velocity.x;

	}
	
	public void moveUp()
	{
		position.y -= velocity.y;
	}
	
	public void moveDown()
	{
		position.y += velocity.y;
	}
}
