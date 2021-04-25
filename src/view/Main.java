package view;

import java.util.Collections;

import controlP5.ControlP5;
import controlP5.Textfield;
import controller.ControllerMain;
import processing.core.PApplet;
import processing.core.PFont;
	

public class Main extends PApplet{
	
	private ControllerMain controllerMain;
	private ControlP5 cp5;
	
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}
	

	public void settings() {
		size (1000, 600);
	}
	

	public void setup() {
		cp5 = new ControlP5(this);
		PFont font = createFont("arial",20);
		
		controllerMain = new ControllerMain(this);
		
		cp5.addBang("id")
	     .setPosition(150,500)
	     .setSize(100,40)
	     .setLabel("Ordenar por Id")
	     .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER)
	     ;
		
		cp5.addBang("name")
	     .setPosition(350,500)
	     .setSize(100,40)
	     .setLabel("Ordenar por Nombre")
	     .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER)
	     ;
		
		cp5.addBang("breed")
	     .setPosition(550,500)
	     .setSize(100,40)
	     .setLabel("Ordenar por Raza")
	     .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER)
	     ;
		
		cp5.addBang("age")
	     .setPosition(750,500)
	     .setSize(100,40)
	     .setLabel("Ordenar por Edad")
	     .getCaptionLabel().align(ControlP5.CENTER, ControlP5.CENTER)
	     ;
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
	
	public void id(int button) {
		  button = 1;
		  controllerMain.sortList(button);
	
		}
	
	public void name(int button) {
		button = 2;
		  controllerMain.sortList(button);
		  
	}
	
	public void breed(int button) {
		button = 3;
		  controllerMain.sortList(button);
		  
	}
	
	public void age(int button) {
		button =4;
		  controllerMain.sortList(button);
		  
	}

}
