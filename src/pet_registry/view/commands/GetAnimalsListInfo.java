package pet_registry.view.commands;

import pet_registry.view.ConsoleUI;

public class GetAnimalsListInfo extends Command {
    public GetAnimalsListInfo(ConsoleUI consoleUI) {
        super("Получить список животных", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().getAnimalsListInfo();
    }
}
