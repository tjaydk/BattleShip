/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.implementations;

import battleship.interfaces.Fleet;
import battleship.interfaces.Ship;

/**
 *
 * @author Tobias
 */
class FleetProxy implements Fleet
{
    private final Fleet fleet;

    public FleetProxy(Fleet fleet)
    {
        this.fleet = fleet;
    }
    
    @Override
    public int getNumberOfShips()
    {
        return fleet.getNumberOfShips();
    }

    @Override
    public Ship getShip(int index)
    {
        return fleet.getShip(index);
    }
    
    @Override
    public String toString()
    {
        return "Nothing to see here.";
    }
    
}
