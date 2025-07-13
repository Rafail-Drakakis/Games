package model.Card;

/**
 * This class represents a Number Card
 */
public abstract class NumberCard extends Card
{

    /**
     * Constructor.
     * Postcondition Creates a new Simple Card with 'col' col and 'value' value.
     * @param value, the value of the card according to which the ability will be given to it
     */
    public NumberCard(int value, String imgPath)
    {
        this.value = value;
        this.image = imgPath;
    }
}
