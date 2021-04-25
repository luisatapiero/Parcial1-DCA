package controller;

import model.Logic;
import processing.core.PApplet;

public class ControllerMain {
	
	private Logic logic;

	public ControllerMain(PApplet app) {
		logic = new Logic(app);
	}
	
	public void drawInfo() {
		logic.drawInfo();
	}
	
	public void sortList(int button) {
		logic.sortList(button);
	}

}
