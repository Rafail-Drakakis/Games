package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

/**
 * This class represents the Number twelve Card
 */
public class NumberTwelveCard extends NumberCard {
    /**
     * Constructs a new Number Twelve Card with a value of 12 and a label of "card12".
     */
    public NumberTwelveCard() {
        super(12, "card12");
    }

    /**
     * Moves the given pawn forward by 12 spaces on the board.
     *
     * @param pawn  The pawn to be moved.
     * @param board The game board on which the pawn is to be moved.
     * @return true if the pawn successfully moved forward by 12 spaces, false otherwise.
     */
    @Override
    public boolean movePawn(Pawn pawn, Board board) {
        if (pawn.isStart()) {
            return false;
        }
        return pawn.moveForward(12, board);
    }
}