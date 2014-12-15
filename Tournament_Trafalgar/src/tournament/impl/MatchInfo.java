/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tournament.impl;

import tournament.game.GameResult;

/**
 *
 * @author Tobias
 */
public interface MatchInfo
{
    public ParticipantInfo getParticipantA();
    public ParticipantInfo getParticipantB();
    public GameResult getResult();
}
