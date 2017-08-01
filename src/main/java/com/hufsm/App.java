package com.hufsm;

import com.hufsm.game.Game;

public class App {

    public static void main(String[] args) {
        AppComponent appComponent = DaggerAppComponent.create();

//        Game game = new Game();
//        appComponent.inject(game);
//
//        game.start();

        appComponent.getGame().start();
    }
}
