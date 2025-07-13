package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

/**
 * This class represents the Number five Card
 */

public class NumberFiveCard extends NumberCard
{
    /**
     * Constructs a new Number Five Card with a value of 5 and a label of "card5".
     */
    public NumberFiveCard()
    {
        super(5, "card5");
    }
    /**
     * Moves the given pawn forward by 5 spaces on the board.
     *
     * @param pawn The pawn to be moved.
     * @param board The game board on which the pawn is to be moved.
     * @return true if the pawn successfully moved forward by 5 spaces, false otherwise.
     * Precondition The pawn must not be in the start position.
     * Postcondition The pawn will be advanced by 5 spaces on the board if it is not in the start position.
     */
    @Override
    public boolean movePawn(Pawn pawn, Board board) {
        if(pawn.isStart()){
            return false;
        }

        return pawn.moveForward(5, board);
    }
}