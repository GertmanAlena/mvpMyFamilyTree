package Repositoiry;

import Human.Human;

import java.util.List;

public interface FileServisView {

    void save(List<Human> familyTree);
    List<Human> load();
    void clear();


}
