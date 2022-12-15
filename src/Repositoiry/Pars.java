package Repositoiry;

public class Pars {
    private String id;
    private String name;
    private String data;
    private int marriage;
    private String gender;
    private String children;

//    public String getName() {
//        return name;
//    }
//
//    public String getData() {
//        return data;
//    }
//
//    public String getGender(String[] parse) {
//        return gender;
//    }

    /**
    * при загрузке из файла, нужно распарсить и сложить заново в лист
    */
    public String[] parse(String res) {
        String[] partsHumanSplit = res.split(","); // по частям partsHumanSplit
        // [0] id-13121984, [1] Алёна, [2] дата рождения: 13.12.1984, пол: ж, брак №: 0, дети:null
        for (int j = 0; j < partsHumanSplit.length; j++) {
//                if (j == 0) {
//                    String[] idMass;
//                    idMass = partsHumanSplit[j].split("-");
//                    id = idMass[1].trim();
//                    System.out.println("j[" + j + "] id >> " + id + " <<");
//                }
            if (j == 1) {
//                    String[] nameMass;
//                    nameMass = humanSplitMass[j].split(": ");
                name = partsHumanSplit[j].trim();
                System.out.println("j[" + j + "] name >> " + name + " <<");
            }
            if (j == 2) {
                String[] dataMass;
                dataMass = partsHumanSplit[j].split(": ");
                data = dataMass[1].trim();
                System.out.println("j[" + j + "] data >> " + data + " <<");
            }
            if (j == 3) {
                String[] genderMass;
                genderMass = partsHumanSplit[j].split(": ");
                gender = genderMass[1].trim();
                System.out.println("j[" + j + "] gender >> " + gender + " <<");
            }

            if (j == 4) {
                String[] marriageMass;
                marriageMass = partsHumanSplit[j].split(": ");
                marriage = Integer.valueOf(marriageMass[1]);
                System.out.println("j[" + j + "] marriage >> " + marriage + " <<");
            }
            if (j == 5) {
                String[] childrenMass;
                childrenMass = partsHumanSplit[j].split(":");
                children = childrenMass[1].trim();
                System.out.println("j[" + j + "] children = >> " + children + " <<");
            }



        }
        if (children.equals("null") && marriage == 0) {
            System.out.println(" if просто человек");
            String[] person = new String[3];
            person[0] = name;
            person[1] = data;
            person[2] = gender;
            return person;
        } else if (marriage != 0) {
            System.out.println(" if есть брак");
            String[] person1 = new String[4];
            person1[0] = name;
            person1[1] = data;
            person1[2] = gender;
            person1[3] = Integer.toString(marriage);
            return person1;
        }


        return partsHumanSplit;
    }

}
