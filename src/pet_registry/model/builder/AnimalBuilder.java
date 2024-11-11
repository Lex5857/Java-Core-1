package pet_registry.model.builder;

import java.time.LocalDate;

import pet_registry.model.animal.Animal;
import pet_registry.model.animal.Type;

public class AnimalBuilder {
    private static AnimalBuilder animalBuilder;
    private int genId;

    private AnimalBuilder(){}

    public static AnimalBuilder getAnimalBuilder(){
        if (animalBuilder == null){
            animalBuilder = new AnimalBuilder();
        }
        return animalBuilder;
    }

    public Animal build(String name, Type type, LocalDate dateOfBirth){
        return new Animal(genId++, name, type, dateOfBirth);
    }
}
