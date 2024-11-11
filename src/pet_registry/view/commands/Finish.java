package pet_registry.view.commands;

import pet_registry.view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super("Закончить работу", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().finish();
    }
}
