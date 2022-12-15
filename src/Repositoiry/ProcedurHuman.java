package Repositoiry;

public class ProcedurHuman {
    /**
     * генерируем id  человека из даты рождения
     * @param data
     * @return
     */
    public String DataToId(String data) {  //13.12.1984
        String res1 = data.substring(0,2); //0123456789
        String res2 = data.substring(3,5);
        String res3 = data.substring(6,10);

        String res4 = res1 + res2 + res3;
        return res4;
    }
}
