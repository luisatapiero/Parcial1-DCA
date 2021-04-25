package model;

import java.util.Comparator;

public class DogNameCompare implements Comparator <Dog>{

	@Override
	public int compare(Dog name1, Dog name2) {
		return (name1.getName().compareTo(name2.getName()));
	}


}
