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
                System.out.println(" 1 - Внести узел дерева 2 - вступили в брак 3 - рождение ребёнка 4 - Показать всё дерево 5 - найти человека " +
                        "6 - save 7 - очистить файл с деревом\n\033[1;35mДля выхода нажмите (0)\033[0m");
                String key = scan.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.create(getName(), getData(), getGender());
                        break;
                    case "2":
                        presenter.marriage();
                        break;
                    case "3":
                        presenter.born(getNameChild(), getDataChild(), getGenderChild());
                        break;
                    case "4":
                        presenter.showAll();
                        break;
                    case "5":
                        presenter.getPerson(getName(), getData());
                        break;
                    case "6":
                        presenter.save();
                        break;
                    case "7":
                        presenter.clear();
                        break;
                    case "0":
                        System.exit(0);
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }

    }
    @Override
    public String getName() {
        System.out.printf("Введите имя: ");
        return scanner.nextLine();
    }
    @Override
    public String getData() {
        System.out.printf("Введите дату рождения: ");
        return scanner.nextLine();
    }
    @Override
    public String getGender() {
        System.out.printf("Введите пол: ");
        return scanner.nextLine();
    }
    @Override
    public String getNameChild() {
        System.out.printf("Введите имя ребёнка: ");
        return scanner.nextLine();
    }
    @Override
    public String getDataChild() {
        System.out.printf("Введите дату рождения ребёнка: ");
        return scanner.nextLine();
    }
    @Override
    public String getGenderChild() {
        System.out.printf("Введите пол ребёнка: ");
        return scanner.nextLine();
    }
    @Override
    public String getNameHusband() {
        System.out.printf("Введите имя супруга: ");
        return scanner.nextLine();
    }
    @Override
    public String getDataHusband() {
        System.out.printf("Введите дату рождения супруга: ");
        return scanner.nextLine();
    }
    @Override
    public String getNameWafe() {
        System.out.printf("Введите имя супруги: ");
        return scanner.nextLine();
    }
    @Override
    public String getDataWafe() {
        System.out.printf("Введите дату рождения супруги: ");
        return scanner.nextLine();
    }
    @Override
    public String getNameFather() {
        System.out.printf("Введите имя отца: ");
        return scanner.nextLine();
    }
    @Override
    public String getDataFather() {
        System.out.printf("Введите дату рождения отца: ");
        return scanner.nextLine();}
    @Override
    public String getNameMather() {
        System.out.printf("Введите имя матери: ");
        return scanner.nextLine();
    }
    @Override
    public String getDataMather() {
        System.out.printf("Введите дату рождения матери: ");
        return scanner.nextLine();}

    @Override
    public void print(String text) {
        System.out.printf(text);
    }
}