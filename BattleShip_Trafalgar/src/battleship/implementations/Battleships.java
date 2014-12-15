package battleship.implementations;

import battleship.interfaces.BattleshipsPlayer;
import tournament.game.GameFactory;
import tournament.game.GameInstance;

/**
 *
 * @author Tobias Grundtvig
 */
public class Battleships
{
    private static GameFactory<BattleshipsPlayer> factory = null;
    
    public static GameFactory<BattleshipsPlayer> getGameFactory()
    {
        if(factory == null)
        {
            int[] ships = {2,3,3,4,5};
            factory = new BattleshipsGameFactory(10, 10, ships, 1000);
        }
        return factory;
    }
    
    public static GameInstance<BattleshipsPlayer> getSingleGameInstance()
    {
        int[] ships = {2,3,3,4,5};
        return new BattleshipsGameInstance(10, 10, ships, 1000);
    }
}
