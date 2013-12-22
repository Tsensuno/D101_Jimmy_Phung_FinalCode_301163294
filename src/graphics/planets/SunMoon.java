package graphics.planets;

import graphics.avatar.AbstractAvatar;
import graphics.avatar.AvatarHead;

import java.util.ArrayList;

import processing.core.*;

// draws the sun and moon, and implements its collision detection with the avatar's head 
public class SunMoon extends AbstractPlanets 
{
	PApplet p;
	AbstractAvatar userHead; // will be used for the collision detection method
	
	public SunMoon(PApplet p)
	{
		this.p = p;
		position = new PVector(100, 100); // sets its position to the top right corner
		size = 40; // holds average size of the sun and moon for collision detection
		userHead = new AvatarHead(p); // will use the avatar's head for collision detection
	}

	@Override
	public void draw() 
	{ // the sun
		
		p.fill(255, 100, 0);
		p.pushMatrix();
			p.translate(70, 50);
			p.scale(0.75f);
			p.beginShape();
				p.vertex(0, 0);
				p.vertex(17, 35);
				p.vertex(53, 17);
				p.vertex(36, 53);
				p.vertex(71, 70); 
				p.vertex(35, 88);
				p.vertex(53, 124); 
				p.vertex(17, 107);
				p.vertex(0, 141); // end right side
				
				p.vertex(-17, 107); // start left side
				p.vertex(-53, 124); 
				p.vertex(-35, 88);
				p.vertex(-71, 70); 
				p.vertex(-36, 53);
				p.vertex(-53, 17);
				p.vertex(-17, 35);
			p.endShape(p.CLOSE);
		p.popMatrix();
	}
	
	public void drawMoon()
	{ // the moon
		
		p.fill(0, 100, 255);
		p.pushMatrix();
			p.translate(30, -10);
			p.scale(0.75f);
			p.beginShape();
				p.vertex(73, 144);
				p.vertex(107, 125);
				p.vertex(107, 108);
				p.vertex(89, 89);
				p.vertex(35, 89); 
				p.vertex(0, 124);
				p.vertex(0, 179); 
				p.vertex(35, 215);
				p.vertex(89, 215);
				p.vertex(107, 196);
				p.vertex(107, 178);
				p.vertex(89, 196);
				p.vertex(70, 196);
				p.vertex(35, 162);
				p.vertex(35, 144);
				p.vertex(53, 107);
				p.vertex(71, 107);
				p.vertex(89, 125);
			p.endShape(p.CLOSE);
		p.popMatrix();
	}
}
