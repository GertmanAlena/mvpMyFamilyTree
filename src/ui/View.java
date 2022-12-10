package ui;

import Presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void start();

    String getName();

    String getData();

    String getGender();

    void print(String text);




}