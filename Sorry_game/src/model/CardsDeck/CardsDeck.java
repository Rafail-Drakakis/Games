package model.CardsDeck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import model.Card.*;

/**
 * Represents a deck of cards.
 */
public class CardsDeck implements Serializable
{
    private ArrayList<Card> cards;

    /**
     * Constructs a new CardsDeck with an empty card ArrayList.
     * Postcondition: Creates a new CardsDeck with an empty card ArrayList.
     */
    public CardsDeck()
    {
        cards = new ArrayList<Card>();
        init_cards();
    }

    /**
     * Initializes and shuffles the deck with 44 cards.
     * Postcondition: The cards have been initialized and shuffled.
     */
    public void init_cards()
    {
        for (int i = 0; i < 4; i++) {
            cards.add(new NumberOneCard());
            cards.add(new NumberTwoCard());
            cards.add(new NumberThreeCard());
            cards.add(new NumberFourCard());
            cards.add(new NumberFiveCard());
            cards.add(new NumberSevenCard());
            cards.add(new NumberEightCard());
            cards.add(new NumberTenCard());
            cards.add(new NumberElevenCard());
            cards.add(new NumberTwelveCard());
            cards.add(new SorryCard());
        }

        // Shuffle the deck
        Collections.shuffle(cards);
    }

    /**
     * Checks if the deck contains no cards.
     * Postcondition: Returns true if the deck contains no cards.
     * @return true if the deck contains no cards.
     */
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }

    /**
     * Adds a card to the deck.
     * Postcondition: A card has been added to the deck.
     * @param i The card to add.
     */
    public void addCard(Card i)
    {
        cards.add(i);
    }

    /**
     * Returns the value of the card at position i.
     * Postcondition: The value of the card at position i has been returned.
     * @param i The index of the card.
     * @return The value of the card in position i.
     */
    public int getValue(int i)
    {
        return cards.get(i).getValue();
    }

    /**
     * Removes a card from the deck.
     * Postcondition: A card has been removed from the deck.
     * @param i The card to remove.
     */
    public void removeCardIndex(int i)
    {
        cards.remove(i);
    }

    /**
     * Returns the size of the deck.
     * Postcondition: The size of the deck has been returned.
     * @return The size of the deck.
     */
    public int getSize()
    {
        return cards.size();
    }

    /**
     * Returns the card at position 'index'.
     * Postcondition: The card at position 'index' has been returned.
     * @param index The index of the card.
     * @return The card at position 'index'.
     */
    public Card getCard(int index)
    {
        return cards.get(index);
    }

    /**
     * Clears the deck.
     * Postcondition: The deck is cleared.
     */
    public void clearAll()
    {
        cards.clear();
    }

    /**
     * Returns all the cards in the deck.
     * Postcondition: All the cards have been returned.
     * @return All the cards in the deck.
     */
    public ArrayList<Card> getCards()
    {
        return this.cards;
    }
}
