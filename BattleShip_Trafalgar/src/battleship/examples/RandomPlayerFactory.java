/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.examples;

import battleship.interfaces.BattleshipsPlayer;
import tournament.player.PlayerFactory;

/**
 *
 * @author Tobias Grundtvig
 */
public class RandomPlayerFactory implements PlayerFactory<BattleshipsPlayer>
{
    private static int nextID = 1;
    private final int id;

    public RandomPlayerFactory()
    {
        id = nextID++;
    }
    
    
    @Override // change with own player
    public BattleshipsPlayer getNewInstance()
    {
        return new RandomPlayer();
    }

    @Override // change with own player
    public String getID()
    {
        return "RND:"+id;
    }

    @Override // change with own player
    public String getName()
    {
        return "Random player " + id;
    }
    
}
