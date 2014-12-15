/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package y42;

import battleship.interfaces.Board;
import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import battleship.interfaces.Ship;
import java.security.SecureRandom;

/**
 *
 * @author Ebbe
 */
public class Placement {
    SecureRandom rnd = new SecureRandom();
    int sizeX = 10;
    int sizeY = 10;

    public void placeShips(Fleet fleet, Board board) {
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        for (int i = 0; i < fleet.getNumberOfShips(); ++i) {
            Ship s = fleet.getShip(i);
            boolean vertical;
            Position pos;
            
            if (i == 0) {
                vertical = true;
                pos = new Position(3,8);
                board.placeShip(pos, s, vertical);
            }
            if (i == 1) {
                vertical = false;
                pos = new Position(7,4);
                board.placeShip(pos, s, vertical);
            }
            if (i == 2) {
                vertical = false;
                pos = new Position(5,8);
                board.placeShip(pos, s, vertical);
            }
            if (i == 3) {
                vertical = false;
                pos = new Position(4,1);
                board.placeShip(pos, s, vertical);
            }
            if (i == 4) {
                vertical = true;
                pos = new Position(1,5);
                board.placeShip(pos, s, vertical);
            }
        }
    }
}
