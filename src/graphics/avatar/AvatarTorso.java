package graphics.avatar;

import processing.core.PApplet;

//This class draws the different torsos that the avatar can have
public class AvatarTorso extends AbstractAvatar
{
	public AvatarTorso(PApplet p) 
	{
		super(p);
	}

	public void draw() 
	{ // default torso
		
		p.fill(0);
		p.pushMatrix();
			p.translate(position.x + 9, position.y + 18);
			p.beginShape(); 	
				p.curveVertex(26, 0); 
				p.curveVertex(26, 0); 
				p.curveVertex(27, 134); 
				p.curveVertex(-26, 134); 
				p.curveVertex(-27, 4); 
				p.curveVertex(-27, 4); 
			p.endShape();	
		p.popMatrix();
	}
	
	public void drawOctopusTorso()
	{ // octopus torso
		
		p.noStroke();		
		p.fill(0, 255, 255);
		p.pushMatrix();
			p.translate(position.x + 9, position.y + 20);
			p.beginShape();
				p.vertex(26, 0);
				p.vertex(35, 54);
				p.vertex(71, 89);
				p.vertex(89, 71);
				p.vertex(72, 53);
				p.vertex(71, 70);
				p.vertex(53, 34);
				p.vertex(107, 70);
				p.vertex(71, 107);
				p.vertex(35, 89);
				p.vertex(71, 143);
				p.vertex(89, 143);
				p.vertex(108, 125);
				p.vertex(107, 107);
				p.vertex(89, 125);
				p.vertex(108, 89);
				p.vertex(125, 124);
				p.vertex(89, 162);
				p.vertex(72, 161);
				p.vertex(17, 107);
				p.vertex(53, 197);
				p.vertex(89, 197);
				p.vertex(107, 179);
				p.vertex(89, 178);
				p.vertex(125, 160);
				p.vertex(108, 197);
				p.vertex(71, 216);
				p.vertex(35, 198);
				p.vertex(17, 179);
				p.vertex(0, 125); // end of right side
				
				p.vertex(-17, 179); // start of mirrored right side
				p.vertex(-35, 198);
				p.vertex(-71, 216);
				p.vertex(-108, 197);
				p.vertex(-125, 160);
				p.vertex(-89, 178);
				p.vertex(-107, 179);
				p.vertex(-89, 197);
				p.vertex(-53, 197);
				p.vertex(-17, 107);
				p.vertex(-72, 161);
				p.vertex(-89, 162);
				p.vertex(-125, 124);
				p.vertex(-108, 89);								
				p.vertex(-89, 125);
				p.vertex(-107, 107);
				p.vertex(-108, 125);
				p.vertex(-89, 143);
				p.vertex(-71, 143);
				p.vertex(-35, 89);
				p.vertex(-71, 107);
				p.vertex(-107, 70);
				p.vertex(-53, 34);
				p.vertex(-71, 70);
				p.vertex(-72, 53);
				p.vertex(-89, 71);
				p.vertex(-71, 89);			
				p.vertex(-35, 54);
				p.vertex(-26, 0);
			p.endShape(p.CLOSE);
		p.popMatrix();
	}
	
	public void drawMermaidTorso()
	{ // mermaid torso
		
		p.noStroke();	
		p.fill(255, 255, 0);
		p.pushMatrix();
			p.translate(position.x + 9, position.y + 20);
			p.beginShape();
				p.vertex(26, 0);
				p.vertex(53, 71);
				p.vertex(53,  124);
				p.vertex(35, 179);
				p.vertex(17, 216);
				p.vertex(17, 232);
				p.vertex(35, 251);
				p.vertex(53, 250);
				p.vertex(70, 232);
				p.vertex(53, 215);
				p.vertex(53, 170);
				p.vertex(71, 160);
				p.vertex(71, 142);
				p.vertex(89, 160);
				p.vertex(89, 233);
				p.vertex(143, 233);
				p.vertex(161, 251);
				p.vertex(143, 251);
				p.vertex(125, 269);
				p.vertex(107, 269);
				p.vertex(89, 251);
				p.vertex(71, 269);
				p.vertex(35, 287);
				p.vertex(0, 268); // end right side of mermaid tail
				
				p.vertex(-17, 232); // start left side		
				p.vertex(-35, 179);
				p.vertex(-53,  124);
				p.vertex(-53, 71);
				p.vertex(-26, 0);
			p.endShape(p.CLOSE);
		p.popMatrix();
	}
}
