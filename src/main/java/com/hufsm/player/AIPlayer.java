package com.hufsm.player;

import com.hufsm.game.Shape;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Random;

@Singleton
public class AIPlayer implements Player {

    private static int numberOfAIPlayers = 0;


    private Random random;
    private int aiNumber;

    @Inject
    public AIPlayer(Random random) {
        this.random = random;
        aiNumber = ++numberOfAIPlayers;
    }

    @Override
    public String getName() {
        return "AI" + aiNumber;
    }

    @Override
    public Shape chooseShape() {
        return Shape.values()[random.nextInt(Shape.values().length)];
    }
}
