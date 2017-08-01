package com.hufsm.match;

import com.hufsm.game.Result;
import com.hufsm.game.Shape;
import com.hufsm.player.Player;

import javax.inject.Inject;
import javax.inject.Named;

@MatchScope
public class Match {

    private Player player1;
    private Player player2;
    private Evaluator evaluator;

    @Inject
    public Match(
            @Named("humanPlayer") Player player1,
            @Named("aiPlayer") Player player2,
            Evaluator evaluator
    ) {
        this.player1 = player1;
        this.player2 = player2;
        this.evaluator = evaluator;
    }

    public void start() {
        for (int round = 1; round <= 3; round++) {
            System.out.println("\n\n%%%%%%%%%%%% ROUND " + round);

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
