package com.hufsm.match;

import dagger.Subcomponent;

@MatchScope
@Subcomponent(modules = {
        MatchModule.class
})
public interface MatchComponent {

    @MatchScope Match getMatch();

    @Subcomponent.Builder
    interface Builder {
        MatchComponent build();
    }

}
