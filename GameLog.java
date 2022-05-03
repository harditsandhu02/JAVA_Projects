/**
 * This class is where the PlayGame program uses to create a string version of a battleship game.
 * The code will then add the string to another txt file for easier viewing.
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Project 2 -- GameLog
 *
 * @author Hardit Sandhu
 * @version March 28, 2022
 */
public class GameLog {

    private int winningPlayer; 
    private int losingPlayerHits; 
    private int numTurns;
    private String boardPatternOne;
    private String boardPatternTwo;

    //Break up into mul lines
    public GameLog(
        int winningPlayer, 
        int losingPlayerHits, 
        int numTurns, 
        String boardPatternOne, 
        String boardPatternTwo) {

        this.winningPlayer = winningPlayer;
        this.losingPlayerHits = losingPlayerHits;
        this.numTurns = numTurns;
        this.boardPatternOne = boardPatternOne;
        this.boardPatternTwo = boardPatternTwo;

    }

    public String toString() {

        String p = "";
        if (winningPlayer == 1) {
            p = "17 - " + losingPlayerHits;
        } else if (winningPlayer == 2) {
            p = losingPlayerHits + " - 17";
        }
        //breakup into mulitple lines
        String finalString = "Battleship Game Log:\nWinning Player: Player " + 
            winningPlayer + "\nHits: " + p + 
            "\nNumber of Turns To Win: " + 
            numTurns + "\nPlayer 1 Board Pattern: " + 
            boardPatternOne + "\nPlayer 2 Board Pattern: " + 
            boardPatternTwo + "\n";
        return finalString;


    }




}