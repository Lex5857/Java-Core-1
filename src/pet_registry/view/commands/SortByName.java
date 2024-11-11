package pet_registry.view.commands;

import pet_registry.view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать по кличке", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByName();
    }
}
