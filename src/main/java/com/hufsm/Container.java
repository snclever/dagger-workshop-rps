package com.hufsm;

import java.util.Random;
import java.util.Scanner;

public class Container {

    private Scanner scanner;
    private Random random;
    private Player player1;
    private Player player2;
    private Evaluator evaluator;

    public Container() {
    }

    public Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public Random getRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }

    public Player getPlayer1() {
        if (player1 == null) {
            player1 = new HumanPlayer(getScanner());
        }
        return player1;
    }

    public Player getPlayer2() {
        if (player2 == null) {
            player2 = new AIPlayer(getRandom());
        }
        return player2;
    }

    public Evaluator getEvaluator() {
        if (evaluator == null) {
            evaluator = new Evaluator(getPlayer1(), getPlayer2());
        }
        return evaluator;
    }

    public Game getGame() {
        return new Game(getPlayer1(), getPlayer2(), getEvaluator());
    }

}
