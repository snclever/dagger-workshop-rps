package com.hufsm;

import com.hufsm.match.Match;
import com.hufsm.match.MatchComponent;
import com.hufsm.match.MatchFactory;
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

@Module(subcomponents = {
        MatchComponent.class
})
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


    @Provides
    public static MatchFactory provideMatchFactory(MatchComponent.Builder matchComponentBuilder) {
        return new MatchFactory() {
            @Override
            public Match create() {
                return matchComponentBuilder.build().getMatch();
            }
        };
    }

}
