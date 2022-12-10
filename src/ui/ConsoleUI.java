package ui;

import Presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;

    /**
     * общение с пользователем
     */
    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void start() {
        presenter.load();
        // idCount  после загрузки прировнять в последнему
        try (Scanner scan = new Scanner(System.in)) {

            while (true) {
                System.out.println(" 1 - create  2 - born 3 - showAll 4 - getPerson 5 - save");
                String key = scan.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.create(getName(), getData(), getGender());
                        break;
                    case "2":

                        presenter.born(getName(), getData(), getGender());
                        break;
                    case "3":
                        presenter.showAll();
                        break;
                    case "4":
                        presenter.getPerson(getName(), getData());
                        break;
                    case "5":
                        presenter.save();
                        break;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }

    }
    @Override
    public String getName() {
        System.out.printf("FirstName: ");
        return scanner.nextLine();
    }

    @Override
    public String getData() {
        System.out.printf("Data: ");
        return scanner.nextLine();
    }

    @Override
    public String getGender() {
        System.out.printf("Gender: ");
        return scanner.nextLine();
    }

    @Override
    public void print(String text) {

    }
}
