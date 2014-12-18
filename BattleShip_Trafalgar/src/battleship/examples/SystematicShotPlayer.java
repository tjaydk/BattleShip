/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.examples;

import battleship.interfaces.BattleshipsPlayer;
import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import battleship.interfaces.Board;
import battleship.interfaces.Ship;
import java.util.Random;

/**
 *
 * @author Tobias
 */
public class SystematicShotPlayer implements BattleshipsPlayer
{
    private final static Random rnd = new Random();
    private int sizeX;
    private int sizeY;
    
    private int nextX;
    private int nextY;

    public SystematicShotPlayer()
    {
    }

    @Override
    public void placeShips(Fleet fleet, Board board)
    {
        nextX = 0;
        nextY = 0;
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        for(int i = 0; i < fleet.getNumberOfShips(); ++i)
        {
            Ship s = fleet.getShip(i);
            boolean vertical = rnd.nextBoolean();
            Position pos;
            if(vertical)
            {
                int x = rnd.nextInt(sizeX);
                int y = rnd.nextInt(sizeY-(s.size()-1));
                pos = new Position(x, y);
            }
            else
            {
                int x = rnd.nextInt(sizeX-(s.size()-1));
                int y = rnd.nextInt(sizeY);
                pos = new Position(x, y);
            }
            board.placeShip(pos, s, vertical);
        }
    }

    @Override
    public void incoming(Position pos)
    {
        
        //Do nothing
    }

    @Override
    public Position getFireCoordinates(Fleet enemyShips)
    {
        Position shot = new Position(nextX, nextY);
        ++nextX;
        if(nextX >= sizeX)
        {
            nextX = 0; 
            ++nextY;
            if(nextY >= sizeY)
            {
                nextY = 0;
            }
        }
        return shot;
    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips)
    {
        //Do nothing
    }

    @Override
    public void startMatch(int rounds)
    {
        //Do nothing
    }

    @Override
    public void startRound(int round)
    {
        //Do nothing
    }

    @Override
    public void endRound(int round, int points, int enemyPoints)
    {
        //Do nothing
    }

    @Override
    public void endMatch(int won, int lost, int draw)
    {
        //Do nothing
    }
}
