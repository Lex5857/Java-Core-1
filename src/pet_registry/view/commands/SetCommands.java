package pet_registry.view.commands;

import pet_registry.view.ConsoleUI;

public class SetCommands extends Command{
    public SetCommands(ConsoleUI consoleUI) {
        super("Добавить команду", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setCommands();
    }
}
