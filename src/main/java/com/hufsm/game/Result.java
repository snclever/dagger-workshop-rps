package com.hufsm.game;

import com.hufsm.player.Player;

public class Result {

    public enum Outcome {
        WIN,
        TIE
    }

    public Outcome outcome;

    public Player winner;

    private Result(Outcome outcome, Player winner) {
        this.outcome = outcome;
        this.winner = winner;
    }

    public static Result win(Player winner) {
        return new Result(Outcome.WIN, winner);
    }

    public static Result tie() {
        return new Result(Outcome.TIE, null);
    }
}
