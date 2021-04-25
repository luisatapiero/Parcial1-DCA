package model;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import processing.core.PApplet;

public class Logic {
	private DogAgeCompare dogAgeCompare;
	private DogNameCompare dogNameCompare;
	private DogBreedCompare dogBreedCompare;
	
	private PApplet app;
	private String[] txt1;
	private String[] txt2;
	private String[] array1;
	private String[] array2;
	private LinkedList<Dog> listDog;

	public Logic(PApplet app) {

		this.app = app;
		listDog = new LinkedList<Dog>();
		loadTxt();
		dogAgeCompare = new DogAgeCompare();
		dogNameCompare = new DogNameCompare();
		dogBreedCompare = new DogBreedCompare();
		// combineInfo();

	}

	private void loadTxt() {

		txt1 = app.loadStrings("./data/imports/TXT1.txt");
		txt2 = app.loadStrings("./data/imports/TXT2.txt");
		txtToWords();

	}

	private void txtToWords() {

		for (int i = 0; i < txt1.length; i++) {
			array1 = txt1[i].split(" ");
			int id = Integer.parseInt(array1[0]);
			String name = array1[1];
			// System.out.println(id);
			// System.out.println(name);

			for (int j = 0; j < txt2.length; j++) {
				array2 = txt2[j].split(" ");
				if (id == Integer.parseInt(array2[0])) {

					String breed = array2[1];
					String birthDate = array2[2];
					// System.out.println(breed);
					// System.out.println(birthDate);
					// Date birthDate1;

					SimpleDateFormat birthDate1 = new SimpleDateFormat("dd-mm-yyyy");
					Date date;
					try {
						date = birthDate1.parse(birthDate);
						long ms = System.currentTimeMillis() - date.getTime();
						long age = (long) ((long) ms / (1000.0 * 60 * 60 * 24 * 365));
						// System.out.println(birthDate + age);

						combineInfo(id, name, breed, birthDate, age);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		}

	}

	private void combineInfo(int id, String name, String breed, String birthDate, long age) {
		listDog.add(new Dog(id, name, breed, birthDate, age, app));
		System.out.println(listDog.get(0).getAge());
	}
	
	public void sortList(char button) {
		switch (button) {
		case 1:
			Collections.sort(listDog);
			break;
		case 2:
			Collections.sort(listDog, dogNameCompare);
			break;
		case 3:
			Collections.sort(listDog, dogBreedCompare);
			break;
		case 4:
			Collections.sort(listDog, dogAgeCompare);
			break;


		default:
			break;
		}
	}

	public void drawInfo() {
		app.textSize(14);
		app.fill(11, 57, 84);
		for (int i = 0; i < 5; i++) {
			int age = (int) listDog.get(i).getAge();
			app.text(listDog.get(i).getId(), 250, 100+(i*80));
			app.text(listDog.get(i).getName(), 400 , 100+(i*80));
			app.text(listDog.get(i).getBreed(),  550 , 100+(i*80));
			app.text(listDog.get(i).getBirthDate(), 730 ,100+(i*80));
			app.text(age, 880, 100+(i*80));
		}
	}

}
