package pet_registry.model.service;

import java.time.LocalDate;

import pet_registry.model.builder.AnimalBuilder;
import pet_registry.model.animal.Type;
import pet_registry.model.animal.Animal;
import pet_registry.model.writer.FileHandler;
import pet_registry.model.pet_registry.PetRegistry;

public class Service {
    private AnimalBuilder animalBuilder;
    private PetRegistry<Animal> petRegistry;
    private FileHandler writer;

    public Service() {
        petRegistry = new PetRegistry<>();
        animalBuilder = AnimalBuilder.getAnimalBuilder();
        writer = FileHandler.getFileHandler();
    }

    public void addAnimal(String name, Type type, LocalDate dateOfBirth){
        Animal animal = animalBuilder.build(name, type, dateOfBirth);
        petRegistry.addAnimal(animal);
    }

    public void setCommands(int idAnimal, String command) {
        Animal animal = petRegistry.getAnimal(idAnimal);
        animal.setCommands(command);
    }

    public Animal getAnimal(int idAnimal){
        return petRegistry.getAnimal(idAnimal);
    }

    public String getAnimalsListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список:\n");
        for (Animal animal: petRegistry){
            stringBuilder.append("id: " + animal.getId() + " ");
            stringBuilder.append(animal);
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        petRegistry.sortByName();
    }

    public void save() {
        writer.save(petRegistry);
    }

    public boolean loading() {
        if (writer.loading() != null) {
            petRegistry = (PetRegistry) writer.loading();
            return true;
        } else {
            return false;
        }
    }
}
