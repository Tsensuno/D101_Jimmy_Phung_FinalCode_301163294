package main;

import graphics.stars.StarConcreteCreator;
import graphics.stars.StarCreator;
import graphics.avatar.AvatarHead;
import graphics.avatar.AvatarTorso;
import graphics.planets.AbstractPlanets;
import graphics.planets.EyesDecorator;
import graphics.planets.HeadPlanet;
import graphics.planets.MouthDecorator;
import graphics.planets.SunMoon;
import graphics.planets.TorsoPlanet;
import graphics.stars.StarHour;
import graphics.text.Text;

import java.util.ArrayList;

import controlP5.Button;
import controlP5.ControlEvent;
import controlP5.ControlP5;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.*;

public class Main extends PApplet
{	
	// track if applet has started
	boolean startApplet; 
	
	// play button
	ControlP5 controlP5;
	Button playButton;
	
	// Arrow keys mapping variables
	boolean rightKey, leftKey, upKey, downKey;

	// variable to instantiate texts
	Text txt = new Text(this); 
	
	// sound variables for feedback effects and ambient music
	Minim minim;
	AudioPlayer sound;
	FFT fft;
	
	// Background variables
	PImage atmosphere,landscape; 
	
	// star fractal variables
	public ArrayList starhour_arraylist; // factory; will hold amount of stars
	int starAmount = hour() % 12; // sets the amount of stars to the current hour in AM/PM time
	
	// Interactive object variables
	
		// Head Planet
			HeadPlanet headPlanet = new HeadPlanet(this); // used to call HeadPlanet's methods
			
		// Sun and Moon 	
			SunMoon sunMoon = new SunMoon(this); // used to call SunMoon's methods
			boolean daytime; // tracks if it is daytime/nighttime
			int sun_moon = 0; // integer to hold sun/moon drawing type 
			
		// Torso Planet
			AbstractPlanets torsoPlanetDeco = new EyesDecorator(new MouthDecorator(new TorsoPlanet(this), this), this); // decorator instantiation
			TorsoPlanet torsoPlanet = new TorsoPlanet(this); // used to call TorsoPlanet's methods
			
		/* will be used to keep track of when the avatar is colliding with other objects; 
		to stop the algorithms from continuously looping;
		when it is = 0, it has the potential to collide; otherwise, it does not*/
			int collisionPotential = 0; 
	
	// Avatar variables
			
		boolean fullBodiedAvatarCreated; // track if all of the avatar's body parts are drawn
	
		// avatar's head	
			AvatarHead head = new AvatarHead(this); // will be used to call avatar's head methods
			boolean headless; // tracks if the avatar is headless
			int headType = 0; // used to track which head to draw: 0 = default, 1 = cat, 2 = geisha
			
		// avatar's torso
			AvatarTorso torso = new AvatarTorso(this); // will be used to call avatar's torso methods
			boolean torsoless; // tracks if the avatar is torsoless
			int torsoType = 0; // used to track which torso to draw: 0 = default, 1 = octopus, 2 = mermaid
	
	public void setup()
	{
		// load ambient music codes
		minim = new Minim(this);
		sound = minim.loadFile("../sounds/209315__unfa__space-ambient-music-2013-11-30.mp3", 2048);
		sound.loop();
		fft = new FFT(sound.bufferSize(), sound.sampleRate());
		
		// Background images codes
		atmosphere = loadImage("../pics/Final BG Clouds.png");
		landscape = loadImage("../pics/Final BG Hills.png");
		
		try
		{
			atmosphere = loadImage("../pics/Final BG Clouds.png");		
		}
		catch(NullPointerException e)
		{
			println("There is an error with your image file." + e);
		}
		
		// screen size
		size(atmosphere.width, atmosphere.height); // set screen size to dimensions of the image
		smooth();
		
		// game states
		startApplet = true; // applet has been started
		fullBodiedAvatarCreated = false; // the avatar has not been created yet because currently viewing the intro screen
		
		// play button
		controlP5 = new ControlP5(this);		
		playButton = controlP5.addButton("play", 1, width/2 -15 , 475, 30, 25);	// displays the "play" button	
		playButton.setColorCaptionLabel(color(0));
		playButton.setColorBackground(color(0, 255, 0));
		
		// factory instantiation
		starhour_arraylist = new ArrayList <StarHour>();	
		StarCreator starCreator = new StarConcreteCreator(this);
		
		for(int i = 0; i < starAmount; i++)
		{
			starhour_arraylist.add(starCreator.createStar(1));
		}
	}
	
