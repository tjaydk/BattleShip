/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tournament.player;

/**
 *
 * @author Tobias
 * @param <PlayerType>
 */
public interface PlayerFactory<PlayerType> extends PlayerInfo
{
    public PlayerType getNewInstance();
}
