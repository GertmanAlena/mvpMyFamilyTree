package Repositoiry;

import Human.Human;

public interface RepoInterf  <T extends Human>{
    void createFamilyHeader(String name, String data, String gender);

     void showAll();

    T getPerson(String name, String data);

    void save();

    String convertListToString();

    void load();
}