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
import java.util.ArrayList;
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
    private int attemts;
    private int storeX, storeY;
    private int shotSeq;
    private int shotCount, hitCount, loopCount;
    private int numberOfShips;
    private boolean hit;
    private boolean battle;
    private boolean sunk;
    private int[][] shotsFired, shotsHit;
    private String direction;
    private ArrayList<Position> firedShots;
    private int lastHitX, lastHitY;

    public Y42() {
        x = 0;
        y = 0;
        k = 0;
        attemts = 0;
        shotCount = 0;
        hitCount = 0;
        shotSeq = 0;
        hit = false;
        battle = false;
        sunk = false;
        direction = "east";

        shotsHit = new int[sizeX][sizeY];

    }

    @Override
    public void placeShips(Fleet fleet, Board board) {
        int placeShip = rnd.nextInt(5);
        
        switch(placeShip) {
            case 0:
                placeShipOne(fleet, board);
                break;
            case 1:
                placeShipTwo(fleet, board);
                break;
            case 2:
                placeShipThree(fleet, board);
                break;
            case 3:
                placeShipFour(fleet, board);
                break;
            case 4:
                placeShipFive(fleet, board);
                break;
        }
    }

    @Override
    public void incoming(Position pos) {

        //Do nothing
    }

    @Override
    public Position getFireCoordinates(Fleet enemyShips) {
       if (enemyShips.getNumberOfShips() != 0) {
            attemts++;
            numberOfShips = enemyShips.getNumberOfShips();
            if (hit || battle) {
                if (!sunk) {
                    battle = true;
                    shipHit();
                    shotsFired[x][y] = 1;
                    return new Position(x, y);
                } else {
                    x = storeX;
                    y = storeY;
                    battle = false;
                    hitCount = 0;
                    direction = "east";
                    sunk = false;
                    return new Position(x, y);
                }
            } else {
                loopCount = 0;
                do {
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
                } while (shotsFired[x][y] != 0);
                shotsFired[x][y] = 1;
                return new Position(x, y);
            }
        }
        return null;
    }

    public void fireModeOne() {
        if (k < 10) {
            x = k;
            y = k;
            storeX = x;
            storeY = y;
            k++;
        } else {
            shotSeq++;
            k = 0;
        }
    }

    public void fireModeTwo() {
        if (k < 9) {
            if (!(x == 5 && y == 3)) {
                x--;
                y = k;
                storeX = x;
                storeY = y;
                k++;
            } else {
                x = x - 2;
                y = k + 1;
                k = k + 2;
                storeX = x;
                storeY = y;
            }
        } else {
            shotSeq++;
            k = 0;
        }

    }

    public void fireModeThree() {
        x = 4;
        if (k < 4) {
            switch (k) {
                case 0:
                    y = 0;
                    k++;
                    break;
                case 1:
                    y = 2;
                    k++;
                    break;
                case 2:
                    y = 6;
                    k++;
                    break;
                case 3:
                    y = 8;
                    k++;
                    break;
            }
            storeX = x;
            storeY = y;
        } else {
            shotSeq++;
            k = 0;
        }

    }

    public void fireModeFour() {
        y = 4;
        if (k < 4) {
            switch (k) {
                case 0:
                    x = 0;
                    k++;
                    break;
                case 1:
                    x = 2;
                    k++;
                    break;
                case 2:
                    x = 6;
                    k++;
                    break;
                case 3:
                    x = 8;
                    k++;
                    break;
            }
            storeX = x;
            storeY = y;
        } else {
            shotSeq++;
            k = 0;
        }
    }

    public void fireModeFive() {
        if (k < 74) {
            switch (k) {
                case 0:
                    x = 1;
                    y = 9;
                    k++;
                    break;
                case 1:
                    x = 5;
                    y = 9;
                    k++;
                    break;
                case 2:
                    x = 9;
                    y = 1;
                    k++;
                    break;
                case 3:
                    x = 9;
                    y = 5;
                    k++;
                    break;
                case 4:
                    x = 3;
                    y = 1;
                    k++;
                    break;
                case 5:
                    x = 5;
                    y = 1;
                    k++;
                    break;
                case 6:
                    x = 0;
                    y = 2;
                    k++;
                    break;
                case 7:
                    x = 0;
                    y = 6;
                    k++;
                    break;
                case 8:
                    x = 8;
                    y = 2;
                    k++;
                    break;
                case 9:
                    x = 7;
                    y = 3;
                    k++;
                    break;
                case 10:
                    x = 5;
                    y = 7;
                    k++;
                    break;
                case 11:
                    x = 6;
                    y = 8;
                    k++;
                    break;
                case 12:
                    x = 2;
                    y = 8;
                    k++;
                    break;
                case 13:
                    x = 3;
                    y = 7;
                    k++;
                    break;
                case 14:
                    x = 1;
                    y = 3;
                    k++;
                    break;
                case 15:
                    x = 1;
                    y = 5;
                    k++;
                    break;
                case 16:
                    x = 7;
                    y = 5;
                    k++;
                    break;
                case 17:
                    x = 8;
                    y = 6;
                    k++;
                    break;
                case 18:
                    x = 2;
                    y = 0;
                    k++;
                    break;
                case 19:
                    x = 0;
                    y = 6;
                    k++;
                    break;
                case 20:
                    x = 3;
                    y = 9;
                    k++;
                    break;
                case 21:
                    x = 7;
                    y = 9;
                    k++;
                    break;
                case 22:
                    x = 9;
                    y = 3;
                    k++;
                    break;
                case 23:
                    x = 9;
                    y = 7;
                    k++;
                    break;
                case 24:
                    do {
                        x = rnd.nextInt(sizeX);
                        y = rnd.nextInt(sizeY);
                    } while (shotsFired[x][y] != 0);
                    break;
            }
            storeX = x;
            storeY = y;

        }

    }

    public void shipHit() {

        if (loopCount > 4) {
            battle = false;
        }

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

    public void hitNorth() {
        if (hit) {
            if (y > 0) {
                y = y - 1;
                shotCount++;
            } else if (hitCount > 1) {
                direction = "south";
                y = y + hitCount;
                shotCount = 0;
            } else {
                direction = "east";
                x++;
                shotCount = 0;
            }
        } else if (hitCount > 1) {
            direction = "south";
            y = y + hitCount + 1;
            shotCount = 0;
            loopCount++;
        } else {
            direction = "east";
            y++;
            x++;
            shotCount = 0;
            loopCount++;
        }

    }

    public void hitSouth() {
        if (hit) {
            if (y < 9) {
                y = y + 1;
                shotCount++;
            } else if (hitCount > 1) {
                direction = "north";
                y = y - hitCount;
                shotCount = 0;
            } else {
                direction = "west";
                x--;
                shotCount = 0;
            }
        } else if (hitCount > 1) {
            direction = "north";
            y = y - hitCount - 1;
            shotCount = 0;
            loopCount++;
        } else {
            direction = "west";
            y--;
            x--;
            shotCount = 0;
            loopCount++;
        }
    }

    public void hitEast() {
        if (hit) {
            if (x < 9) {
                x++;
                shotCount++;

            } else if (hitCount > 1) {
                direction = "west";
                x = x - hitCount;
                shotCount = 0;
            } else {
                direction = "south";
                y++;
                shotCount = 0;
            }
        } else if (hitCount > 1) {
            direction = "west";
            x = x - hitCount - 1;
            shotCount = 0;
            loopCount++;
        } else {
            direction = "south";
            x--;
            y++;
            shotCount = 0;
            loopCount++;
        }
    }

    public void hitWest() {
        if (hit) {
            if (x > 0) {
                x = x - 1;
                shotCount++;
            } else if (hitCount > 1) {
                direction = "east";
                x = x + hitCount;
                shotCount = 0;
            } else {
                direction = "north";
                y--;
                shotCount = 0;
            }
        } else if (hitCount > 1) {
            direction = "east";
            x = x + hitCount + 1;
            shotCount = 0;
            loopCount++;
        } else {
            direction = "north";
            x++;
            y--;
            shotCount = 0;
            loopCount++;
        }
    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips) {
        if (enemyShips.getNumberOfShips() == 0) {
            x = 0;
            y = 0;
            k = 0;
            attemts = 0;
            storeX = 0;
            storeY = 0;
            loopCount = 0;
            hitCount = 0;
            shotCount = 0;
            shotSeq = 0;
            direction = "east";
            hit = false;
            battle = false;
            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    shotsFired[i][j] = 0;
                }
            }

        } else if (numberOfShips != enemyShips.getNumberOfShips()) {
            if (enemyShips.getNumberOfShips() < numberOfShips) {
                sunk = true;
            } else {
                //System.out.println("LAST SHIP SUNK - X: " + x + " Y: " + y + " ATTEMTS: " + attemts);
                x = 0;
                y = 0;
                k = 0;
                attemts = 0;
                storeX = 0;
                storeY = 0;
                loopCount = 0;
                hitCount = 0;
                shotCount = 0;
                shotSeq = 0;
                direction = "east";
                hit = false;
                battle = false;
                for (int i = 0; i < sizeX; i++) {
                    for (int j = 0; j < sizeY; j++) {
                        shotsFired[i][j] = 0;
                    }
                }
            }
        }
        this.hit = hit;
        if (hit) {
            hitCount++;
        }
    }

    @Override
    public void startMatch(int rounds
    ) {
        //Do nothing
    }

    @Override
    public void startRound(int round
    ) {
        //Do nothing
    }

    @Override
    public void endRound(int round, int points, int enemyPoints
    ) {
        //Do nothing
    }

    @Override
    public void endMatch(int won, int lost, int draw
    ) {
        //Do nothing
    }

    public void placeShipOne(Fleet fleet, Board board) {
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        shotsFired = new int[sizeX][sizeY];
        for (int i = 0; i < fleet.getNumberOfShips(); ++i) {
            Ship s = fleet.getShip(i);
            boolean vertical;
            Position pos;

            if (i == 0) {
                vertical = true;
                pos = new Position(3, 7);
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
                pos = new Position(9, 5);
                board.placeShip(pos, s, vertical);
            }
        }
    }

    public void placeShipTwo(Fleet fleet, Board board) {
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        shotsFired = new int[sizeX][sizeY];
        for (int i = 0; i < fleet.getNumberOfShips(); ++i) {
            Ship s = fleet.getShip(i);
            boolean vertical;
            Position pos;

            if (i == 0) {
                vertical = true;
                pos = new Position(8, 6);
                board.placeShip(pos, s, vertical);
            }
            if (i == 1) {
                vertical = false;
                pos = new Position(6, 9);
                board.placeShip(pos, s, vertical);
            }
            if (i == 2) {
                vertical = false;
                pos = new Position(0, 3);
                board.placeShip(pos, s, vertical);
            }
            if (i == 3) {
                vertical = false;
                pos = new Position(2, 1);
                board.placeShip(pos, s, vertical);
            }
            if (i == 4) {
                vertical = true;
                pos = new Position(4, 5);
                board.placeShip(pos, s, vertical);
            }
        }
    }

    public void placeShipThree(Fleet fleet, Board board) {
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        shotsFired = new int[sizeX][sizeY];
        for (int i = 0; i < fleet.getNumberOfShips(); ++i) {
            Ship s = fleet.getShip(i);
            boolean vertical;
            Position pos;

            if (i == 0) {
                vertical = false;
                pos = new Position(6, 9);
                board.placeShip(pos, s, vertical);
            }
            if (i == 1) {
                vertical = true;
                pos = new Position(7, 5);
                board.placeShip(pos, s, vertical);
            }
            if (i == 2) {
                vertical = true;
                pos = new Position(2, 6);
                board.placeShip(pos, s, vertical);
            }
            if (i == 3) {
                vertical = false;
                pos = new Position(1, 9);
                board.placeShip(pos, s, vertical);
            }
            if (i == 4) {
                vertical = true;
                pos = new Position(9, 5);
                board.placeShip(pos, s, vertical);
            }
        }
    }

    public void placeShipFour(Fleet fleet, Board board) {
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        shotsFired = new int[sizeX][sizeY];
        for (int i = 0; i < fleet.getNumberOfShips(); ++i) {
            Ship s = fleet.getShip(i);
            boolean vertical;
            Position pos;

            if (i == 0) {
                vertical = true;
                pos = new Position(8, 1);
                board.placeShip(pos, s, vertical);
            }
            if (i == 1) {
                vertical = false;
                pos = new Position(2, 6);
                board.placeShip(pos, s, vertical);
            }
            if (i == 2) {
                vertical = false;
                pos = new Position(0, 9);
                board.placeShip(pos, s, vertical);
            }
            if (i == 3) {
                vertical = true;
                pos = new Position(6, 5);
                board.placeShip(pos, s, vertical);
            }
            if (i == 4) {
                vertical = false;
                pos = new Position(0, 3);
                board.placeShip(pos, s, vertical);
            }
        }
    }

    public void placeShipFive(Fleet fleet, Board board) {
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        shotsFired = new int[sizeX][sizeY];
        for (int i = 0; i < fleet.getNumberOfShips(); ++i) {
            Ship s = fleet.getShip(i);
            boolean vertical;
            Position pos;

            if (i == 0) {
                vertical = false;
                pos = new Position(5, 4);
                board.placeShip(pos, s, vertical);
            }
            if (i == 1) {
                vertical = true;
                pos = new Position(0, 1);
                board.placeShip(pos, s, vertical);
            }
            if (i == 2) {
                vertical = true;
                pos = new Position(9, 6);
                board.placeShip(pos, s, vertical);
            }
            if (i == 3) {
                vertical = true;
                pos = new Position(9, 1);
                board.placeShip(pos, s, vertical);
            }
            if (i == 4) {
                vertical = false;
                pos = new Position(2, 9);
                board.placeShip(pos, s, vertical);
            }
        }
    }
}
