package view;

import controller.ControllerMain;
import processing.core.PApplet;
	

public class Main extends PApplet{
	
	private ControllerMain controllerMain;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}
	

	public void settings() {
		size (500, 500);
	}
	

	public void setup() {
		controllerMain = new ControllerMain(this);
	}
	

	public void draw() {

	}

}
