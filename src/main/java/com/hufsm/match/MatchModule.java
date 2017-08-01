package com.hufsm.match;

import com.hufsm.player.Player;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module
public class MatchModule {

    @MatchScope
    @Provides
    public Evaluator provideEvaluator(
            @Named("humanPlayer") Player player1,
            @Named("aiPlayer") Player player2
    ) {
        return new Evaluator(player1, player2);
    }

}
