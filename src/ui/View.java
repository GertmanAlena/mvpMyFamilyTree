package ui;

import Presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void start();

    String getName();
    String getNameChild();

    String getData();
    String getDataChild();

    String getGender();
    String getGenderChild();

    void print(String text);




}