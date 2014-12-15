/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tournament.impl;

import tournament.player.PlayerFactory;

/**
 *
 * @author Tobias
 * @param <PlayerType>
 */
public class Participant<PlayerType> implements ParticipantInfo
{
    private final PlayerFactory<PlayerType> playerFactory;
    private int matchesWon;
    private int matchesLost;
    private int matchesDraw;
    private int majorPoints;
    private int minorPoints;

    public Participant(PlayerFactory<PlayerType> playerFactory)
    {
        this.playerFactory = playerFactory;
        this.matchesWon = 0;
        this.matchesLost = 0;
        this.matchesDraw = 0;
        this.majorPoints = 0;
        this.minorPoints = 0;
    }
    
    @Override
    public String getID()
    {
        return playerFactory.getID();
    }
    
    @Override
    public String getName()
    {
        return playerFactory.getName();
    }
    
   @Override
    public int getMatchesWon()
    {
        return matchesWon;
    }

    @Override
    public int getMatchesLost()
    {
        return matchesLost;
    }

    @Override
    public int getMatchesDraw()
    {
        return matchesDraw;
    }

    @Override
    public int getMajorPoints()
    {
        return majorPoints;
    }

    @Override
    public int getMinorPoints()
    {
        return minorPoints;
    }
    
    synchronized PlayerType getNewPlayerInstance()
    {
        return playerFactory.getNewInstance();
    }
    
    synchronized void giveMajorPoints(int i)
    {
        majorPoints += i;
    }
    
    synchronized void giveMinorPoints(int i)
    {
        minorPoints += i;
    }
    
    synchronized void matchWon()
    {
        matchesWon += 1;
    }
    
    synchronized void matchLost()
    {
        matchesLost += 1;
    }
    
    synchronized void matchDraw()
    {
        matchesDraw += 1;
    }

    @Override
    public int compareTo(ParticipantInfo pi)
    {
        int c = this.majorPoints - pi.getMajorPoints();
        if(c != 0) return c;
        return this.minorPoints - pi.getMinorPoints();
    }

    

    
    
}
