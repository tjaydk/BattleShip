/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.interfaces;

/**
 *
 * @author Tobias Grundtvig
 */
public interface BattleshipsPlayer
{
    public void startMatch(int rounds);
    public void startRound(int round);
    public void placeShips(Fleet fleet, Board board);
    public void incoming(Position pos);
    public Position getFireCoordinates(Fleet enemyShips);
    public void hitFeedBack(boolean hit, Fleet enemyShips);
    public void endRound(int round, int points, int enemyPoints);
    public void endMatch(int won, int lost, int draw);
}
