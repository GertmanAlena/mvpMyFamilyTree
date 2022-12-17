package Human;

import java.util.ArrayList;

public interface HumanInterface {

    public String toString();
    public void setName(String name);
    public void setId(String id);

    public void setGender(String gender);
    public void setData(String data);
    public void setChildren(ArrayList<Human> children);
    public void addChildren(Human human);
    public ArrayList<Human> getChildren();
    public String getName();
    public String getData();
    public void setMarriage(int marriage);
    public String getInfo();
}
