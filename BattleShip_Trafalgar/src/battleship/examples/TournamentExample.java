/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.examples;

import battleship.interfaces.BattleshipsPlayer;
import battleship.implementations.Battleships;
import java.util.ArrayList;
import tournament.Tournament;
import tournament.game.GameFactory;
import tournament.player.PlayerFactory;

/**
 *
 * @author Tobias Grundtvig
 */
public class TournamentExample
{
    public static void main(String[] args)
    {
        //Create player list
        ArrayList<PlayerFactory<BattleshipsPlayer>> playerFactories = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
        {
            playerFactories.add(new RandomPlayerFactory());
            playerFactories.add(new SystematicShotPlayerFactory());
        }
        //Create game factory
        GameFactory<BattleshipsPlayer> gameFactory = Battleships.getGameFactory();
        Tournament.run(gameFactory, playerFactories, 8); //Running with 8 threads... 
    }
}
