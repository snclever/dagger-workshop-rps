package com.hufsm;

import com.hufsm.game.Evaluator;
import com.hufsm.game.Game;
import com.hufsm.player.AIPlayer;
import com.hufsm.player.HumanPlayer;
import com.hufsm.player.Player;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Random;
import java.util.Scanner;

@Module
public class AppModule {

    @Singleton
    @Provides
    public Scanner provideScanner() {
        return new Scanner(System.in);
    }

    @Provides
    public Random provideRandom() {
        return new Random();
    }

    @Singleton
    @Provides
    @Named("humanPlayer")
    public Player provideHumanPlayer(Scanner scanner) {
        return new HumanPlayer(scanner);
    }

    @Singleton
    @Provides
    @Named("aiPlayer")
    public Player provideAIPlayer(Random random) {
        return new AIPlayer(random);
    }

    @Singleton
    @Provides
    public Evaluator provideEvaluator(
            @Named("humanPlayer") Player player1,
            @Named("aiPlayer") Player player2
    ) {
        return new Evaluator(player1, player2);
    }

    @Provides
    public Game provideGame(
            @Named("humanPlayer") Player player1,
            @Named("aiPlayer") Player player2,
            Evaluator evaluator
    ) {
        return new Game(player1, player2, evaluator);
    }
}
