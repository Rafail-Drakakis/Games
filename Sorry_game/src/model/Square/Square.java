package model.Square;

import model.Color.Color;
import model.Pawn.Pawn;

import java.io.Serializable;

/**
 * Contains the methods signatures needed for creating a Sorry simple or special card
 */

public abstract class Square implements Serializable {
    boolean disabled;
    Color color;
    Pawn hasPawn;

    /**
     * Determines whether a player can move to this square.
     *
     * @return true if the player can move to this square, false otherwise.
     * precondition The square_to_move parameter should be a non-negative integer.
     */
        abstract boolean CanMove(Color playerColor);
    /**
     * Gets the color of the square.
     *
     * @return The color of the square.
     */
    public Color getColor() {
        return color;
    }
    /**
     * Sets the color of the square.
     *
     * @param color The color to set for the square.
     */
    public void setColor(Color color) {
        this.color = color;
    }
    /**
     * Gets the pawn that occupies the square.
     *
     * @return The Pawn object if a pawn is present, or null if the square is empty.
     */
    public Pawn getHasPawn() {
        return hasPawn;
    }
    /**
     * Sets the pawn that occupies the square.
     *
     * @param hasPawn The Pawn object to set on the square, or null to indicate an empty square.
     */
    public void setHasPawn(Pawn hasPawn) {
        this.hasPawn = hasPawn;
    }

}

