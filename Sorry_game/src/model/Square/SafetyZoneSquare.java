package model.Square;

import model.Color.Color;

/**
 * Represents a safety zone square.
 */
public class SafetyZoneSquare extends Square {
    /**
     * Constructs a SafetyZoneSquare object with the specified color.
     *
     * @param color The color of the SafetyZoneSquare.
     */
    public SafetyZoneSquare(Color color) {
        this.color = color;
    }
    /**
     * Determines if a player can move their game piece to this square.
     *
     * @param playerColor The color of the player's game piece.
     * @return true if the player's game piece can move to this square (color matches), false otherwise.
     */
    @Override
    public boolean CanMove(Color playerColor) {
        return color == playerColor;
    }
}
