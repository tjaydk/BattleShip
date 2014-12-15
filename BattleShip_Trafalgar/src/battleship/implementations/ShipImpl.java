/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.implementations;

import battleship.interfaces.Ship;


/**
 *
 * @author Tobias
 */
class ShipImpl implements Ship
{
    private final int size;
    private int hits;
    private boolean isWreck;
    private boolean isPlaced;
    

    public ShipImpl(int size)
    {
        this.size = size;
        this.hits = 0;
        this.isWreck = false;
        this.isPlaced = false;
    }
    
    public void hit()
    {
        ++hits;
        if(hits == size)
        {
            isWreck = true; 
        }
    }
    
    public boolean isWreck()
    {
        return isWreck;
    }

    public boolean isPlaced()
    {
        return isPlaced;
    }

    public void wreck()
    {
        this.isWreck = true;
    }

    public void place()
    {
        this.isPlaced = true;
    }

    @Override
    public int size()
    {
        return size;
    }
    
    
}
