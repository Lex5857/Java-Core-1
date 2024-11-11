package pet_registry.view;

import pet_registry.presenter.Presenter;
import pet_registry.model.animal.Type;
import pet_registry.model.animal.Animal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {
    /**
    * Консоль для взоимодействия с пользователем.
    */
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        loading();
        System.out.println("Приветствие\n");
        while (work) {
            System.out.println(menu.menu());
            System.out.println("\nВведите число:");
            String choiceStr = scanner.nextLine();
            int choice = strNumToInt(choiceStr);
            if (isNumMenu(choice)){
                menu.execute(choice);
            } else {
                System.out.println("Пункта меню с таким номером нет. Попробуйте еще раз");
            }
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void addAnimal(){
        int count = 0;

        System.out.println("Укажите кличку:");
        String name = answerUser();
        if (name == ""){count++;}

        System.out.println("Укажите дату рождения в формате dd.mm.yyyy");
        LocalDate dateOfBirth = addDateOfBirth();
        if (dateOfBirth == null){count++;}

        System.out.println("Укажите тип:");
        Type type = addType();
        if (type == null){count++;}

        if (count > 0){
            try {
                throw new RuntimeException(String.format("Не заполнено %d данных. Попробуйте снова.", count));
            } catch (RuntimeException e){
                System.out.println(e);
            }
        } else {
            presenter.addAnimal(name, type, dateOfBirth);
        } 
    }

    public void finish() {
        work = false;
        scanner.close();
        presenter.save();
        System.out.println("До новых встреч!");
    }

    public void setCommands() {
        System.out.println("Укажите id:");
        String idAnimalStr = answerUser();
        int idAnimal = strNumToInt(idAnimalStr);

        if (searchIdAnimal(idAnimal)){
            presenter.setCommands(idAnimal, addCommand());
        }else{System.out.println("В реестре нет записи с таким Id");}
    }

    public void getAnimalsListInfo() {
        presenter.getAnimalsListInfo();
    }

    private Animal getAnimal(int idAnimal){
        return presenter.getAnimal(idAnimal);
    }

    private String addCommand(){
        System.out.println("Укажите команду:");
        String commandStr = answerUser();
        return commandStr;
    }

    private void loading() {
        if (presenter.loading()){
            System.out.println("Чтение файла прошло успешно");
        } else {
            System.out.println("Не удалось прочитать файл. Возможно он не был сохранен, удален или переименован");
        }
    }

    private String answerUser(){
        return scanner.nextLine();
    }
    
    private LocalDate addDateOfBirth(){
        String dateOfBirthStr = answerUser();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return LocalDate.parse(dateOfBirthStr, formatter);
        } catch (DateTimeParseException e){
            return null;
        }
    }

    private Type addType(){
        Type type = null;
        System.out.println("1. cat");
        System.out.println("2. dog");
        System.out.println("3. hamster");
        System.out.println("4. camel");
        System.out.println("5. horse");
        System.out.println("6. donkey");
        System.out.println("Введите число:");
        String choiceStr = answerUser();
        if (choiceStr.equals("1")){
            type = Type.cat;
        } else if (choiceStr.equals("2")){
            type = Type.dog;
        } else if (choiceStr.equals("3")){
            type = Type.hamster;
        } else if (choiceStr.equals("4")){
            type = Type.camel;
        } else if (choiceStr.equals("5")){
            type = Type.horse;
        } else if (choiceStr.equals("6")){
            type = Type.donkey;
        } else {
            System.out.println("Не верное число");
        }
        return type;
    }

    private int strNumToInt(String choiceStr) {
        try {
            int choice = Integer.parseInt(choiceStr);
          return choice;
        } catch(NumberFormatException e){
            return -1;
        }
    }

    private boolean searchIdAnimal(int idAnimal) {
        if (getAnimal(idAnimal) != null){
            return true;
        }
        return false;
    }

    private boolean isNumMenu(int choice) {
        if (choice > 0 && choice <= menu.size()){
            return true;
        }
        return false;
    } 
}
