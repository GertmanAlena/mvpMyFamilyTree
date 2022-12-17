package Repositoiry;

import Human.Human;

public interface FileServisView {

    <T extends Human> void save(String text);

    String load();
    void clear();


}
