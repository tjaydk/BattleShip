/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tournament.game;

/**
 *
 * @author Tobias
 * @param <PlayerType>
 */
public interface GameInstance<PlayerType>
{
    
    public GameResult run(PlayerType playerA, PlayerType playerB);
}
