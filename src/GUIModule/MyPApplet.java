package GUIModule;

import processing.core.*;

public class MyPApplet extends PApplet {
	
public void setup(){
	size (400,400);
	background(255);
	PImage img;
	img = loadImage("palmTrees.jpg","jpg");
	img.resize(0,height);
	image(img,0,0);
}
public void draw(){
	
	ellipse (width/5,height/4,height/4,height/4);
	fill(255,0,255);
	
}
}
