package graphics.planets;

import processing.core.PApplet;

// will add the mouth to Planet Torso
public class MouthDecorator extends TorsoDecorator 
{
	PApplet p;
	
	public MouthDecorator(AbstractPlanets specialPlanet, PApplet p)
	{
		super(specialPlanet);
		this.p = p;
	}
	
	public void draw()
	{
		specialPlanet.draw(); 
		addMouth(); // display the mouth
		move(); // enable hover movement
	}
	
	private void addMouth()
	{
		p.fill(100, 0, 200);
		p.noStroke();
		p.pushMatrix();
			p.translate(position.x, position.y + 60);
			p.arc(0, 0, 20, 10, 0, p.PI);
		p.popMatrix();
	}
}
