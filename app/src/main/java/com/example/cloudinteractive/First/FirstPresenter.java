package com.example.cloudinteractive.First;

public class FirstPresenter {
    FirstModel model;
    FirstView view;

    FirstPresenter(FirstModel model, FirstView view) {
        this.model = model;
        this.view = view;
    }

    void goSecond(){
        view.toSecond();
    }


}
