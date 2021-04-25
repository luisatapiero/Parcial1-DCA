package model;

import java.util.Date;

import processing.core.PApplet;
import processing.core.PImage;

public class Dog implements Comparable<Dog> {

	private int id;
	private String name;
	private String breed;
	private String birthDate;
	private long age;
	private static PImage bulldogImg;
	private static PImage huskyImg;
	private static PImage retrieverImg;
	private static PImage germanImg;
	private static PImage rottweilerImg;
	private PApplet app;

	public Dog(int id, String name, String breed, String birthDate, long age, PApplet app) {

		this.id = id;
		this.name = name;
		this.breed = breed;
		this.birthDate = birthDate;
		this.age = age;
		this.app = app;

		loadImgs();

	}

	private void loadImgs() {
		
		//se cargan imagenes de los perros y se les ajusta el tamaño para que todas sean iguales
		
		app.imageMode(PApplet.CENTER);
		bulldogImg = app.loadImage("data/images/bulldog.jpg");
		bulldogImg.resize(50, 50);
		huskyImg = app.loadImage("data/images/husky_siberiano.jpg");
		huskyImg.resize(50, 50);
		retrieverImg = app.loadImage("data/images/labrador_retriever.jpg");
		retrieverImg.resize(50, 50);
		germanImg = app.loadImage("data/images/pastor_aleman.jpg");
		germanImg.resize(50, 50);
		rottweilerImg = app.loadImage("data/images/rottweiler.jpg");
		rottweilerImg.resize(50, 50);
	}

	@Override
	public int compareTo(Dog nextDog) {
		return this.id - nextDog.getId();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public long getAge() {
		return age;
	}

	public static PImage getBulldogImg() {
		return bulldogImg;
	}

	public static PImage getHuskyImg() {
		return huskyImg;
	}

	public static PImage getRetrieverImg() {
		return retrieverImg;
	}

	public static PImage getGermanImg() {
		return germanImg;
	}

	public static PImage getRottweilerImg() {
		return rottweilerImg;
	}

}
