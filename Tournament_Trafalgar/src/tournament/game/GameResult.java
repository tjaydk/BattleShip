/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tournament.game;

/**
 *
 * @author Tobias Grundtvig
 */
public class GameResult
{
    public final int majorPointsA;
    public final int minorPointsA;
    public final int majorPointsB;
    public final int minorPointsB;

    public GameResult(int majorPointsA, int minorPointsA, int majorPointsB, int minorPointsB)
    {
        this.majorPointsA = majorPointsA;
        this.minorPointsA = minorPointsA;
        this.majorPointsB = majorPointsB;
        this.minorPointsB = minorPointsB;
    }
    
    @Override
    public String toString()
    {
        return "A: (" + majorPointsA + ":" + minorPointsA + ") B: (" + majorPointsB + ":" + minorPointsB + ")";
    }
}
