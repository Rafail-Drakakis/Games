package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

/**
 * This class represents the Number two Card
 */
public class NumberTwoCard extends NumberCard {
    /**
     * Constructs a new Number Two Card with a value of 2 and a label of "card2".
     */
    public NumberTwoCard() {
        super(2, "card2");
    }

    /**
     * Moves the given pawn forward by 2 spaces on the board.
     *
     * @param pawn  The pawn to be moved.
     * @param board The game board on which the pawn is to be moved.
     * @return true if the pawn successfully moved forward by 2 spaces,  false otherwise.
     */
    @Override
    public boolean movePawn(Pawn pawn, Board board) {
        return pawn.moveForward(2, board);
    }

}
