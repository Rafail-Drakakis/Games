package model.Square;

import model.Color.Color;

/**
 * Represents a start square
 */
public class StartSquare extends Square {

    public StartSquare(Color color) {
        this.color = color;
    }

    /**
     * Determines whether the player can move to this square.
     *
     * @param playerColor The square to which the player intends to move.
     * @return Always returns false for a StartSquare, as it is not a valid move.
     * precondition The square_to_move parameter should be a non-negative integer.
     */
    @Override
    public boolean CanMove(Color playerColor) {
        return color == playerColor;
    }
}
