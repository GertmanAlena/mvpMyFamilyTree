package Repositoiry;

import Human.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServis  implements FileServisView {
    private final static String filePath = "family.txt";
    @Override
    public void save(List<Human> familyTree) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("family.txt")))
        {
            oos.writeObject(familyTree);
            System.out.println("File has been written");
            }catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void clear(){

        try {
            FileWriter fstream1 = new FileWriter(filePath);// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
            System.out.println("Дерево очищено");
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}
    }
    public List<Human> load(){
        ArrayList<Human> familyTree = new ArrayList<>();
    try{
        FileInputStream fis = new FileInputStream("family.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        familyTree = (ArrayList) ois.readObject();

        ois.close();
        fis.close();

        for (Human h : familyTree) {
            System.out.println(h.toString());
            System.out.println();
            return familyTree;
        }
    }
        catch (FileNotFoundException e){
            System.out.println("\033[1;33;40mфайла пока нет, создайте его\033[0m");
//            e.printStackTrace();
        }
        catch (IOException e){

            e.printStackTrace();
        }
        catch (ClassNotFoundException e){

            e.printStackTrace();
        }
        return familyTree;

    }
}





