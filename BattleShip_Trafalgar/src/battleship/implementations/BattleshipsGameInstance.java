/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.implementations;

import battleship.interfaces.Position;
import battleship.interfaces.BattleshipsPlayer;
import tournament.game.GameInstance;
import tournament.game.GameResult;

/**
 *
 * @author Tobias Grundtvig
 */
class BattleshipsGameInstance implements GameInstance<BattleshipsPlayer>
{
    private final int sizeX;
    private final int sizeY;
    private final int[] ships;
    private final int rounds;

    public BattleshipsGameInstance(int sizeX, int sizeY, int[] ships, int rounds)
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.ships = ships;
        this.rounds = rounds;
    }
    
    
    @Override
    public GameResult run(BattleshipsPlayer playerA, BattleshipsPlayer playerB)
    {
        //Wrap players in proxys to avoid exploits and exceptions...
        BattleshipsPlayer pA = new ProxyPlayer(playerA);
        BattleshipsPlayer pB = new ProxyPlayer(playerB);
        
        int winsA = 0;
        int winsB = 0;
        pA.startMatch(rounds);
        pB.startMatch(rounds);
        for(int i = 0; i < rounds; ++i)
        {
            StartFleet fleetA = new StartFleet(ships);
            StartFleet fleetB = new StartFleet(ships);
            BoardImpl boardA = new BoardImpl(sizeX, sizeY);
            BoardImpl boardB = new BoardImpl(sizeX, sizeY);
            //Begin round
            pA.startRound(i);
            pB.startRound(i);
            //Place ships
            pA.placeShips(fleetA, boardA);
            pB.placeShips(fleetB, boardB);
            /*
            System.out.println("Player A board: ");
            System.out.println(boardA);
            System.out.println("Player B board: ");
            System.out.println(boardB);
            */
            //Attack
            int pointsB = fireSession(pB, pA, boardA);
            int pointsA = fireSession(pA, pB, boardB);
            pA.endRound(i+1, pointsA, pointsB);
            pB.endRound(i+1, pointsB, pointsA);
            if(pointsA > pointsB) ++winsA;
            else if(pointsB > pointsA) ++winsB;
        }
        int draws = rounds-winsA-winsB;
        pA.endMatch(winsA, winsB, draws);
        pB.endMatch(winsB, winsA, draws);
        int majorA = 0;
        int majorB = 0;
        if(winsA > winsB)
        {
            majorA = 1;
            majorB = -1;
        }
        else if (winsB > winsA)
        {
            majorA = -1;
            majorB = 1;
        }
        return new GameResult(majorA, winsA, majorB, winsB);
    }
    
    private int fireSession(BattleshipsPlayer attacker, BattleshipsPlayer defender, BoardImpl board)
    {
        int maxShots = sizeX * sizeY;
        int shots = 0;
        while(board.getNumberOfShips() > 0 && shots < maxShots)
        {
            Position pos = attacker.getFireCoordinates(board);
            boolean hit = board.fire(pos);
            attacker.hitFeedBack(hit, board);
            defender.incoming(pos);
            ++shots;
        }
        return maxShots - shots;
    }
    
}