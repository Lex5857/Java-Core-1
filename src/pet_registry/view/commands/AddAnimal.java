package pet_registry.view.commands;

import pet_registry.view.ConsoleUI;

public class AddAnimal extends Command{
    public AddAnimal(ConsoleUI consoleUI) {
        super("Добавить в реестр", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addAnimal();
    }
}
