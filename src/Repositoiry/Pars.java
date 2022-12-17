//package Repositoiry;
//
//import Human.Human;
//
//import java.util.ArrayList;
//import java.util.List;
//
////
////import java.util.ArrayList;
////import java.util.List;
////
//public class Pars implements RepoInterf  {
//    //
//    protected String id;
//    protected String name;
//
//    protected String data;
//    protected int marriage;
//    protected String gender;
//    protected String children;
//    List<Human> familyTree;
//
//    public List<Human> loadPars(String res){
//        familyTree = new ArrayList<Human>();
//        String[] person = res.split(" / "); // все люди под индексами humanSplitMass человек;
//        for (int i = 0; i < person.length; i++) { // [0] id-13121984, Алёна, дата рождения: 13.12.1984, пол: ж, брак №: 0, дети:null
//            String[] partsHumanSplit = person[i].split(","); // по частям partsHumanSplit
//            for (int j = 0; j < partsHumanSplit.length; j++) {// [0] id-13121984, [1] Алёна, [2] дата рождения: 13.12.1984, пол: ж, брак №: 0, дети:null
//                String[] x;
//                x = partsHumanSplit[j].split(":");
//                if(x[0].equals("id")){
//                    id = x[1].trim();
//                }
//                if(x[0].equals(" имя")){
//                    name = x[1].trim();
//                }
//                if(x[0].equals(" дата рождения")){
//                    data = x[1].trim();
//                }
//                if(x[0].equals(" пол")){
//                    gender = x[1];
//                }
//                if(x[0].equals(" брак №")){
//                    marriage = Integer.valueOf(x[1]);
//                }
//                if(x[0].equals(" дети")) {
//                    if (x[1].equals("null") || x[1].equals("null]")) {
//                        children = "null";
//
//                    }
//                    else {
//                        if(gender.equals("м") || gender.equals("М")){
//                        createFamilyHeader(name, data, gender);
//
//                        }
//
//                    }
//                }
//            }
//         }
//        return familyTree;
//    }
//
//
//    @Override
//    public void createFamilyHeader(String name, String data, String gender) {
//
//    }
//
//    @Override
//    public void createFamilyHeader(String name, String data, String gender, String id) {
//        Human p = new Human(name,  data, gender, null, null);
//        p.setId(id);
//        familyTree.add(p);
//    }
//}
