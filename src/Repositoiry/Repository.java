package Repositoiry;

import Human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repository <T extends Human> implements Iterable<T> {
    ProcedurHuman pr = new ProcedurHuman();
    int marriageCount = 0;
    private final List<T> familyTree = new ArrayList<>();
    FileServisView file = new FileServis();

    Pars pars = new Pars();

    public void createFamilyHeader(String name, String data, String gender){
        Human p = new Human(name,  data, gender, null, null);
        String id = pr.DataToId(data);
        p.setId(id);
        familyTree.add((T) p);
    }
    public void born(T father, T mother, String name, String data, String gender){
        Human p = new Human(name, data, gender, father, mother);
        String id = pr.DataToId(data);
        p.setId(id);
        father.addChildren(p);
        mother.addChildren(p);
        familyTree.add((T) p);
    }
    @Override
    public Iterator<T> iterator() {
        return null;
    }
    public void showAll(){
        for (T human : familyTree){
            System.out.println(human.getInfo());
        }
    }
    public T getPerson(String name, String data){
        for (T test : familyTree) {
            if (test.getName().equals(name.substring(0, 1).toUpperCase() + name.substring(1)) && test.getData().equals(data)) {
                return test;
            }
        }
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
            sb.append("/ ");
        }
        return sb.toString();
    }
    public void load() {
        String res = file.load();

        if(res.isEmpty()) return;
        else pars.parse(res);
//        {
//            System.out.println("\033[1;30;44mдерево пустое!!!\033[0m");
//        }


    }

}
