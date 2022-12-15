package Repositoiry;

import Human.Human;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repository <T extends Human> implements Iterable<T>, RepoInterf {
    ProcedurHuman pr = new ProcedurHuman();
    int marriageCount = 0;
    private final List<T> familyTree = new ArrayList<>();
    FileServisView file = new FileServis();
    int indexMarriage = 0;

    Pars pars = new Pars();
    @Override
    public void createFamilyHeader(String name, String data, String gender){
        Human p = new Human(name,  data, gender, null, null);
        String id = pr.DataToId(data);
        p.setId(id);
        familyTree.add((T) p);
    }
     public void born(T father, T mother, String name, String data, String gender){
        try{
                Human p = new Human(name, data, gender, father, mother);
                String id = pr.DataToId(data);
                p.setId(id);
                father.addChildren(p);
                mother.addChildren(p);
                familyTree.add((T) p);
        } catch (NullPointerException e) {
            System.out.println("Что-то пошло не так!!");
        }


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
    @Override
    public T getPerson(String name, String data){

        for (T test : familyTree) {
           if (test.getName().equals(name.substring(0, 1).toUpperCase() +
               name.substring(1)) && test.getData().equals(data))
           return test;

            }
        return null;
    }

    public void marriage(T husband, T wafe){
        husband.setMarriage(++marriageCount);
        wafe.setMarriage(marriageCount);
    }
    @Override
    public void save(){
        file.save(convertListToString());
    }
    @Override
    public String convertListToString(){ // возвращаем  String
        StringBuilder sb = new StringBuilder();
        for (T human : familyTree){
            sb.append(human);
            sb.append("/ ");
        }
        return sb.toString();
    }
    @Override
    public void load() {
        String res = file.load();

        if(res.isEmpty()) return;
        else {
//          while (res.length()) {
            String[] person = res.split("/"); // все люди под индексами humanSplitMass человек;
            // [0] id-13121984, Алёна, дата рождения: 13.12.1984, пол: ж, брак №: 0, дети:null
            for (int i = 0; i < person.length; i++) {
                String[] p = pars.parse(person[i]);
                if (p.length <= 3) {
                    createFamilyHeader(p[0], p[1], p[2]);
                }
                if (p.length == 4) {
//                String[] marriageHuman = new String[20]; // [4] индекс перевести в int и найти вторую половинку с такой цифрой
                    createFamilyHeader(p[0], p[1], p[2]);
                    getPerson(p[0], p[1]).setMarriage(Integer.parseInt(p[3]));

                }
            }
        }
//        {
//            System.out.println("\033[1;30;44mдерево пустое!!!\033[0m");
//        }


    }

}
