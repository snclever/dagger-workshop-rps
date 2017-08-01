package com.hufsm;

import com.hufsm.game.Game;
import com.hufsm.match.MatchComponent;
import dagger.Component;

import javax.inject.Singleton;
import java.util.Random;
import java.util.Scanner;

@Singleton
@Component(modules = {
        AppModule.class
})
public interface AppComponent {

    void inject(Game game);

    Game getGame();
}
