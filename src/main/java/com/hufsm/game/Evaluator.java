package com.hufsm.game;

import com.hufsm.player.Player;

public class Evaluator {

    private Player player1;
    private Player player2;

    public Evaluator(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Result evaluate(
            Shape player1Shape,
            Shape player2Shape
    ) {
        Result result;

        if (player1Shape == Shape.ROCK && player2Shape == Shape.PAPER) {
            result = Result.win(player2);
        } else if (player1Shape == Shape.PAPER && player2Shape == Shape.SCISSORS) {
            result = Result.win(player2);
        } else if (player1Shape == Shape.SCISSORS && player2Shape == Shape.ROCK) {
            result = Result.win(player2);
        } else if (player2Shape == Shape.ROCK && player1Shape == Shape.PAPER) {
            result = Result.win(player1);
        } else if (player2Shape == Shape.PAPER && player1Shape == Shape.SCISSORS) {
            result = Result.win(player1);
        } else if (player2Shape == Shape.SCISSORS && player1Shape == Shape.ROCK) {
            result = Result.win(player1);
        } else {
            result = Result.tie();
        }
        return result;
    }

}
