/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package y42;

import battleship.interfaces.BattleshipsPlayer;
import tournament.player.PlayerFactory;

/**
 *
 * @author Tobias Grundtvig
 */
public class Y42Factory implements PlayerFactory<BattleshipsPlayer>
{
    private static int nextID = 1;
    private final int id;

    public Y42Factory()
    {
        id = nextID++;
    }
    
    
    @Override
    public BattleshipsPlayer getNewInstance()
    {
        return new Y42();
    }

    @Override
    public String getID()
    {
        return "RND:"+id;
    }

    @Override
    public String getName()
    {
        return "Why 42 " + id;
    }
    
}
