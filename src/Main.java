import Presenter.Presenter;
import Repositiry.Repository;
import ui.ConsoleUI;
import ui.View;

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI();
        Repository repository = new Repository();
        Presenter presenter = new Presenter(view,repository);

        view.start();


    }
}