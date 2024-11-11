package pet_registry.model.pet_registry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pet_registry.model.animal.Animal;
import pet_registry.model.animal.comparators.AnimalComparatorByName;

public class PetRegistry <E extends ItemPetRegistry> implements Serializable, Iterable<Animal>{
    private List<Animal> animals;

    public PetRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public Animal getAnimal(int id){
        for (Animal animal: animals){
            if (animal.getId() == id){
                return animal;
            }
        }
        return null;
    }

    public void sortByName(){
        animals.sort(new AnimalComparatorByName<>());
    }

    @Override
    public Iterator<Animal> iterator() {
        return new AnimalIterator<>(animals);
    }
}
