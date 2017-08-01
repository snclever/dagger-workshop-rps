package com.hufsm;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Evaluator evaluator;

    public Game() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        player1 = new HumanPlayer(scanner);
//        player1 = new AIPlayer(random);
        player2 = new AIPlayer(random);

        evaluator = new Evaluator(player1, player2);
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
