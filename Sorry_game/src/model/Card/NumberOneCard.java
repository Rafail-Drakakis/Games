package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

/**
 * This class represents the Number one Card
 */
public class NumberOneCard extends NumberCard
{
    /**
     * Constructs a new Number One Card with a value of 1 and a label of "card1".
     */
    public NumberOneCard()
    {
        super(1, "card1");
    }

    /**
     * Moves the given pawn forward by 1 space on the board.
     *
     * @param pawn The pawn to be moved.
     * @param board The game board on which the pawn is to be moved.
     * @return true if the pawn successfully moved forward by 1 space, false otherwise.
     */
    @Override
    public boolean movePawn(Pawn pawn, Board board) {
        return pawn.moveForward(1, board);
    }
}
