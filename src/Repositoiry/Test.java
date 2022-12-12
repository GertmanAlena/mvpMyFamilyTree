package Repositoiry;

public class Test implements TestView{

    @Override
    public String emptyRes(String text) {
        if(text.isEmpty()) {
            System.out.println("\033[3;35mдерево пустое\033[0m");

        }
        return text;
    }
}

