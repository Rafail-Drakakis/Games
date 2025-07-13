package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

/**
 * This class represents the Number four Card
 */
public class NumberFourCard extends NumberCard {
    /**
     * Constructs a new Number Four Card with a value of 4 and a label of "card4".
     */
    public NumberFourCard() {
        super(4, "card4");
    }

    /**
     * Moves the given pawn backward by 4 spaces on the board.
     *
     * @param pawn  The pawn to be moved.
     * @param board The game board on which the pawn is to be moved.
     * @return true if the pawn successfully moved backward by 4 spaces, false otherwise.
     */
    @Override
    public boolean movePawn(Pawn pawn, Board board) {
        if (pawn.isStart()) {
            return false;
        }
        return pawn.moveBackward(4, board);
    }
}
