/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.implementations;

import battleship.interfaces.Board;
import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import battleship.interfaces.BattleshipsPlayer;



/**
 *
 * @author Tobias
 */
class ProxyPlayer implements BattleshipsPlayer
{
    private final BattleshipsPlayer player;

    public ProxyPlayer(BattleshipsPlayer player)
    {
        this.player = player;
    }
    
   

    @Override
    public void startMatch(int rounds)
    {
        try
        {
            player.startMatch(rounds);
        }
        catch(Exception e)
        {
            
        }
    }

    @Override
    public void placeShips(Fleet fleet, Board board)
    {
        try
        {
            player.placeShips(new FleetProxy(fleet), board);
        }
        catch(Exception e)
        {
            
        }
    }

    @Override
    public void incoming(Position pos)
    {
        try
        {
            player.incoming(pos);
        }
        catch(Exception e)
        {
            
        }
    }

    @Override
    public Position getFireCoordinates(Fleet enemyShips)
    {
        try
        {
            return player.getFireCoordinates(new FleetProxy(enemyShips));
        }
        catch(Exception e)
        {
            return new Position(0,0);
        }
    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips)
    {
        try
        {
            player.hitFeedBack(hit, new FleetProxy(enemyShips));
        }
        catch(Exception e)
        {
            
        }
    }


    @Override
    public void startRound(int round)
    {
        try
        {
            player.startRound(round);
        }
        catch(Exception e)
        {
            
        }
    }


    @Override
    public void endRound(int round, int shots, int enemyShots)
    {
        try
        {
            player.endRound(round, shots, enemyShots);
        }
        catch(Exception e)
        {
            
        }
    }

    @Override
    public void endMatch(int won, int lost, int draw)
    {
        try
        {
            player.endMatch(won, lost, draw);
        }
        catch(Exception e)
        {
            
        }
    }
    
}
