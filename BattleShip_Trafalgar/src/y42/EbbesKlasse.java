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
public class EbbesKlasse {

    int x, y;
    boolean hit;
    int sizeX, sizeY;
    int count;
    int lastHitX, lastHitY;

    public EbbesKlasse() {
        sizeX = 10;
        sizeY = 10;
    }

    public Position shipHit() {

        if (lastHitX != sizeX) {
            x = lastHitX + 1;
            y = y;
        }

        return new Position(x, y);
    }

    
}