	public void draw()
	{
		background(atmosphere); // use atmosphere image as the background
		
		image(landscape, 0, 0); // place the landscape on top of the background
		
		// display Planet Head
		headPlanet.draw(); 
		headPlanet.move();	
		
		// display Planet Torso
		torsoPlanetDeco.draw();
		torsoPlanet.move(); 
		torsoPlanet.objectCollision(torso);
		
		if(startApplet) // if applet has started, 
		{
			txt.introScreen(); // display intro screen
			controlP5.getController("play").show(); // and show "play" button			
		}
		else // in play mode
		{
			playGame();
			controlP5.getController("play").hide();
		}
	}
	
	public void controlEvent(ControlEvent theEvent)
	{ // event handler for if the "play" button is pressed
		
		if(theEvent.getController().getName()=="play")
		{
			playGame();
			startApplet = false; // now in play mode
			fullBodiedAvatarCreated = true; // avatar has been drawn
			daytime = true; // it is daytime
		}
	}
	
	void playGame()
	{
		// calls avatar's head and torso key based movement
		if(rightKey)
		{
			head.moveRight();
			torso.moveRight();	
		}
		
		if(leftKey)
		{
			head.moveLeft();
			torso.moveLeft();	
		}
		
		if(upKey)
		{
			head.moveUp();
			torso.moveUp();
		}
		
		if(downKey)
		{
			head.moveDown();
			torso.moveDown();
		}
		
		headSwapper(); // swap head depending on conditions
		sunMoonSwapper();// swap day and night depending on conditions	
		torsoSwapper(); // swap torso depending on conditions
	}
	
	public void keyPressed()
	{ // keys pressed for avatar movement
		
		if(key == CODED && keyCode == RIGHT)
		{
			rightKey = true;
		}
		
		if(key == CODED && keyCode == LEFT)
		{
			leftKey = true;
		}
		
		if(key == CODED && keyCode == UP)
		{
			upKey = true;
		}
		
		if(key == CODED && keyCode == DOWN)
		{
			downKey = true;
		}
		
	}
	
	public void keyReleased()
	{ // keys released for avatar movement
		
		if(key == CODED && keyCode == RIGHT)
		{
			rightKey = false;
		}
		
		if(key == CODED && keyCode == LEFT)
		{
			leftKey = false;
		}
		
		if(key == CODED && keyCode == UP)
		{
			upKey = false;
		}
		
		if(key == CODED && keyCode == DOWN)
		{
			downKey = false;
		}		
	}
	
	
	public void headSwapper()
	{ // head swapping method based on avatar's head colliding with Planet Head
		
		if(fullBodiedAvatarCreated) 
		/* so if the avatar has all its body parts, 
		display it depending on the random type chosen; draws the associated head type*/ 
		{
			if(headType == 2) // draw geisha head
			{
				head.drawGeishaHead();
			}
			else if(headType == 1)// draw cat head
			{
				head.drawCatHead();
			}
			else // draw default head
			{
				head.draw();
			}
			
			headless = false; // the avatar has a head
		}
		
		if(headPlanet.objectCollision(head) && collisionPotential == 0) 
		{ // when the avatar collides with the Planet Head and it has the potential to collide,
			
			collisionPotential++; // turn off its potential to collide to stop it from continuously looping
			
			headless = true; // remove its head; the avatar is now headless
			fullBodiedAvatarCreated = false; // thus it no longer has all its body parts
			txt.headPlanetFeedback(); // display feedback text "POOF!"
			
			minim = new Minim(this); // and also display feedback sound 
			sound = minim.loadFile("../sounds/55853__sergenious__teleport.mp3", 2048);
			sound.play();
			fft = new FFT(sound.bufferSize(), sound.sampleRate());
		}
		else if(sunMoon.objectCollision(head) == false) // reset its potential to collide if it was previously off 
		{
			collisionPotential = 0;
		}
		
		if(headless && collisionPotential == 1) 
		{ // so if the avatar doesn't have a head and it doesn't have the potential to collide,
			
			int randomHead = (int)random(0,3); // depending on the chosen #, draw its respective head
			
			if(randomHead == 0) 
			{
				headType = 0;
			}
			else if(randomHead == 1)
			{
				headType = 1;
			}
			else
			{
				headType = 2;
			}
			
			fullBodiedAvatarCreated = true; // and the avatar will now have all its body parts
		}	
	}
	
