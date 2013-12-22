package graphics.planets;

import processing.core.PApplet;

// will add the eyes and feather to Planet Torso
public class EyesDecorator extends TorsoDecorator
{
	PApplet p;
	
	public EyesDecorator(AbstractPlanets specialPlanet, PApplet p)
	{
		super(specialPlanet);
		this.p = p;
	}
	
	public void draw()
	{
		specialPlanet.draw();
		addEyes(); // add the eyes and feather
		move(); // enable hover motion
	}
	
	private void addEyes()
	{
		p.fill(200, 200, 0);
		p.noStroke();
		
		p.pushMatrix(); // feather
			p.translate(position.x, position.y);
			p.ellipse(0, 0, 10, 50);
		p.popMatrix();
		
		p.pushMatrix(); // eyes
			p.translate(position.x - 35, position.y + 55);
			p.ellipse(0, 0, 5, 5);
		p.popMatrix();
		
		p.pushMatrix();
			p.translate(position.x + 35, position.y + 55);
			p.ellipse(0, 0, 5, 5);
		p.popMatrix();
		
		
	}
}
