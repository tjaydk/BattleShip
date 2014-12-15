/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tournament.ui;

import java.util.List;
import tournament.impl.MatchInfo;
import tournament.impl.ParticipantInfo;

/**
 *
 * @author Tobias
 */
public interface TournamentUI
{
    public void tournamentReady(String gameName, ParticipantInfo[] participants, MatchInfo[] matches);
    public void matchStarted(int matchIndex);
    public void matchFinished(int matchIndex);
    public void tournamentFinished(List<ParticipantInfo> sortedParticipants);
}
