package Repositiry;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileService implements FileServisView {

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
    public String load(){
        StringBuilder sb = new StringBuilder();
        try(Scanner scanner = new Scanner(new File(filePath))){
            while (scanner.hasNextLine()){
                sb.append(scanner.nextLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
