/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package y42;

import battleship.interfaces.BattleshipsPlayer;
import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import battleship.interfaces.Board;
import battleship.interfaces.Ship;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Tobias
 */
public class Y42 implements BattleshipsPlayer {

    private final static SecureRandom rnd = new SecureRandom();
    private int sizeX;
    private int sizeY;
    private int x, y;
    private int shotSeq;
    private boolean hit;
    private boolean[][] shotsFired;

    public Y42() {
    }

    @Override
    public void placeShips(Fleet fleet, Board board) {
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        for (int i = 0; i < fleet.getNumberOfShips(); ++i) {
            Ship s = fleet.getShip(i);
            boolean vertical;
            Position pos;

            if (i == 0) {
                vertical = true;
                pos = new Position(3, 8);
                board.placeShip(pos, s, vertical);
            }
            if (i == 1) {
                vertical = false;
                pos = new Position(7, 4);
                board.placeShip(pos, s, vertical);
            }
            if (i == 2) {
                vertical = false;
                pos = new Position(5, 8);
                board.placeShip(pos, s, vertical);
            }
            if (i == 3) {
                vertical = false;
                pos = new Position(4, 1);
                board.placeShip(pos, s, vertical);
            }
            if (i == 4) {
                vertical = true;
                pos = new Position(1, 5);
                board.placeShip(pos, s, vertical);
            }
        }
    }

    @Override
    public void incoming(Position pos) {

        //Do nothing
    }

    @Override
    public Position getFireCoordinates(Fleet enemyShips) {
        shotSeq = 0;

        while (enemyShips.getNumberOfShips() != 0) {

            shotsFired = new boolean[sizeX][sizeY];

            if (shotSeq == 0) {
                fireModeOne();
            } else if (shotSeq == 1) {
                fireModeTwo();
            }

        }

        return new Position(x, y);
    }
    
    public Position fireModeOne() {
        for (int i = 0; i < sizeX; i++) {
                    x = i;
                    y = i;
                    if (x == sizeX && y == sizeY) {
                        shotSeq++;
                    }
                    shotsFired[i][i] = true;
                }
                    return new Position(x, y);
    }
    
    public Position fireModeTwo() {
        for (int i = 0; x < 0; i++) {
                    x = sizeX - i;
                    y = i;
                    if ((x == 5 && y == 4) || (x == 4 && y == 5)) {
                        x = x - 2;
                        y = y + 2;
                    }
                    if (x == 0 && y == sizeY) {
                        shotSeq++;
                    }
                    shotsFired[i][i] = true;
                }
                    return new Position(x, y);
    }
    
    public Position shipHit() {
        return new Position(x,y);
    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips) {
        this.hit = hit;
    }

    @Override
    public void startMatch(int rounds) {
        //Do nothing
    }

    @Override
    public void startRound(int round) {
        //Do nothing
    }

    @Override
    public void endRound(int round, int points, int enemyPoints) {
        //Do nothing
    }

    @Override
    public void endMatch(int won, int lost, int draw) {
        //Do nothing
    }
}
