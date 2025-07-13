package model.Card;

import model.Board.Board;
import model.Pawn.Pawn;

import java.io.Serializable;

/**
 * Contains the methods signatures needed for creating a simple or special card
 */
public abstract class Card implements Serializable {
    String image;
    int value;

    /**
     * Accessor: returns the card's value
     * Postcondition: card's value has been returned
     *
     * @return int value
     */
    public int getValue() {
        return value;
    }

    /**
     * Transformer: sets the card's value
     * Postcondition: card's value has been set
     */
    public void setValue(int value) {
        this.value = value;
    }


    /**
     * Moves the pawn accordingly to the card played. If the pawn moved to a square
     * where a pawn of different color is located, it sends the different color pawn
     * to its start square. Also, if the pawn moved to a StartSlideSquare with
     * different color then it slides to the EndSlideSquare of this color and sends
     * pawns which are in this whole slide square to their start squares.
     * <p>
     * Precondition ableToMove function returned true/move is valid.
     * Postcondition Moves the pawn accordingly to the card played.
     *
     * @param pawn  The pawn that will be moved.
     * @param board The table/ squares where the pawn is moving on.
     */

    public abstract boolean movePawn(Pawn pawn, Board board);



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Returns the string representation of a card
     * Postcondition: The string representation of a card is returned
     *
     * @return The string representation of a card
     */
    public String toString() {
        return ("Numbered " + value + " Card");
    }
}