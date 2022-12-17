package Repositoiry;

import Human.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServis implements FileServisView {
    private final static String filePath = "family.txt";
    @Override
    public void save(List<Human> familyTree) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("family.txt")))
        {
            for (Human human : familyTree){
                oos.writeObject(human);
                System.out.println("File has been written");
            }

        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

    }
    @Override
    public void clear(){
        System.out.println("Дерево очищено");
        try {
            FileWriter fstream1 = new FileWriter(filePath);// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}
    }
    public List<Human> load(List<Human> familyTree){
//        List<Human> familyTree= new ArrayList<Human>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("family.txt")))
        {

//            Human h = (Human) ois.readObject();
//            familyTree.add(h);
          familyTree=((ArrayList<Human>)ois.readObject());
        }
        catch(Exception ex){

            System.out.println("---"+ex.getMessage());
        }
//        for(Human p : familyTree)
//            System.out.printf("Name: %s \t \n", p.getName());

        return familyTree;
    }
}





