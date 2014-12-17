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
    private int x, y, k;
    private int shotSeq;
    private int shotCount, hitCount;
    private int numberOfShips;
    private boolean hit;
    private boolean lastHit;
    private boolean battle;
    private boolean[][] shotsFired;
    private String direction;
    private int lastHitX, lastHitY;

    public Y42() {
        direction = null;
        shotCount = 0;
        hitCount = 0;
        shotSeq = 0;

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
                pos = new Position(9, 9);
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
        
        shotsFired = new boolean[sizeX][sizeY];
        numberOfShips = enemyShips.getNumberOfShips();

        while (enemyShips.getNumberOfShips() != 0) {

            if (hit || battle) {
                if (enemyShips.getNumberOfShips() == numberOfShips) {
                    battle = true;
                    lastHit = true;
                    hitCount++;
                    shipHit();
                } else {
                    battle = false;
                    hitCount = 0;
                }
            } 
            else {
                switch (shotSeq) {
                    case 0:
                        fireModeOne();
                        break;
                    case 1:
                        fireModeTwo();
                        break;
                    case 2:
                        fireModeThree();
                        break;
                    case 3:
                        fireModeFour();
                        break;
                    case 4:
                        fireModeFive();
                        break;
                }
            }

            shotsFired[x][y] = true;
            return new Position(x, y);
        }
        return null;

    }

    public void fireModeOne() {
        for (int i = 0; k < 10; k++) {
            x = i;
            y = i;
            if (x == 10) {
                shotSeq++;
                k = 0;
            }
            shotsFired[i][i] = true;
            
        }
        
    }

    public void fireModeTwo() {
        for (int i = 0; k < 8; k++) {
            x = sizeX - 1 - i;
            y = i;
            if (x == 4 && y == 4) {
                x = x - 1;
                y = y + 1;
            }
            if (x == 0) {
                shotSeq++;
                k = 0;
            }
            shotsFired[i][i] = true;
            
        }
        
    }

    public void fireModeThree() {
        x = 4;
        for (int i = 0; k < 4; k++) {
            switch (i) {
                case 0:
                    y = 0;
                    break;
                case 1:
                    y = 2;
                    break;
                case 2:
                    y = 6;
                    break;
                case 3:
                    y = 8;
                    shotSeq++;
                    k = 0;
                    break;
            }
            
        }
        
    }

    public void fireModeFour() {
        y = 4;
        for (int i = 0; k < 4; k++) {
            switch (i) {
                case 0:
                    x = 0;
                    break;
                case 1:
                    x = 2;
                    break;
                case 2:
                    x = 6;
                    break;
                case 3:
                    x = 8;
                    shotSeq++;
                    k = 0;
                    break;
            }
            
        }
        
    }

    public void fireModeFive() {
        for (int i = 0; k < 24; k++) {
            switch (i) {
                case 0:
                    x = 1;
                    y = 9;
                    break;
                case 1:
                    x = 5;
                    y = 9;
                    break;
                case 2:
                    x = 9;
                    y = 1;
                    break;
                case 3:
                    x = 9;
                    y = 5;
                    break;
                case 4:
                    x = 3;
                    y = 1;
                    break;
                case 5:
                    x = 5;
                    y = 1;
                    break;
                case 6:
                    x = 0;
                    y = 3;
                    break;
                case 7:
                    x = 0;
                    y = 7;
                    break;
                case 8:
                    x = 8;
                    y = 2;
                    break;
                case 9:
                    x = 7;
                    y = 3;
                    break;
                case 10:
                    x = 5;
                    y = 7;
                    break;
                case 11:
                    x = 6;
                    y = 8;
                    break;
                case 12:
                    x = 2;
                    y = 8;
                    break;
                case 13:
                    x = 3;
                    y = 7;
                    break;
                case 14:
                    x = 1;
                    y = 3;
                    break;
                case 15:
                    x = 1;
                    y = 5;
                    break;
                case 16:
                    x = 7;
                    y = 5;
                    break;
                case 17:
                    x = 8;
                    y = 6;
                    break;
                case 18:
                    x = 0;
                    y = 3;
                    break;
                case 19:
                    x = 0;
                    y = 7;
                    break;
                case 20:
                    x = 3;
                    y = 9;
                    break;
                case 21:
                    x = 7;
                    y = 9;
                    break;
                case 22:
                    x = 9;
                    y = 3;
                    break;
                case 23:
                    x = 9;
                    y = 7;
                    break;
            }
            
        }
        
    }

    public void shipHit() {
        direction = "east";

        while (x != lastHitX && y != lastHitY) {
            switch (direction) {
                case "north":
                    hitNorth();
                    break;
                case "south":
                    hitSouth();
                    break;
                case "east":
                    hitEast();
                    break;
                case "west":
                    hitWest();
                    break;
            }
        }
    }

    public void hitNorth() {
        if (hit) {
            if (lastHitY != 0) {
                x = lastHitX;
                y = lastHitY - 1;
                shotCount++;
            } else if (hitCount > 1) {
                direction = "south";
                y = y + shotCount + 1;
                shotCount = 0;
            } else {
                direction = "east";
            }
        } else if (hitCount > 1) {
            direction = "south";
            y = y + shotCount + 1;
            shotCount = 0;
        }

    }

    public void hitSouth() {
        if (hit) {
            if (lastHitY != 9) {
                x = lastHitX;
                y = lastHitY + 1;
                shotCount++;
            } else if (hitCount > 1) {
                direction = "north";
                y = y - shotCount - 1;
                shotCount = 0;
            } else {
                direction = "west";
            }
        } else if (hitCount > 1) {
            direction = "north";
            y = y - shotCount - 1;
            shotCount = 0;
        }
    }

    public void hitEast() {
        if (hit) {
            if (lastHitX != 9) {
                x = lastHitX + 1;
                y = lastHitY;
                shotCount++;
            } else if (hitCount > 1) {
                direction = "west";
                x = x - shotCount - 1;
                shotCount = 0;
            } else {
                direction = "south";
            }
        } else if (hitCount > 1) {
            direction = "west";
            x = x - shotCount - 1;
            shotCount = 0;
        }
    }

    public void hitWest() {
        if (hit) {
            if (lastHitX != 0) {
                x = lastHitX - 1;
                y = lastHitY;
                shotCount++;
            } else if (hitCount > 1) {
                direction = "east";
                x = x + shotCount + 1;
                shotCount = 0;
            } else {
                direction = "north";
            }
        } else if (hitCount > 1) {
            direction = "east";
            x = x + shotCount + 1;
            shotCount = 0;
        }
    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips) {
        if (hit) {
            lastHitX = x;
            lastHitY = y;
        }
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
