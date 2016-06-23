package davidhxxx.teach.designpattern.adapter.zoo.composition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import davidhxxx.teach.designpattern.adapter.zoo.common.Animal;

public class ZooWithComposition {

    private ArrayList<Animal> innerList = new ArrayList<Animal>();

    public boolean addAnimal(Animal animal) {
	return innerList.add(animal);
    }

    public boolean freeAnimal(Animal animal) {
	if (animal.isFreeable()) {
	    return innerList.remove(animal);
	}
	return false;
    }

    public boolean feedHerbivores() {
	boolean isAtLeastOneAnimalFed = false;
	for (Animal currentAnimal : innerList) {
	    if (currentAnimal.isHerbivore()) {
		currentAnimal.feed();
		isAtLeastOneAnimalFed = true;
	    }
	}

	return isAtLeastOneAnimalFed;
    }

    public List<Animal> findAnimals() {
	return Collections.unmodifiableList(innerList);
    }

}
