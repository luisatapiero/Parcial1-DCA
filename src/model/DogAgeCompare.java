package model;

import java.util.Comparator;

public class DogAgeCompare implements Comparator <Dog>{

	@Override
	public int compare(Dog age1, Dog age2) {
		return (int) (age1.getAge()-age2.getAge());
	}

}
