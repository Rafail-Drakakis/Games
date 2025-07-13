package model.Square;

import model.Color.Color;

/**
 * Represents a home square.
 */
public class HomeSquare extends Square {
    /**
     * Constructs a HomeSquare object with the specified color.
     *
     * @param c The color of the HomeSquare.
     */
    public HomeSquare(Color c) {
        color = c;
        disabled = false;
    }
    /**
     * Determines if a player can move their game piece to this square.
     *
     * @param playerColor The color of the player's game piece.
     * @return true if the player's game piece can move to this square (color matches), false otherwise.
     */
    @Override
    boolean CanMove(Color playerColor) {
        return color == playerColor;
    }
}
