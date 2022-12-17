package Presenter;

import Repositoiry.Repository;
import ui.View;

public class Presenter {
    private final View view;
    private final Repository repository;


    public Presenter(View view, Repository repository) {
        this.view = view;
        this.repository = repository;
        view.setPresenter(this);
    }

    /**
     * создаём узел дерева
     * @param name имя
     * @param data дата рождения
     * @param gender пол
     */
    public void create(String name, String data, String gender){
        repository.createFamilyHeader(name.substring(0, 1).toUpperCase() + name.substring(1), data, gender);
    }
    /**
     * показать всё дерево
     */
    public void showAll(){
        repository.showAll();
    }

    /**
     * родился ребёнок? вносим в дерево
     * @param name имя
     * @param data дата рождения
     * @param gender пол
     */
    public void born(String name, String data, String gender){
        repository.born(repository.getPerson(view.getNameFather(), view.getDataFather()),
                repository.getPerson(view.getNameMather(), view.getDataMather()),
                name.substring(0, 1).toUpperCase() + name.substring(1), data, gender);
    }
    /**
     * вступили в брак
     */
    public void marriage(){
        repository.marriage(repository.getPerson(view.getNameHusband(), view.getDataHusband()),
                repository.getPerson(view.getNameWafe(), view.getDataWafe()));
    }
    /**
     * сохраняем в файл
     */
    public void save(){
        repository.save();
    }
    /**
     * поиск человека по дереву
     * @param name имя
     * @param data дата рождения
     * @return     */
    public boolean getPerson(String name, String data){
        var a = repository.getPerson(name, data);
        if(a != null){
            view.print(a.getInfo()+"\n");
        }
        else view.print("\033[1;31mНичего не нашлось, попробуй ещё раз!\033[0m\n");
        return false;
    }
    /**
     * загрузка из файла при входе в программу
     */
    public void load() {
        repository.load();
    }
    public void clear() {
        repository.clear();

    }
    public void sort(){
        repository.sortByName();
    }

}
