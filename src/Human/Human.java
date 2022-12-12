package Human;

import java.util.ArrayList;

/**
 * создание сущности Human
 * implements Comparable<Human> говорит о том, что мы сможем производить сортировку
 * <Human> с чем сравниваем
 * тут конструктор, гетеры и сетеры,сетод создания списка детей
 * переопределён метод toString
 * переопределён метод compareTo
 */
public class Human implements Comparable<Human> {
    private String name;
    private int id;
    private String gender;
    private String data;
    private Human father;
    private Human human;
    private Human mother;
    private int marriageNo;
    private ArrayList<Human> children;
    public Human(String name, String data, String gender, Human father, Human mother){
        this.name = name;
        this.data = data;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }
    public Human(Human human){
        this.human = human;
    }

    public String getName() {
        return name;
    }
    public String getData() {
        return data;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setMarriageNo(int marriage) {
        this.marriageNo = marriage;
    }
    public ArrayList<Human> getChildren() {
        return children;
    }
    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }
    public void addChildren(Human human) {
        if (this.getChildren() == null) {this.setChildren(new ArrayList<Human>());}
        this.getChildren().add(human);
    }
    @Override
    public String toString() {
//        return id + " " + name + " " + data + " " + gender + " " + marriageNo + " " + children;
        return "Human: id-" + id + ", name: " + name + ", data: " + data +  ", gender: " + gender + ", marriageNo: "
                + marriageNo +  ", children: " + children + " ";
    }

    public String getInfo() {
        return String.format("имя: %s дата рождения: %s пол: %s", name, data, gender);
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName()); // в String-ах уже есть метод compareTo
    }
}
