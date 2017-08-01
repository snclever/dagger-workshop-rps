package com.hufsm;

import com.hufsm.game.Evaluator;
import com.hufsm.game.Game;
import com.hufsm.player.AIPlayer;
import com.hufsm.player.HumanPlayer;
import com.hufsm.player.Player;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Random;
import java.util.Scanner;

@Module
public abstract class AppModule {

    @Singleton
    @Provides
    public static Scanner provideScanner() {
        return new Scanner(System.in);
    }

    @Provides
    public static Random provideRandom() {
        return new Random();
    }

    @Singleton
    @Binds
    @Named("humanPlayer")
    public abstract Player bindHumanPlayer(HumanPlayer humanPlayer);

    @Singleton
    @Binds
    @Named("aiPlayer")
    public abstract Player bindAIPlayer(AIPlayer aiPlayer);

}
