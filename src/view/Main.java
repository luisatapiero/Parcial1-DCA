package view;

import controller.ControllerMain;
import processing.core.PApplet;
	

public class Main extends PApplet{
	
	private ControllerMain controllerMain;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}
	

	public void settings() {
		size (1000, 600);
	}
	

	public void setup() {
		controllerMain = new ControllerMain(this);
	}
	

	public void draw() {
		background(191,215,234);
		controllerMain.drawInfo();
		textAlign(CENTER);
		textSize(14);
		fill(255, 90, 95);
		text("Foto", 100, 50);
		text("Id", 250, 50);
		text("Nombre", 400, 50);
		text("Raza", 550, 50);
		text("Fecha de nacimiento", 730, 50);
		text("Edad", 880, 50);
		
	}

}
