package model;

import java.util.Date;

import processing.core.PApplet;

public class Dog {

	private int posX;
	private int posY;

	private int id;
	private String name;
	private String breed;
	private String birthDate;
	private long age;

	private PApplet app;

	public Dog(int id, String name, String breed, String birthDate, long age, PApplet app) {

		this.id = id;
		this.name = name;
		this.breed = breed;
		this.birthDate = birthDate;
		this.age = age;
		this.app = app;


	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

}
