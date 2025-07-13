package model.Square;

import model.Color.Color;

/**
 * Represents a start slide square in a board game.
 */
public class StartSlideSquare extends SlideSquare {
    /**
     * Constructs a StartSlideSquare object with the specified color.
     *
     * @param color The color of the StartSlideSquare.
     */
    public StartSlideSquare(Color color) {
        super(color);
    }
    /**
     * Determines if a player can move their game piece to this square.
     *
     * @param playerColor The color of the player's game piece.
     * @return true indicating that the player's game piece can move to this square unconditionally.
     */
    @Override
    public boolean CanMove(Color playerColor) {
        return true;
    }
}
