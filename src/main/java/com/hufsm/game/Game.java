package com.hufsm.game;

import com.hufsm.AppComponent;
import com.hufsm.player.Player;

import javax.inject.Inject;
import javax.inject.Named;

public class Game {

    @Inject
    @Named("humanPlayer")
    Player player1;

    @Inject
    @Named("humanPlayer")
    Player player2;

    @Inject
    Evaluator evaluator;

    @Inject
    public Game(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void start() {
        System.out.println("Hi! Lets play rock-paper-scissors!!!");

        while (true) {
            System.out.println("\n\n%%%%%%%%%%%% NEW MATCH");

            Shape player1Shape = player1.chooseShape();
            Shape player2Shape = player2.chooseShape();

            System.out.println(player1.getName() + " chose " + player1Shape);
            System.out.println(player2.getName() + " chose " + player2Shape);

            Result result = evaluator.evaluate(player1Shape, player2Shape);

            switch (result.outcome) {
                case WIN:
                    System.out.println(result.winner.getName() + " won!");
                    break;
                case TIE:
                    System.out.println("It's a tie!");
                    break;
            }
        }
    }
}
