package model.Square;

import model.Color.Color;

/**
 * Represents a simple square.
 */
public class SimpleSquare extends Square {
    /**
     * Constructs a SimpleSquare object with default settings.
     */
    public SimpleSquare() {
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
