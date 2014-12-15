/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.interfaces;

/**
 *
 * @author Tobias
 */
public interface Board
{
    public int sizeX();
    public int sizeY();
    public void placeShip(Position pos, Ship ship, boolean vertical);
}
