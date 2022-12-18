package Repositoiry;

import Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * в этом методе творится вся магия
 */
public class Repository implements Iterable<Human>, Serializable {

    ProcedurHuman pr = new ProcedurHuman();
    int marriageCount = 0;
    private List<Human> familyTree = new ArrayList<>();
    FileServisView file = new FileServis();
    /**
     * метод создания узла
     * @param name имя человека
     * @param data дата рождения
     * @param gender пол
     */
    public void createFamilyHeader(String name, String data, String gender){
        Human p = new Human(name,  data, gender, null, null);
        String id = pr.DataToId(data);
        p.setId(id);
        familyTree.add(p);
    }
    /**
     * метод для добавления родившегося ребёнка
     * @param father Human папа
     * @param mother Human мама
     * @param name имя ребёнка
     * @param data дата рождения ребёнка
     * @param gender пол ребёнка
     */

    public void born(Human father, Human mother, String name, String data, String gender){
        try{
                Human p = new Human(name, data, gender, father, mother);
                String id = pr.DataToId(data);
                p.setId(id);
                father.addChildren(p);
                mother.addChildren(p);
                familyTree.add(p);
        } catch (NullPointerException e) {
            System.out.println("\033[1;31mЧто-то ввёл не то, попробуй ещё раз!!\033[0m");
        }
    }
    public Iterator<Human> iterator() {
        return new GroupIterator(familyTree);
    }
    public void sortByName() {
        Collections.sort(familyTree, new HumanComporatorByName());
    }
    /**
     * метод для просмотра всего дерева
     */
    public void showAll(){
        for (Human human : familyTree){
            System.out.println(human.getInfo());
        }
    }

    /**
     * метод поиска человека в дереве
     */
    public Human getPerson(String name, String data){
        for (Human test : familyTree) {
                if (test.getName().equals(name.substring(0, 1).toUpperCase() +
                        name.substring(1)) && test.getData().equals(data))
                    return test;}
        return null;
    }

    public void marriage(Human husband, Human wife){
        husband.setMarriage(++marriageCount);
        wife.setMarriage(marriageCount);
    }

    public void save(){
        file.save(familyTree);
    }
    public void load() {
        familyTree = file.load();

    }
    public void clear() {
        file.clear();
        familyTree.clear();
    }


}
