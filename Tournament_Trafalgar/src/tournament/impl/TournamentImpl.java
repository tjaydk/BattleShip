/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tournament.impl;

import tournament.impl.executor.MatchExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import tournament.game.GameFactory;
import tournament.player.PlayerFactory;
import tournament.ui.TournamentUI;

/**
 *
 * @author Tobias
 * @param <PlayerType>
 */
public class TournamentImpl<PlayerType>
{
    private final TournamentUI ui;
    private final MatchExecutor executor;

    public TournamentImpl(TournamentUI ui, MatchExecutor executor)
    {
        this.ui = ui;
        this.executor = executor;
    }
    
    public void runTournament(  GameFactory<PlayerType> gameFactory,
                                Collection<PlayerFactory<PlayerType>> players)
    {
        int size = players.size();
        ArrayList<Participant<PlayerType>> participants = new ArrayList<>(size);
        for(PlayerFactory<PlayerType> pf : players)
        {
            participants.add(new Participant<>(pf));
        }
        ArrayList<Match<PlayerType>> matches = new ArrayList<>();
        for(int a = 0; a < size; ++a)
        {
            for(int b = a + 1; b < size; ++b)
            {
                Participant<PlayerType> pA = participants.get(a);
                Participant<PlayerType> pB = participants.get(b);
                matches.add(new Match(ui, gameFactory, pA, pB));
            }
        }
        matches.trimToSize();
        Collections.shuffle(matches);
        ParticipantInfo[] pi = new ParticipantInfo[participants.size()];
        for(int i = 0; i < pi.length; ++i)
        {
            pi[i] = participants.get(i);
        }
        MatchInfo[] ms = new MatchInfo[matches.size()];
        for(int i = 0; i < ms.length; ++i)
        {
            Match<PlayerType> m = matches.get(i);
            ms[i] = m;
            m.setIndex(i);
        }
        ui.tournamentReady(gameFactory.getGameName(), pi, ms);
        ArrayList<Runnable> runnables = new ArrayList<>(matches.size());
        for(Runnable r : matches)
        {
            runnables.add(r);
        }
        executor.executeAll(runnables); //Blocks until all matches are finished
        ArrayList<ParticipantInfo> result = new ArrayList<>(participants.size());
        for(ParticipantInfo parInfo : participants)
        {
            result.add(parInfo);
        }
        Collections.sort(result);
        ui.tournamentFinished(result);
    }
}
