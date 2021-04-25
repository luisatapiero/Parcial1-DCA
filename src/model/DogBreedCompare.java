package model;

import java.util.Comparator;

public class DogBreedCompare implements Comparator<Dog>{

	public DogBreedCompare() {
		// TODO Auto-generated constructor stub
	}
	public int compare(Dog breed1, Dog breed2) {
		return (breed1.getBreed().compareTo(breed2.getBreed()));
	}

}
