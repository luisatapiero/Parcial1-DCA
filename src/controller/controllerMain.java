package controller;

import model.Logic;
import processing.core.PApplet;

public class controllerMain {
	
	private Logic logic;

	public controllerMain(PApplet app) {
		logic = new Logic(app);
	}

}