	public void torsoSwapper()
	{ // torso swapping method based on avatar's head colliding with Planet Head
		
		if(fullBodiedAvatarCreated) 
		/* so if the avatar has all its body parts, 
		display it depending on the random type chosen; draws the associated torso type*/ 
		{
			if(torsoType == 2) // draw mermaid torso
			{
				torso.drawMermaidTorso();
			}
			else if(torsoType == 1)// draw octopus torso
			{
				torso.drawOctopusTorso();
			}
			else // draw default torso
			{
				torso.draw();
			}
			
			torsoless = false; // the avatar has a torso
		}
		
		if(torsoPlanet.objectCollision(torso) && collisionPotential == 0) 
		{ // when the avatar collides with the Planet torso and has the potential to collide,
			
			collisionPotential++; // turn off its potential to collide to stop it from continuously looping
			
			torsoless = true; // remove its torso; the avatar is now torsoless
			fullBodiedAvatarCreated = false; // thus it no longer has all its body parts
			txt.torsoPlanetFeedback(); // display feedback text "ZAP!"
			
			minim = new Minim(this); // and also display feedback sound 
			sound = minim.loadFile("../sounds/151257__michael-kur95__strange.mp3", 2048);
			sound.play();
			fft = new FFT(sound.bufferSize(), sound.sampleRate());
		}
		else if(sunMoon.objectCollision(head) == false) // reset its potential to collide if it was previously off 
		{
			collisionPotential = 0;
		}
		
		if(torsoless && collisionPotential == 1)
		{ // so if the avatar doesn't have a torso and it doesn't have the potential to collide,
			
			int randomtorso = (int)random(0,3); // depending on the chosen #, draw its respective torso
			
			if(randomtorso == 0) 
			{
				torsoType = 0;
			}
			else if(randomtorso == 1)
			{
				torsoType = 1;
			}
			else
			{
				torsoType = 2;
			}
			
			fullBodiedAvatarCreated = true; // and the avatar will now have all its body parts
		}	
	}
	
	public void sunMoonSwapper()
	{ // either the sun or moon will be drawn 
		
		if(startApplet == false) // if we're in the play mode AKA. the applet has not just been started 
		{
			if(sun_moon == 1) // draw moon
			{
				filter(INVERT); // invert background colours to simulate night
				sunMoon.drawMoon();
				daytime = false; // it is now night
				
				for (int i = 0; i < starAmount; i ++) // and display star fractals via factory method
				{
					StarHour currentStar = (StarHour) starhour_arraylist.get(i);
					currentStar.update();
					currentStar.drawMe();			
				}
			}
			else // draw sun
			{
				sunMoon.draw(); 
				daytime = true; // it is daytime
			}
		}
				
		if(sunMoon.objectCollision(head) && collisionPotential == 0) 
		{ // when the avatar collides with the sun or moon AND it has the potential to collided,...
			
			collisionPotential++; // ...turn off its potential to collide to stop it from continuously looping... 
			
			if(daytime) // ... and if it is daytime,
			{	
				sun_moon = 1; // draw the moon to switch to night time
			}
			else // ... and if it is night time,
			{	
				sun_moon = 0; // draw the sun to switch to daytime
			}
		}
		else if(sunMoon.objectCollision(head) == false) // reset its potential to collide if it was previously off 
		{
			collisionPotential = 0;
		}
	}
}
