/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.implementations;

import battleship.interfaces.Board;
import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import battleship.interfaces.Ship;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Tobias
 */
class BoardImpl implements Board, Fleet
{
    private final int sizeX;
    private final int sizeY;
    private final ShipImpl[][] board;
    private final boolean[][] shots;
    private final List<ShipImpl> liveShips;

    public BoardImpl(int sizeX, int sizeY)
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        board = new ShipImpl[sizeX][sizeY];
        shots = new boolean[sizeX][sizeY];
        liveShips = new LinkedList<>();
    }

    @Override
    public int sizeX()
    {
        return sizeX;
    }

    @Override
    public int sizeY()
    {
        return sizeY;
    }

    @Override
    public void placeShip(Position pos, Ship ship, boolean vertical)
    {
        int x = pos.x;
        int y = pos.y;
        if(!(ship instanceof ShipImpl)) return;
        ShipImpl sh = (ShipImpl) ship;
        if(sh.isPlaced()) return;
        sh.place();
        for(int i = 0; i < sh.size(); ++i)
        {
            if(x < 0 || x >= sizeX || y < 0 || y >= sizeY)
            {
                sh.wreck();
            }
            else
            {
                ShipImpl other = board[x][y];
                if(other != null)
                {
                    if(!other.isWreck())
                    {
                        other.wreck();
                        liveShips.remove(other);
                    }
                    sh.wreck();
                }
                board[x][y] = sh;
            }
            if(vertical)
            {
                ++y;
            }
            else
            {
                ++x;
            }
        }
        if(!sh.isWreck())
        {
            liveShips.add(sh);
        }
    }
    
    public boolean fire(Position pos)
    {
        if(pos.x < 0 || pos.x >= sizeX || pos.y < 0 || pos.y >= sizeY)
        {
            return false;
        }
        if(shots[pos.x][pos.y])
        {
            return false;
        }
        shots[pos.x][pos.y] = true;
        ShipImpl ship = board[pos.x][pos.y];
        if(ship == null) return false;
        if(ship.isWreck()) return false;
        //We have a hit
        ship.hit();
        if(ship.isWreck())
        {
            liveShips.remove(ship);
        }
        return true;
    }

    @Override
    public int getNumberOfShips()
    {
        return liveShips.size();
    }

    @Override
    public Ship getShip(int index)
    {
        return liveShips.get(index);
    }
    
    
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        for(int y = sizeY-1; y >= 0; --y)
        {
            for(int x = 0; x < sizeX; ++x)
            {
                if(shots[x][y])
                {
                    res.append('*');
                    continue;
                }
                ShipImpl ship = board[x][y];
                if(ship == null)
                {
                    res.append('~');
                }
                else
                {
                    if(ship.isWreck())
                    {
                        res.append('W');
                    }
                    else
                    {
                        res.append('S');
                    }
                }
            }
            res.append('\n');
        }
        return res.toString();
    }
    
}
