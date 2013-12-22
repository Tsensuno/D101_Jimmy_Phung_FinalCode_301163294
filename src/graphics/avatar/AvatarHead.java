package graphics.avatar;

import processing.core.PApplet;

// this class draws the different heads that the avatar can have
public class AvatarHead extends AbstractAvatar 
{
	public AvatarHead(PApplet p) 
	{
		super(p);		
	}
	
	public void draw() 
	{ // default head
		
		p.noStroke();
		
		// head
		p.fill(0);		
		p.pushMatrix();
		p.translate(position.x + 9, position.y + 16);
			p.beginShape(); 	
				p.curveVertex(26, 0); 
				p.curveVertex(26, 0); 
				p.curveVertex(27, -74); 
				p.curveVertex(-28, -72); 
				p.curveVertex(-27, 4); 
				p.curveVertex(-27, 4); 
			p.endShape();	
		p.popMatrix();
		
		// eyes
		p.fill(255);
		p.pushMatrix();
			p.translate(position.x, position.y);
			p.ellipse(0, 0, 10, 10);
		p.popMatrix();
		
		p.pushMatrix();
			p.translate(position.x + 15, position.y);
			p.ellipse(0, 0, 8, 8);
		p.popMatrix();
	}
	
	public void drawCatHead()
	{ // cat head
	
		p.noStroke();	
		
		// head
		p.fill(255, 100, 0);
		p.pushMatrix();
			p.translate(position.x + 9, position.y - 100);
			p.beginShape();
				p.vertex(0, 16);
				p.vertex(34, 16);
				p.vertex(71, 0);
				p.vertex(71, 34);
				p.vertex(53, 53);
				p.vertex(71, 88);
				p.vertex(53, 88);
				p.vertex(71, 106);
				p.vertex(35,  106);
				p.vertex(26, 116);// end of right side
				
				p.vertex(-26, 116);	// start of left side			
				p.vertex(-35,  106);				
				p.vertex(-71, 106);
				p.vertex(-53, 88);				
				p.vertex(-71, 88);
				p.vertex(-53, 53);
				p.vertex(-71, 34);
				p.vertex(-71, 0);
				p.vertex(-34, 16);
			p.endShape(p.CLOSE);
		p.popMatrix();
		
		// eyes
		p.pushMatrix();
			p.translate(position.x - 20, position.y - 20);
			p.rotate(p.PI/4);
			p.fill(0, 176, 53);
			p.ellipse(0, 0, 50, 25);
			p.fill(102, 255, 0);
			p.ellipse(0, 0, 25, 17);
		p.popMatrix();
		
		p.pushMatrix();
			p.translate(position.x + 40, position.y - 20);
			p.rotate(-p.PI/4);
			p.fill(0, 176, 53);
			p.ellipse(0, 0, 50, 25);
			p.fill(102, 255, 0);
			p.ellipse(0, 0, 25, 17);
		p.popMatrix();
	}
	
	public void drawGeishaHead()
	{ // geisha head
		
		// head
		p.noStroke();	
		p.fill(255);
		p.pushMatrix();
			p.translate(position.x + 10, position.y - 100);
			p.scale(0.75f);
			p.beginShape();
				p.vertex(0, 0);
				p.vertex(37, 0);
				p.vertex(54, 16);
				p.vertex(72, 53);
				p.vertex(89, 70);
				p.vertex(90, 107);
				p.vertex(53, 143);
				p.vertex(0, 141); // end right side
				
				p.vertex(-53, 143); // start left side
				p.vertex(-90, 107);
				p.vertex(-89, 70);
				p.vertex(-72, 53);
				p.vertex(-54, 16);
				p.vertex(-37, 0);
			p.endShape(p.CLOSE);
		p.popMatrix();
		
		// comb
		p.fill(255, 0, 0);
		p.pushMatrix();
			p.translate(position.x + 10, position.y - 150);
			p.scale(0.75f);
			p.beginShape();
				p.vertex(0, 0);
				p.vertex(18, 0);
				p.vertex(35, 17);
				p.vertex(18, 52);
				p.vertex(35, 70);
				p.vertex(53, 35);
				p.vertex(53, 52);
				p.vertex(17, 72);
				p.vertex(0, 71); // end right side
				
				p.vertex(-17, 72); // start left side
				p.vertex(-53, 52);
				p.vertex(-53, 35);
				p.vertex(-35, 70);
				p.vertex(-18, 52);
				p.vertex(-35, 17);
				p.vertex(-18, 0);
			p.endShape(p.CLOSE);
		p.popMatrix();
		
		// blush
		p.pushMatrix(); // right blush 
			p.translate(position.x - 30, position.y - 25);
			p.ellipse(0, 0, 20, 20);
		p.popMatrix();
		
		p.pushMatrix(); // left blush
			p.translate(position.x + 50, position.y - 25);
			p.ellipse(0, 0, 20, 20);
		p.popMatrix();
		
		// eyes
		p.stroke(0); 
		p.strokeWeight(5);
		p.pushMatrix();	// right eye
			p.translate(position.x - 25, position.y - 50);
			p.line(0, 0, 20, 20);
		p.popMatrix();
		
		p.pushMatrix(); // left eye
			p.translate(position.x + 25, position.y - 30);
			p.scale(1, -1);
			p.line(0, 0, 20, 20);
		p.popMatrix();
	
		p.noStroke(); // stops stroke so that any other objects that appears after this won't have an unwanted stroke
	}

}
