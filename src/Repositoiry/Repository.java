package Repositoiry;

import Human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * в этом методе творится вся магия
 * @param <T>
 */
public class Repository <T extends Human> extends Pars implements Iterable<T>, RepoInterf  {

    ProcedurHuman pr = new ProcedurHuman();
    int marriageCount = 0;
    private final List<T> familyTree = new ArrayList<>();
    FileServisView file = new FileServis();
    String[] xxx;

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
        familyTree.add((T) p);
    }
    public void createFamilyHeaderMarriage(String name, String data, String gender, int marriage){
        Human p = new Human(name,  data, gender, null, null);
        String id = pr.DataToId(data);
        p.setId(id);
        p.setMarriage(marriage);
        familyTree.add((T) p);
    }
    /**
     * метод для добавления родившегося ребёнка
     * @param father Human папа
     * @param mother Human мама
     * @param name имя ребёнка
     * @param data дата рождения ребёнка
     * @param gender пол ребёнка
     */
     public void born(T father, T mother, String name, String data, String gender){
        try{
                Human p = new Human(name, data, gender, father, mother);
                String id = pr.DataToId(data);
                p.setId(id);
                father.addChildren(p);
                mother.addChildren(p);
                familyTree.add((T) p);
        } catch (NullPointerException e) {
            System.out.println("\033[1;31mЧто-то ввёл не то, попробуй ещё раз!!\033[0m");
        }
    }

    /**
     * метод для добавления ребёнка при загрузке файла
     * с проверкой, если уже человек добавлен в лист
     */
    public void bornOneParent(T parent, String name, String data, String gender){
        try{
            Human p = new Human(name, data, gender, parent);
            String id = pr.DataToId(data);
            p.setId(id);
            parent.addChildren(p);
            if(getPerson(name, data) == null){
                familyTree.add((T) p);
            }
        } catch (NullPointerException e) {
            System.out.println("\033[1;31mЧто-то ввёл не то, попробуй ещё раз!!\033[0m");
        }
    }
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * метод для просмотра всего дерева
     */
    public void showAll(){
        for (T human : familyTree){
            System.out.println(human.getInfo());
        }
    }

    /**
     * метод поиска человека в дереве
     */
    public T getPerson(String name, String data){
        for (T test : familyTree) {
                if (test.getName().equals(name.substring(0, 1).toUpperCase() +
                        name.substring(1)) && test.getData().equals(data))
                    return test;}
        return null;
    }

    public void marriage(T husband, T wafe){
        husband.setMarriage(++marriageCount);
        wafe.setMarriage(marriageCount);
    }

    public void save(){
        file.save(convertListToString());
    }

    public String convertListToString(){ // возвращаем  String
        StringBuilder sb = new StringBuilder();
        for (T human : familyTree){
            sb.append(human);
            sb.append(" / \n");
        }
        return sb.toString();
    }

    /**
     * метод парсинга при загрузке из .txt
     */
    public void load() {
        String res = file.load();
        String[] person = res.split(" / "); // все люди под индексами humanSplitMass человек;
            for (int i = 0; i < person.length; i++) { // [0] id-13121984, Алёна, дата рождения: 13.12.1984, пол: ж, брак №: 0, дети:null
            String[] partsHumanSplit = person[i].split(","); // по частям partsHumanSplit
                for (int j = 0; j < partsHumanSplit.length; j++) {// [0] id-13121984, [1] Алёна, [2] дата рождения: 13.12.1984, пол: ж, брак №: 0, дети:null
                    String[] x;
                    x = partsHumanSplit[j].split(":");
                    if(x[0].equals("id")){
                        id = x[1].trim();
                    }
                    if(x[0].equals(" имя")){
                        name = x[1].trim();
                    }
                    if(x[0].equals(" дата рождения")){
                        data = x[1].trim();
                    }
                    if(x[0].equals(" пол")){
                        gender = x[1];
                    }
                    if(x[0].equals(" брак №")){
                        marriage = Integer.valueOf(x[1]);
                    }
                    if(x[0].equals(" дети")) {
                        if (x[1].equals("null") || x[1].equals("null]")) {
                            children = "null";
                            if (xxx[2].equals("ж") || xxx[2].equals("Ж")) {
                                bornOneParent(getPerson(xxx[0], xxx[1]), name, data, gender);}
                            if (xxx[2].equals("м") || xxx[2].equals("М")) {
                                bornOneParent(getPerson(xxx[0], xxx[1]), name, data, gender);}
                        } else { // если дети есть, добавляем в лист и записываем имя, дату и пол, чтобы потом записать в родители
                                createFamilyHeaderMarriage(name, data, gender, marriage);
                                xxx = new String[3];
                                xxx[0] = name.trim();
                                xxx[1] = data.trim();
                                xxx[2] = gender.trim();
                            }
                    }
            }
                xxx[0] = "";
                xxx[1] = "";
                xxx[2] = "";
        }
    }
    @Override
    public void clear() {
        file.clear();
        familyTree.clear();
    }
}
