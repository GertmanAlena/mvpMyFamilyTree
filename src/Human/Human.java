package Human;
import java.util.ArrayList;

public class Human implements HumanInterface, Comparable<Human> {
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

    public <T extends Human> Human(String name, String data, String gender, T mother) {
        this.name = name;
        this.gender = gender;
        this.data = data;
        this.mother = mother;
    }
    @Override
    public String toString() {
        return "id: " + id + ", имя: " + name + ", дата рождения: " + data +  ", пол: " + gender + ", брак №:" + marriage + ", дети:" + children;
    }
    @Override
    public void setName(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public void setData(String data) {
        this.data = data;
    }
    @Override
    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }
    @Override
    public void addChildren(Human human) {
        if (this.getChildren() == null) {this.setChildren(new ArrayList<Human>());}
        this.getChildren().add(human);
    }
    @Override
    public ArrayList<Human> getChildren() {
        return children;
    }

    @Override
    public String getName() {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public void setMarriage(int marriage) {
        this.marriage = marriage;
    }

    @Override
    public String getInfo() {
        return String.format("id: %s имя: %s дата рождения: %s пол: %s брак: %d дети: %s", id, name, data, gender, marriage, children);
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName()); // в String-ах уже есть метод compareTo
    }

}
