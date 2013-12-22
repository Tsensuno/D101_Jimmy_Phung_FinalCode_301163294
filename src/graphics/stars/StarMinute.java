package graphics.stars;

import main.Main;

// Used for factory design pattern; will create star chains according to the current minute (the product)
public class StarMinute  extends AbstractStarTimeObject
{
	float theta; // rotation angle for next star
	int recursionCount;
	float xNoise, yNoise; // holds noise values
	int positionX = 0; // X location for drawing
	int positionY = -50; // Y location for drawing
	
	public StarMinute(Main p)
	{
		this.p = p;
		theta = p.PI/6; // how much we want to rotate the next stars
		
		recursionCount = 0;
		
		xNoise = p.random(10);
		yNoise = p.random(10);
	}
	
	public void update()
	{
		recursionCount = p.minute() % 6 + 1; //every 6 minutes set back to one, we want to see at least 1 star
	}
	public void drawMe()
	{
		star(20);
	}
	void star(float size)
	{
		p.translate((p.noise(xNoise)), (p.noise(yNoise) * 25) -size); //this creates chains instead of one messy overlay
		
		p.scale(0.66f);// shrinks star
		
		// changing colours
		objectColour = p.color(0, p.random(128, 255), p.random(128, 255), p.random(100, 200));
		p.fill(objectColour);
		
		p.strokeWeight(2);
		p.stroke(126 + p.hour() *126/24);
		
		// draw star shape
		p.beginShape();
			p.vertex(positionX, positionY);
			p.vertex(positionX +14, positionY +30);
			p.vertex(positionX +47, positionY + 35);
			p.vertex(positionX +23, positionY + 57);
			p.vertex(positionX +29, positionY + 90);
			p.vertex(positionX, positionY + 75);
			p.vertex(positionX-29, positionY + 90);
			p.vertex(positionX-23, positionY + 57);
			p.vertex(positionX-47, positionY + 35);
			p.vertex(positionX-14, positionY +30);
		p.endShape(p.CLOSE);		
		
		//shrink next stars by two thirds
		size *= 0.66;
		xNoise += 0.01;
		yNoise += 0.01;
		
		if( size> 100 * p.pow(0.66f,  recursionCount))
		{
			//subsequent calls to star() include size
			p.pushMatrix(); // right star
				p.rotate(theta);
				positionX += 500;
				positionY += 200;				
				star(size);
			p.popMatrix();
			
			p.pushMatrix(); // left star
				p.rotate(-theta);
				positionX -= 500;
				positionY -= 200;
				star(size);
			p.popMatrix();
			}
		}		
	}

