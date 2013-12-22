package graphics.stars;

import main.Main;
import processing.core.*;

// abstract class as the template for the star fractals based on hours and minutes
public abstract class AbstractStarTimeObject 
{
	public Main p;
	public PVector position; // will hold stars' location
	public int objectColour; // used to hold object's colour	
	public int objectStoredTime; // used to store when the object was created
	public boolean addedRecursiveObject; // used to check if recursion had occurred
		
	public abstract void update();
	
	public abstract void drawMe();
}
