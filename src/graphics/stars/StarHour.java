package graphics.stars;

import main.Main;

// Used for factory design pattern; will create the star fractals according to the current hour (the product)
public class StarHour extends AbstractStarTimeObject
{
	StarMinute starObject;
	float translateX; // X position for translation
	float translateY; // Y position for translation
	
	public StarHour(Main p, int objectInputTime)
	{
		this.p = p;
		objectStoredTime = objectInputTime; // stores the time that the object was created
		starObject = new StarMinute(p); // instantiates stars
		translateX = p.random(p.width); // translate to a random X position within the screen
		translateY = p.random(p.height); // translate to a random Y position within the screen
	}
	public void update()
	{
		if(p.hour() % 12 > objectStoredTime && addedRecursiveObject == false )
		{
			addedRecursiveObject = true;
			p.starhour_arraylist.add(new StarHour(p, objectStoredTime + 1));
		}
		
		if(addedRecursiveObject == true)
		{
			starObject.recursionCount = 6;
		}
		else
		{
			starObject.update();
		}
	}
	public void drawMe()
	{
		p.pushMatrix();		
			p.translate(translateX, translateY);
			starObject.drawMe(); // display the stars
		p.popMatrix();
	}
}
