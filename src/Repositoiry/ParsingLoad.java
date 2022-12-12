package Repositoiry;

public class ParsingLoad {
    /**
     * метод парсинга и добавления в famiLyTree
     * @param sb
     */
    public void parse(String[] sb) {

        for (int i = 0; i < sb.length; i++) {
            System.out.println("sb[" + i + "] - " + sb[i]); // i = 0 первый человек id-0 Алёна 13.12.1984 Ж marriageNo 0 children: null
            String[] arrSplit = sb[i].split(",");   // arrSplit[0]->id-0  arrSplit[1]->Алёна
            for (int j = 0; j < arrSplit.length; j++) {
                if (j == 0) {
                    String[] idMass;
                    idMass = arrSplit[j].split("-");
                    String id = idMass[1];
                    System.out.println("j[" + j + "] id " + id);
                }
                if (j == 1) {
                    String[] nameMass;
                    nameMass = arrSplit[j].split(": ");
                    String name = nameMass[1];
                    System.out.println("j[" + j + "] name " + name);
                }
                if (j == 2) {
                    String[] dataMass;
                    dataMass = arrSplit[j].split(": ");
                    String data = dataMass[1];
                    System.out.println("j[" + j + "] data " + data);
                }
                if (j == 3) {
                    String[] genderMass;
                    genderMass = arrSplit[j].split(": ");
                    String gender = genderMass[1];
                    System.out.println("j[" + j + "] gender " + gender);
                }
                if (j == 4) {
                    String[] marriageMass;
                    marriageMass = arrSplit[j].split(": ");
                    String marriage = marriageMass[1];
                    System.out.println("j[" + j + "] marriage " + marriage);
                }
                if (j == 5) {
                    String[] childrenMass;
                    childrenMass = arrSplit[j].split(": ");
                    String children = childrenMass[1];
                    System.out.println("j[" + j + "] children " + children);
                }

//                System.out.println("j[" + j + "] " + arrSplit[j]);
            }
        }
    }
}
