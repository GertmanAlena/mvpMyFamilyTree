package Repositiry;

import Human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Repository класс дерева с методом создания, рождения, брака
 */
public class Repository <T extends Human> implements Iterable<T> {
    /**
     *  @param familyTree
     */

    private final List<T> familyTree = new ArrayList<>();
    int idCount = 0;
    int marriageCount = 0;
    FileService fileService = new FileService();

    public void save(){
        fileService.save(print());
    }
    public void load(){
        String res = fileService.load();
        // передаём в метод парсинга, в котором добавим в лист
    }

    /**
     * метод создания корня дерева familyTree
     * @param name имя человека
     * @param data дата рождения
     * @param gender пол человека
     */
    public void createFamilyHeader(String name, String data, String gender){
        Human p = new Human(name,  data, gender, null, null);
        p.setId(idCount++);
        familyTree.add((T) p);

    }
    /**
     * метод рождения ребёнка
     * @param father отец
     * @param mother мать
     * @param name имя ребёнка
     * @param data дата рождения ребёнка
     * @param gender пол ребёнка
     */
    public void born(T father, T mother, String name, String data, String gender){
        // сначала ищем родителей, потом...String father
        Human p = new Human(name, data, gender, father, mother);
        p.setId(idCount++);
        father.addChildren(p);
        mother.addChildren(p);
        familyTree.add((T) p);
    }
    /**
     * метод, если Human вступил в брак с присваиванием ID брака
     * @param husband сохраняется как супруг
     * @param wife сохраняется как супруга
     */
    public void marriage(T husband, T wife){
        husband.setMarriageNo(++marriageCount);
        wife.setMarriageNo(marriageCount);
    }

    public T getPerson(String name, String data){
        for (T test : familyTree) {
            if (test.getName().equals(name) && test.getData().equals(data)) {
                return test;
            }
        }
        return null;
    }
    /**
     * метод перебора дерева с помощью итератора
     * вызов метода speak через интерфейс
     */
    public String print(){ // возвращаем  String
        StringBuilder sb = new StringBuilder();
        for (T human : familyTree){
            sb.append(human);
            sb.append("* ");
        }
        return sb.toString();
    }

    public void print2(String name){ // возвращать string в презентер
        ArrayList<T> findList = new ArrayList<>();
        for (T test : familyTree) {
            if (((Human)test).getName() == name){  // TODO equals
                findList.add((T) test);
            }
        }
        for (int i = 0; i < findList.size(); i++) {
            System.out.println(findList.get(i));
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new GroupIterator(familyTree);
//        return familyTree.iterator();
    }
//    public void sortByName() {
//        Collections.sort(familyTree, new HumanComparatorByName());
//    }


}
