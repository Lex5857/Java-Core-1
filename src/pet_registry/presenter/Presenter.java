package pet_registry.presenter;

import java.time.LocalDate;

import pet_registry.model.animal.Type;
import pet_registry.model.animal.Animal;
import pet_registry.model.service.Service;
import pet_registry.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addAnimal(String name, Type type, LocalDate dateOfBirth) {
        service.addAnimal(name, type, dateOfBirth);
        getAnimalsListInfo();
    }

    public void setCommands(int idAnimal, String command){
        service.setCommands(idAnimal, command);
    }

    public Animal getAnimal(int idAnimal){
        return service.getAnimal(idAnimal);
    }

    public void getAnimalsListInfo() {
        String answer = service.getAnimalsListInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getAnimalsListInfo();
    }

    public void save() {
        service.save();
    }

    public boolean loading() {
        if (service.loading()) {
            return true;
        } else {
            return false;
        }
    }
}
