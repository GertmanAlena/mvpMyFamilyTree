package ui;

import Presenter.Presenter;

public interface View {
    void start();
    String getName(); String getData(); String getGender();
    String getNameChild(); String getDataChild(); String getGenderChild();

    void setPresenter(Presenter presenter);

    String getNameHusband();

    String getDataHusband();

    String getNameWafe();

    String getDataWafe();
    String getNameFather();

    String getDataFather();
    String getNameMather();

    String getDataMather();
    void print(String text);
}
