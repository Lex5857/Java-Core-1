package pet_registry;

import pet_registry.view.ConsoleUI;
import pet_registry.view.View;

public class Main {
    /**
    * Точка входа в программу.
    */
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
