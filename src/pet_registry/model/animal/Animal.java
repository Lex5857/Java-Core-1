package pet_registry.model.animal;

import java.time.LocalDate;
import java.io.Serializable;

import pet_registry.model.pet_registry.ItemPetRegistry;

public class Animal implements Serializable, ItemPetRegistry {
    private int id;
    private String name;
    private Type type;
    private LocalDate dateOfBirth;
    private String commands;

    public Animal(int id, String name, Type type, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type type() {
        return type;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String command) {
        if (this.commands == null){
            this.commands = command;
        }else{
            this.commands = this.commands + ", " + command;
        }
    }

    public String toString() {
        String animalInfo = "";
        animalInfo += "<" + name + ">"
        + "<" + type + ">"
        + "<" + dateOfBirth + ">"
        + "<" + commands + ">" + System.lineSeparator();
        return animalInfo;
    }
}
