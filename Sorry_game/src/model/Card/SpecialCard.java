package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

/**
 * This class represents a special Card
 */

public class SpecialCard extends Card {
    /**
     * Constructs a new Special Card with the given value and image path.
     *
     * @param value   The value associated with the special card.
     * @param imgPath The path to the image representing the special card.
     */
    public SpecialCard(int value, String imgPath) {
        this.value = value;
        this.image = imgPath;
    }

    /**
     * Moves the given pawn forward by 0 spaces on the board.
     *
     * @param pawn  The pawn to be moved.
     * @param board The game board on which the pawn is to be moved.
     * @return False as a special card does not enable any movement for the pawn.
     */
    @Override
    public boolean movePawn(Pawn pawn, Board board) {
        if (!pawn.isStart()) {
            return false;
        }
        return pawn.moveForward(0, board);
    }
}