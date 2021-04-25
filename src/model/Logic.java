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
	private String[] txtId;
	private String[] txtName;
	private String[] txtBreed;
	private String[] txtAge;
	private LinkedList<Dog> listDog;

	public Logic(PApplet app) {

		this.app = app;
		listDog = new LinkedList<Dog>();
		dogAgeCompare = new DogAgeCompare();
		dogNameCompare = new DogNameCompare();
		dogBreedCompare = new DogBreedCompare();

		txtId = new String[5];
		txtName = new String[5];
		txtAge = new String[5];
		txtBreed = new String[5];
		txtAge = new String[5];

		loadTxt();

	}

	private void loadTxt() {

		// carga los dos txt

		txt1 = app.loadStrings("./data/imports/TXT1.txt");
		txt2 = app.loadStrings("./data/imports/TXT2.txt");
		txtToWords();

	}

	private void txtToWords() {

		// dividir los txt en palabras

		for (int i = 0; i < txt1.length; i++) {
			array1 = txt1[i].split(" ");

			// guardar la info en variables

			int id = Integer.parseInt(array1[0]);
			String name = array1[1];

			for (int j = 0; j < txt2.length; j++) {
				array2 = txt2[j].split(" ");

				// guardar la info en variables

				if (id == Integer.parseInt(array2[0])) {

					String breed = array2[1];
					String birthDate = array2[2];

					// se llama el método de calcular

					calculateAge(id, name, breed, birthDate);

				}

			}

		}

	}

	//método de calcular la edad de acuerdo a la fecha de nacimiento
	
	private void calculateAge(int id, String name, String breed, String birthDate) {
		SimpleDateFormat birthDate1 = new SimpleDateFormat("dd-mm-yyyy");
		Date date;
		try {
			date = birthDate1.parse(birthDate);
			long ms = System.currentTimeMillis() - date.getTime();
			long age = (long) ((long) ms / (1000.0 * 60 * 60 * 24 * 365));

			combineInfo(id, name, breed, birthDate, age);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void combineInfo(int id, String name, String breed, String birthDate, long age) {

		// combinar la info para añadirla en el Linkedlist

		listDog.add(new Dog(id, name, breed, birthDate, age, app));
	}

	public void sortList(int button) {
		
		

		// ordenar la info de acuerdo con el botón que sea presionado por el usuario

		switch (button) {
		case 1:

			// se ordena naturalmente por id

			Collections.sort(listDog);
			forNewTxt(button);
			//preparetxtIdM();
			break;

		case 2:

			// se ordena parcialmente por nombre

			Collections.sort(listDog, dogNameCompare);
			forNewTxt(button);
			//preparetxtNameM();
			break;

		case 3:

			// se ordena parcialmente por raza

			Collections.sort(listDog, dogBreedCompare);
			forNewTxt(button);
			//preparetxtBreedM();
			break;

		case 4:

			// se ordena parcialmente por edad

			Collections.sort(listDog, dogAgeCompare);
			forNewTxt(button);
			//preparetxtAgeM();
			break;

		default:
			break;
		}
	}

	public void drawInfo() {

		// pintar la info

		app.textSize(14);
		app.fill(11, 57, 84);
		for (int i = 0; i < 5; i++) {
			int age = (int) listDog.get(i).getAge();
			app.text(listDog.get(i).getId(), 250, 110 + (i * 80));
			app.text(listDog.get(i).getName(), 400, 110 + (i * 80));
			app.text(listDog.get(i).getBreed(), 550, 110 + (i * 80));
			app.text(listDog.get(i).getBirthDate(), 730, 110 + (i * 80));
			app.text(age, 880, 110 + (i * 80));

			//se llama el método de pintar imagenes
			
			paintImages(i);

		}
	}

	//se hace un método para que este sólo pinte las imagenes
	
	private void paintImages(int i) {
		
		switch (listDog.get(i).getId()) {

		case 1:
			app.image(Dog.getRetrieverImg(), 100, (i * 80) + 100);
			break;

		case 2:
			app.image(Dog.getGermanImg(), 100, (i * 80) + 100);
			break;

		case 3:
			app.image(Dog.getBulldogImg(), 100, (i * 80) + 100);
			break;

		case 4:
			app.image(Dog.getRottweilerImg(), 100, (i * 80) + 100);
			break;

		case 5:
			app.image(Dog.getHuskyImg(), 100, (i * 80) + 100);
			break;
		default:
			break;
		}
	}
	
	//Se puso este for para que este mismo recorriera los atributos y permitir que se guarden
	
	private void forNewTxt(int button) {
		for (int i = 0; i < listDog.size(); i++){
			
			if (button == 1) {
				preparetxtIdM(i);
			}
			
			if (button == 2) {
				preparetxtNameM(i);;
			}
			
			if (button == 3) {
				preparetxtBreedM(i);
			}
			
			if (button == 4) {
				preparetxtAgeM(i);
			}
			
			
			
		}
	}

	// guardar los archivos txt ordenados por cada atributo (id, nombre, raza y
	// edad)
	
	private void preparetxtIdM(int i) {

			int id = listDog.get(i).getId();
			String name = listDog.get(i).getName().toLowerCase();
			String breed = listDog.get(i).getBreed().toLowerCase();
			String birthDate = listDog.get(i).getBirthDate();
			int age = (int) listDog.get(i).getAge();
			txtIdM(i, id, name, breed, birthDate, age);
		}

	//método para que se guarde en el txt

	private void txtIdM(int i, int id, String name, String breed, String birthDate, int age) {
		txtId[i] = Integer.toString(id) + " " + name + " " + breed + " " + birthDate + " " + Integer.toString(age);
		
		app.saveStrings("/data/exports/OrdenadoPorId.txt", txtId);
	}

	private void preparetxtNameM(int i) {
		
			int id = listDog.get(i).getId();
			String name = listDog.get(i).getName().toLowerCase();
			String breed = listDog.get(i).getBreed().toLowerCase();
			String birthDate = listDog.get(i).getBirthDate();
			int age = (int) listDog.get(i).getAge();

			txtNameM(i, id, name, breed, birthDate, age);

	}

	private void txtNameM(int i, int id, String name, String breed, String birthDate, int age) {
		txtName[i] = Integer.toString(id) + " " + name + " " + breed + " " + birthDate + " " + Integer.toString(age);
		
		app.saveStrings("/data/exports/OrdenadoPorNombre.txt", txtName);
	}

	private void preparetxtBreedM(int i) {

			int id = listDog.get(i).getId();
			String name = listDog.get(i).getName().toLowerCase();
			String breed = listDog.get(i).getBreed().toLowerCase();
			String birthDate = listDog.get(i).getBirthDate();
			int age = (int) listDog.get(i).getAge();

			txtBreedM(i, id, name, breed, birthDate, age);

	}

	private void txtBreedM(int i, int id, String name, String breed, String birthDate, int age) {
		txtBreed[i] = Integer.toString(id) + " " + name + " " + breed + " " + birthDate + " " + Integer.toString(age);
		
		app.saveStrings("/data/exports/OrdenadoPorRaza.txt", txtBreed);
	}

	private void preparetxtAgeM(int i) {

			int id = listDog.get(i).getId();
			String name = listDog.get(i).getName().toLowerCase();
			String breed = listDog.get(i).getBreed().toLowerCase();
			String birthDate = listDog.get(i).getBirthDate();
			int age = (int) listDog.get(i).getAge();

			txtAgeM(i, id, name, breed, birthDate, age);

	}

	private void txtAgeM(int i, int id, String name, String breed, String birthDate, int age) {
		txtAge[i] = Integer.toString(id) + " " + name + " " + breed + " " + birthDate + " " + Integer.toString(age);
		app.saveStrings("/data/exports/OrdenadoPorEdad.txt", txtAge);
	}

}
