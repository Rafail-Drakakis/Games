package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

/**
 * This class represents the Number three Card
 */
public class NumberThreeCard extends NumberCard {
    /**
     * Constructs a new Number Three Card with a value of 3 and a label of "card3".
     */
    public NumberThreeCard() {
        super(3, "card3");
    }

    /**
     * Moves the given pawn forward by 3 spaces on the board.
     *
     * @param pawn  The pawn to be moved.
     * @param board The game board on which the pawn is to be moved.
     * @return true if the pawn successfully moved forward by 3 spaces, false otherwise.
     */
    @Override
    public boolean movePawn(Pawn pawn, Board board) {
        if (pawn.isStart()) {
            return false;
        }
        return pawn.moveForward(3, board);
    }
}
