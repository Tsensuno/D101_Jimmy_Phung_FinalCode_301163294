package graphics.text;

import processing.core.*;

// holds and creates the text displays
public class Text 
{
	PApplet p;
	
	PFont titleFont; // holds the font used for the game's title
	PFont instructionFont; // holds the font used for the game's instruction
	PFont planetFont; // holds the font used for the planets' feedback text
	
	public Text(PApplet p)
	{
		this.p = p;
		
		titleFont = p.createFont("Harlow Solid Italic", 28, true); 
		instructionFont = p.createFont("Arial", 31, true);
		planetFont = p.createFont("Another Typewriter", 28, true);
	}
	
	public void introScreen()
	{ // text for the intro screen
		
		p.background(0);
		
		p.textFont(titleFont, 60);		
		p.fill(255);		
		p.textAlign(p.CENTER);		
		p.text("Body Shifter", p.width/2, 200); // displays title of game
		
		p.textFont(instructionFont, 18);
		p.textLeading(20);
		p.text("Ever wondered what you'd look like in someone else's body?", p.width/2, 300); // displays intro
		p.text("Move around with the arrow keys and see what'll change.", p.width/2, 350); // displays instructions
		p.text("Well, go on in...", p.width/2, 450); // displays prompt to play game
	}
	
	public void headPlanetFeedback()
	{ // feedback message for Planet Head
		
		p.textFont(planetFont, 28);
		p.fill(0);
		p.text("POOF!", 160, 300); // feedback text
	}
	
	public void torsoPlanetFeedback()
	{ // feedback message for Planet Torso
		
		p.textFont(planetFont, 28);
		p.fill(0);
		p.text("ZAP!", 600, 175); // feedback text
	}
}
