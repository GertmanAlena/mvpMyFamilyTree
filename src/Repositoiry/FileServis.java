package Repositoiry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileServis implements FileServisView {
    private final static String filePath = "family.txt";

    @Override
    public void save(String text){
        System.out.println("Сохранили");
        try (FileWriter fw = new FileWriter(filePath, true)){
            fw.write(text+"\n");
            fw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public String load() {
        StringBuilder sb = new StringBuilder();
        try(Scanner scanner = new Scanner(new File(filePath))){
            while (scanner.hasNextLine()){
                sb.append(scanner.nextLine());
            }
        }catch (Exception e){
            System.out.println("\033[1;30;44mдерево пустое!!!\033[0m");
        }
        return sb.toString();
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
}
//        pars.parse(loadFiles);




