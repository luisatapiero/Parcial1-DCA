package model;

import java.util.ArrayList;
import java.util.LinkedList;

import processing.core.PApplet;

public class Logic {

	private PApplet app;
	private String[] txt1;
	private String[] txt2;
	private String[] array1;
	private String[] array2;
	private LinkedList<Dog> dogList;
	private ArrayList<String> firstList;

	public Logic(PApplet app) {

		this.app = app;
		dogList = new LinkedList<Dog>();
		firstList = new ArrayList<String>();
		loadTxt();

	}

	private void loadTxt() {

		txt1 = app.loadStrings("./data/imports/TXT1.txt");
		txt2 = app.loadStrings("./data/imports/TXT2.txt");
		txtToWords();
		CombineInfo();

	}

	private void txtToWords() {
		for (int i = 0; i < txt1.length; i++) {
			array1 = txt1[i].split(" ");
			for (int j = 0; j < array1.length; j++) {
				System.out.println(array1[j]);
			}

		}

		for (int i = 0; i < txt2.length; i++) {
			array2 = txt2[i].split(" ");
			for (int j = 0; j < array2.length; j++) {
				System.out.println(array2[j]);
			}
		}
	}

	private void CombineInfo() {

		

		

	}

}
