package graphics.planets;
import processing.core.PVector;

// Maintains a reference to the Component object (TorsoPlanet) and also extends the Component's functions 
public class TorsoDecorator extends AbstractPlanets 
{
	protected AbstractPlanets specialPlanet;
	
	public TorsoDecorator(AbstractPlanets specialPlanet)
	{
		this.specialPlanet = specialPlanet;
		position = new PVector(600, 200); // set position to bottom left corner
		velocity = new PVector(1, 1);
		yHigh = 175; // set highest range of hover motion
		yLow = 225; // set lowest range of hover motion
	}

	@Override
	public void draw() 
	{
		specialPlanet.draw();		
	}

}
