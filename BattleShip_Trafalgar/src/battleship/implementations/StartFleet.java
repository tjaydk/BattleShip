/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.implementations;

import battleship.interfaces.Fleet;
import battleship.interfaces.Ship;



/**
 *
 * @author Tobias
 */
class StartFleet implements Fleet
{
    private final ShipImpl[] ships;

    public StartFleet(int[] shipSizes)
    {
        this.ships = new ShipImpl[shipSizes.length];
        for(int i = 0; i < ships.length; ++i)
        {
            ships[i] = new ShipImpl(shipSizes[i]);
        }
    }

    @Override
    public int getNumberOfShips()
    {
        return ships.length;
    }

    @Override
    public Ship getShip(int index)
    {
        return ships[index];
    }
    
}
