package Human;

import java.util.ArrayList;
import java.util.Calendar;

public class Human implements HumanInterface {
    private String name;
    private String id;
    private String gender;
    private String data;
    private Human father;
    private Human human;
    private Human mother;
    private int marriage;

    private ArrayList<Human> children;
    public Human(String name, String data, String gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.data = data;
        this.father = father;
        this.mother = mother;
    }
    public Human(Human human){
        this.human = human;
    }

    @Override
    public String toString() {
//        return id + " " + name + " " + data + " " + gender + " " + marriage + " " + children;
        return "id-" + id + ", " + name + ", дата рождения: " + data +  ", пол: " + gender + ", брак №: " + marriage + ", дети:" + children + " ";
    }

    public void setName(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setData(String data) {
        this.data = data;
    }
    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }
    public void addChildren(Human human) {
        if (this.getChildren() == null) {this.setChildren(new ArrayList<Human>());}
        this.getChildren().add(human);
    }
    public ArrayList<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public String getData() {
        return data;
    }

    public void setMarriage(int marriage) {
        this.marriage = marriage;
    }

    public String getInfo() {
        return String.format("id: %s имя: %s дата рождения: %s пол: %s брак: %d дети: %s", id, name, data, gender, marriage, children);
    }
}
