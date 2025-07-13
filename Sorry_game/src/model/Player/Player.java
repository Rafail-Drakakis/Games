package model.Player;

import model.Card.Card;
import model.Pawn.Pawn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static GameDimensions.GameDim.COLORS;
import static GameDimensions.GameDim.pawnsStartDim;
import static model.Color.Color.*;
import static model.Color.Color.BLUE;

/**
 * Represents a player in the game.
 */
public class Player implements Serializable {
    private String name;
    private List<Card> cardsPlayed;
    private int ID;
    public Pawn pawn1, pawn2;

    /**
     * Constructs a new Player with the given name and ID.
     *
     * @param name The name of the player.
     * @param ID   The ID of the player.
     * Postcondition: Creates and initializes a player with the given name, team, and ID.
     */
    public Player(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.cardsPlayed = new ArrayList<>();
    }

    /**
     * Constructs a new Player with the given name, team, ID, and pawns.
     *
     * @param name The name of the player.
     * @param ID   The ID of the player.
     * Postcondition: Creates and initializes a player with the given name, team, and ID.
     */
    public Player(String name, int ID, Pawn p1, Pawn p2) {
        this.name = name;
        this.pawn1 = p1;
        this.pawn2 = p2;
        this.ID = ID;
        this.cardsPlayed = new ArrayList<>();
    }

    /**
     * Initializes a player for a new round
     * Postcondition: Clears the contents of the player's collection
     */
    public void init_player() {
        this.cardsPlayed.clear();

        if (COLORS[ID].equals("red")) {
            pawn1 = new Pawn(RED, 0, pawnsStartDim[ID][0].x / 50, pawnsStartDim[ID][0].y / 50);
            pawn2 = new Pawn(RED, 1, pawnsStartDim[ID][1].x / 50, pawnsStartDim[ID][1].y / 50);
        } else if (COLORS[ID].equals("yellow")) {
            pawn1 = new Pawn(YELLOW, 0, pawnsStartDim[ID][0].x / 50, pawnsStartDim[ID][0].y / 50);
            pawn2 = new Pawn(YELLOW, 1, pawnsStartDim[ID][1].x / 50, pawnsStartDim[ID][1].y / 50);
        } else if (COLORS[ID].equals("green")) {
            pawn1 = new Pawn(GREEN, 0, pawnsStartDim[ID][0].x / 50, pawnsStartDim[ID][0].y / 50);
            pawn2 = new Pawn(GREEN, 1, pawnsStartDim[ID][1].x / 50, pawnsStartDim[ID][1].y / 50);
        } else if (COLORS[ID].equals("blue")) {
            pawn1 = new Pawn(BLUE, 0, pawnsStartDim[ID][0].x / 50, pawnsStartDim[ID][0].y / 50);
            pawn2 = new Pawn(BLUE, 1, pawnsStartDim[ID][1].x / 50, pawnsStartDim[ID][1].y / 50);
        }
    }

    /**
     * Postcondition: Returns the ID of the player.
     *
     * @return The ID of the player (int).
     */
    public int getID() {
        return ID;
    }

    /**
     * Postcondition: The ID of the player is changed to `id`.
     *
     * @param id The new ID of the player.
     */
    public void setID(int id) {
        this.ID = id;
    }

    /**
     * Postcondition: Returns the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Postcondition: The name of this player is changed to `newName`.
     *
     * @param newName The new name of the player.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Postcondition: The Cards (collection) of this player is changed to `cardsPlayed`.
     *
     * @param cardsPlayed The new CardsDeck of the cards that the player has played.
     */
    public void setCardsToPlay(List<Card> cardsPlayed) {
        this.cardsPlayed = cardsPlayed;
    }

    /**
     * Postcondition: Returns the cards that the player has played.
     *
     * @return The cards that the player has played.
     */
    public List<Card> getCardsToPlay() {
        return this.cardsPlayed;
    }

    /**
     * Postcondition: A card is added to the player's cards.
     *
     * @param c The card to add.
     */
    public void setCards(Card c) {
        this.cardsPlayed.add(c);
    }

    /**
     * Postcondition: Returns the Cards collection of a player.
     *
     * @return The Cards collection of a player.
     */
    public List<Card> getCards() {
        return this.cardsPlayed;
    }


    /**
     * Gets the list of cards played during the game.
     *
     * @return The list of cards played.
     */
    public List<Card> getCardsPlayed() {
        return cardsPlayed;
    }

    /**
     * Sets the list of cards played during the game.
     *
     * @param cardsPlayed The list of cards played to be set.
     */
    public void setCardsPlayed(List<Card> cardsPlayed) {
        this.cardsPlayed = cardsPlayed;
    }

    /**
     * Gets the first pawn in the game.
     *
     * @return The first pawn.
     */
    public Pawn getPawn1() {
        return pawn1;
    }

    /**
     * Sets the first pawn in the game.
     *
     * @param pawn1 The first pawn to be set.
     */
    public void setPawn1(Pawn pawn1) {
        this.pawn1 = pawn1;
    }

    /**
     * Gets the second pawn in the game.
     *
     * @return The second pawn.
     */
    public Pawn getPawn2() {
        return pawn2;
    }

    /**
     * Sets the second pawn in the game.
     *
     * @param pawn2 The second pawn to be set.
     */
    public void setPawn2(Pawn pawn2) {
        this.pawn2 = pawn2;
    }

    /**
     * Checks if both pawns have reached the home position, indicating that the game is finished.
     *
     * @return true if both pawns are in the home position, false otherwise.
     */
    public boolean isFinished() {
        return pawn1.isHome() && pawn2.isHome();
    }

    /**
     * Returns a string representation of the game.
     *
     * @return A string containing the name of the game and the color of the first pawn.
     */
    public String toString() {
        return getName() + "(" + pawn1.getColor().getValue().toUpperCase() + ")\n";
    }


}
