package com.hufsm.player;

import com.hufsm.game.Shape;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Scanner;

@Singleton
public class HumanPlayer implements Player {

    private Scanner scanner;
    private String name;

    @Inject
    public HumanPlayer(Scanner scanner) {
        this.scanner = scanner;

        System.out.println("Hi, please input your name:");
        name = scanner.nextLine();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Shape chooseShape() {
        System.out.println("Please choose a shape:");
        Shape shape = null;
        while (shape == null) {
            try {
                shape = Shape.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                shape = null;
                System.out.println("Sorry the shape you chose is invalid. Please choose again:");
            }
        }
        return shape;
    }
}
