package graphics.stars;
import main.Main;
import processing.core.*;

// used for factory design pattern; Main class (the client) will ask this creator for a star fractal 
public abstract class StarCreator 
{
	Main p;
	
	StarCreator(Main p)
	{
		this.p = p;
	}
	
	public abstract AbstractStarTimeObject createStar(int type); // used to instantiate star fractals
}
