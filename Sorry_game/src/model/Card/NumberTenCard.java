package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

/**
 * This class represents the Number ten Card
 */
    public class NumberTenCard extends NumberCard
{
    /**
     * Constructs a new Number Ten Card with a value of 10 and a label of "card10".
     */
    public NumberTenCard()
    {
        super(10, "card10");
    }
    /**
     * Moves the given pawn forward by 10 spaces on the board.
     *
     * @param pawn The pawn to be moved.
     * @param board The game board on which the pawn is to be moved.
     * @return true if the pawn successfully moved forward by 10 spaces, false otherwise.
     */
    @Override
    public boolean movePawn(Pawn pawn, Board board) {
        if(pawn.isStart()){
            return false;
        }
        return pawn.moveForward(10, board);
    }
}
