package Presenter;

import Human.Human;
import Repositiry.Repository;
import ui.View;

/**
 * Presenter для связи репозитория с пользователем
 */
public class Presenter {
    private View view;
    private Repository<Human> repository;

    //мето load вызов
    public Presenter(View view, Repository repository) {
        this.view = view;
        this.repository = repository;
        view.setPresenter(this);
    }

    public void create(String name, String data, String gender){
        repository.createFamilyHeader(name, data, gender);
        repository.print();
    }

    public void save(){
        repository.save();
    }
    public void load(){
        repository.load();
    }
    public void showAll(){
        repository.print();
    }
    public void born(String name, String data, String gender){
        repository.born(repository.getPerson(view.getName(), view.getData()),
                repository.getPerson(view.getName(), view.getData()),
                name, data, gender);
        repository.print();

    }
    public void getPerson(String name, String data) {
        Human human = repository.getPerson(name, data);
        view.print(human.getInfo());
    }
}
