/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.interfaces;

/**
 *
 * @author Tobias
 */
public class Position implements Comparable<Position>
{
    public final int x;
    public final int y;
    
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 89 * hash + this.x;
        hash = 89 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Position other = (Position) obj;
        if (this.x != other.x)
        {
            return false;
        }
        if (this.y != other.y)
        {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Position o)
    {
        int c = y - o.y;
        if(c != 0) return c;
        return x - o.x;
    }   
}
