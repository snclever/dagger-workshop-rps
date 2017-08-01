package com.hufsm.game;

import com.hufsm.AppComponent;
import com.hufsm.match.Match;
import com.hufsm.match.MatchFactory;
import com.hufsm.player.Player;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Scanner;

public class Game {

    private Scanner scanner;
    private MatchFactory matchFactory;

    @Inject
    public Game(Scanner scanner, MatchFactory matchFactory) {
        this.scanner = scanner;
        this.matchFactory = matchFactory;
    }

    public void start() {
        System.out.println("Hi! Lets play rock-paper-scissors!!!");

        while (true) {
            System.out.println("\n\nDo you want to start a new match?");
            scanner.nextLine();

            matchFactory.create().start();
        }
    }
}
