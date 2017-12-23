package davidhxxx.teach.designpattern.adapter.zoo.inheriting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import davidhxxx.teach.designpattern.adapter.zoo.common.Animal;

@SuppressWarnings("serial")
public class ZooWithInheritance extends ArrayList<Animal> {

	public boolean addAnimal(Animal animal) {
		return super.add(animal);
	}

	public boolean freeAnimal(Animal animal) {
		if (animal.isFreeable()) {
			return super.remove(animal);
		}
		return false;
	}

	/**
	 * we cannot delete with bypassing rules
	 */
	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	/**
	 * we cannot delete with bypassing rules
	 */
	@Override
	public Animal remove(int i) {
		throw new UnsupportedOperationException();
	}

	/**
	 * we cannot delete with bypassing rules
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	public boolean feedHerbivores() {
		boolean isAtLeastOneAnimalFed = false;
		for (Animal currentAnimal : this) {
			if (currentAnimal.isHerbivor()) {
				currentAnimal.feed();
				isAtLeastOneAnimalFed = true;
			}
		}

		return isAtLeastOneAnimalFed;
	}

	public List<Animal> findAnimals() {
		return Collections.unmodifiableList(this);
	}

}
