package Repositoiry;

public class Pars {

    String name;
    String data;
    String gender;
    String id;
    String children;
    Integer marriage;

    /**
     * при загрузке из файла, нужно распарсить и сложить заново в лист
     * @param res
     */
    public void parse(String res) {
        String[] humanSplitMass = res.split(" / "); // все люди под индексами humanSplitMass человек

        // [0] id-13121984, Алёна, дата рождения: 13.12.1984, пол: ж, брак №: 0, дети:null
        for (int i = 0; i < humanSplitMass.length; i++) {

            String[] partsHumanSplit = humanSplitMass[i].split(","); // по частям partsHumanSplit
            // [0] id-13121984, [1] Алёна, [2] дата рождения: 13.12.1984, пол: ж, брак №: 0, дети:null
            for (int j = 0; j < partsHumanSplit.length; j++) {
                if(j == 0){
                    String[] idMass;
                    idMass = partsHumanSplit[j].split("-");
                    id = idMass[1].trim();
                    System.out.println("j[" + j + "] id >> " + id + " <<");
                }
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
            if (children.equals("null") && marriage == 0){
                System.out.println("пришли сюда" );

//                Repository.createFamilyHeader(name, data, gender);




            }

        }
    }
    
}
