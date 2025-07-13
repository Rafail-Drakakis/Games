package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

/**
 * This class represents the Number eleven Card
 */
public class NumberElevenCard extends NumberCard {
    public NumberElevenCard() {
        super(11, "card11");
    }

    /**
     * Moves the given pawn forward by 11 spaces on the board.
     *
     * @param pawn  The pawn to be moved.
     * @param board The game board on which the pawn is to be moved.
     * @return true if the pawn successfully moved forward by 11 spaces, false otherwise.
     */
    @Override
    public boolean movePawn(Pawn pawn, Board board) {
        if (pawn.isStart()) {
            return false;
        }

        return pawn.moveForward(11, board);
    }
}