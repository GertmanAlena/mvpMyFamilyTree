package Repositiry;

import Human.Human;

import java.util.*;

import static java.util.logging.Level.parse;

/**
 * Repository класс дерева с методом создания, рождения, брака
 */
public class Repository <T extends Human> implements Iterable<T>{
    /**
     *  @param familyTree
     */

    private final List<T> familyTree = new ArrayList<>();
    int idCount = 0;
    int marriageCount = 0;
    FileServisView fileService = new FileService();

    public void save(){
        fileService.save(convertListToString());
    }
    public void load(){
        String res = fileService.load();

        if(res.isEmpty()){
            System.out.println("\033[3;35mдерево пустое\033[0m");
            // передаём в метод парсинга, в котором добавим в лист

        }
        else  parsLoad(res);;

    }
    public void parsLoad(String res){
        String[] sb = res.split(" / "); // все люди под индексами
        for (int i = 0; i < sb.length; i++){
            System.out.println("sb[" + i + "] - " + sb[i]); // i = 0 первый человек id-0 Алёна 13.12.1984 Ж marriageNo 0 children: null
            String[] arrSplit = sb[i].split(" ");   // arrSplit[0]->id-0  arrSplit[1]->Алёна

            for (int j = 0; j < arrSplit.length; ) {
                String id = arrSplit[j++];
                String name = arrSplit[j++];
                String data = arrSplit[j++];
                String gender = arrSplit[j++];
                createFamilyHeaderLoad(id, name, data, gender);
//                System.out.println("sarrSplit[" + j + "] - " + arrSplit[j]);
                String marriage = arrSplit[j++];
                String children = arrSplit[j++];

            }
//                for (int j = 0; j < sb[i].length(); j++) {
//    //                createFamilyHeaderLoad(arrSplit[i], arrSplit[i+1], arrSplit[i+2], arrSplit[i+3]);
//                    System.out.println("j[ " + j + "]" + arrSplit[j]);
//                }
        }
    }
    public void createFamilyHeaderLoad(String id, String name, String data, String gender){
        Human p = new Human(name,  data, gender, null, null);
        int i = Integer.parseInt (id);
        p.setId(i);
        familyTree.add((T) p);
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
    public String convertListToString(){ // возвращаем  String
        StringBuilder sb = new StringBuilder();
        for (T human : familyTree){
            sb.append(human);
            sb.append("/ ");
        }
        return sb.toString();
    }
    public void print(){
        for (T human : familyTree){
            System.out.println(human.getInfo());
        }
    }
//    public void print2(String name){ // возвращать string в презентер
//        ArrayList<T> findList = new ArrayList<>();
//        for (T test : familyTree) {
//            if (test.getName() == name){  // TODO equals
//                findList.add(test);
//            }
//        }
//        for (int i = 0; i < findList.size(); i++) {
//            System.out.println(findList.get(i));
//        }
//    }
    @Override
    public Iterator<T> iterator() {
        return new GroupIterator(familyTree);
//        return familyTree.iterator();
    }
//    public void sortByName() {
//        Collections.sort(familyTree, new HumanComparatorByName());
//    }


}
