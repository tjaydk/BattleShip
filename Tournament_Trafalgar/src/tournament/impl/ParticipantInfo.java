/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tournament.impl;

import tournament.player.PlayerInfo;

/**
 *
 * @author Tobias
 */
public interface ParticipantInfo extends PlayerInfo, Comparable<ParticipantInfo>
{
    public int getMatchesWon();
    public int getMatchesLost();
    public int getMatchesDraw();
    public int getMajorPoints();
    public int getMinorPoints();
}
