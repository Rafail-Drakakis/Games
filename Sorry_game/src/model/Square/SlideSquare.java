package model.Square;

import model.Color.Color;

/**
 * Represents a slide square in a board game.
 */
public class SlideSquare extends Square {
    /**
     * Constructs a SlideSquare object with the specified color.
     *
     * @param c The color of the SlideSquare.
     */
    SlideSquare(Color c) {
        color = c;
        disabled = false;
    }
    /**
     * Determines if a player can move their game piece to this square.
     *
     * @param playerColor The color of the player's game piece.
     * @return true indicating that the player's game piece can move to this square unconditionally.
     */
    @Override
    boolean CanMove(Color playerColor) {
        return true;
    }
}
