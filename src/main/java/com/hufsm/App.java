package com.hufsm;

public class App {

    public static void main(String[] args) {
        AppComponent appComponent = DaggerAppComponent.create();
        appComponent.getGame().start();
    }
}
