package controller;

import model.Logic;
import processing.core.PApplet;

public class ControllerMain {
	
	private Logic logic;

	public ControllerMain(PApplet app) {
		logic = new Logic(app);
	}

}
