/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tournament.impl;

import tournament.game.GameFactory;
import tournament.game.GameInstance;
import tournament.game.GameResult;
import tournament.ui.TournamentUI;

/**
 *
 * @author Tobias
 * @param <PlayerType>
 */
public class Match<PlayerType> implements MatchInfo, Runnable
{
    private final TournamentUI ui;
    private int index;
    private final GameFactory<PlayerType> gameFactory;
    private final Participant<PlayerType> pA;
    private final Participant<PlayerType> pB;
    private GameResult res;
    private boolean hasFinished;

    public Match(TournamentUI ui,
                 GameFactory<PlayerType> gameFactory,
                 Participant<PlayerType> pA,
                 Participant<PlayerType> pB)
    {
        this.ui = ui;
        this.gameFactory = gameFactory;
        this.pA = pA;
        this.pB = pB;
        this.hasFinished = false;
    }
    
    void setIndex(int index)
    {
        this.index = index;
    }
    
    public GameFactory<PlayerType> getGame()
    {
        return gameFactory;
    }
    
    @Override
    public Participant<PlayerType> getParticipantA()
    {
        return pA;
    }
    
    @Override
    public Participant<PlayerType> getParticipantB()
    {
        return pB;
    }
    
    public synchronized boolean isReady()
    {
        return hasFinished;
    }
    
    public synchronized void waitForFinished()
    {
        while(!hasFinished)
        {
            try {wait();} catch (InterruptedException ex){}
        }
    }
    
    @Override
    public synchronized GameResult getResult()
    {
        waitForFinished();
        return res;
    }

    @Override
    public synchronized void run()
    {
        if(hasFinished) return;
        ui.matchStarted(index);
        GameInstance<PlayerType> gameInstance = gameFactory.getNewGameInstance();
        PlayerType playerA = pA.getNewPlayerInstance();
        PlayerType playerB = pB.getNewPlayerInstance();
        res = gameInstance.run(playerA, playerB);
        pA.giveMajorPoints(res.majorPointsA);
        pA.giveMinorPoints(res.minorPointsA);
        pB.giveMajorPoints(res.majorPointsB);
        pB.giveMinorPoints(res.minorPointsB);
        if(res.majorPointsA > res.majorPointsB)
        {
            pA.matchWon();
            pB.matchLost();
        }
        else if(res.majorPointsA < res.majorPointsB)
        {
            pA.matchLost();
            pB.matchWon();
        }
        else
        {
            pA.matchDraw();
            pB.matchDraw();
        }
        hasFinished = true;
        ui.matchFinished(index);
        notifyAll();
    }

}
