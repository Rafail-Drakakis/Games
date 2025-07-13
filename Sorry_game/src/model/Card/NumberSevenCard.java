package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

/**
 * This class represents the Number seven Card
 */
    public class NumberSevenCard extends NumberCard
{
    /**
     * Constructs a new Number Seven Card with a value of 7 and a label of "card7".
     */
    public NumberSevenCard()
    {
        super(7, "card7");
    }

    /**
     * Moves the given pawn forward by 7 spaces on the board.
     *
     * @param pawn The pawn to be moved.
     * @param board The game board on which the pawn is to be moved.
     * @return true if the pawn successfully moved forward by 7 spaces, false otherwise.
     */
    @Override
    public boolean movePawn(Pawn pawn, Board board) {
        if(pawn.isStart()){
            return false;
        }
        return pawn.moveForward(7, board);
    }
}
