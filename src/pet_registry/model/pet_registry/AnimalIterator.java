package pet_registry.model.pet_registry;

import java.util.Iterator;
import java.util.List;

public class AnimalIterator<Animal> implements Iterator<Animal>{
    private int currentId;
    private List<Animal> animals;

    public AnimalIterator(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public boolean hasNext() {
        return animals.size() > currentId;
    }

    @Override
    public Animal next() {
        return animals.get(currentId++);
    }
}
