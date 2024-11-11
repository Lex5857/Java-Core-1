package pet_registry.model.animal.comparators;

import pet_registry.model.pet_registry.ItemPetRegistry;

import java.util.Comparator;

public class AnimalComparatorByName<E extends ItemPetRegistry> implements Comparator<E>{

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
