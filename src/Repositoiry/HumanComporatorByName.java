package Repositoiry;

import Human.Human;

import java.util.Comparator;

public class HumanComporatorByName<T> implements Comparator<T> {

    @Override
    public int compare(T human, T o1) {
        return ((Human)human).getName().compareTo(((Human)o1).getName());
    }

}
