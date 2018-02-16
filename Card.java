package james.aaron.blackjackapp;

/**
 * Created by bball on 2/7/2018.
 */

public class Card {

    private int suit;
    private int value;


    /**
     * Creates a card based off of a suit and value
     *
     * @param suit
     * @param value
     */
    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }


    /**
     * Returns the integer value of the suit.
     *
     * @return
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns the integer of the value.
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * Changes the value of an ace
     */
    public void changeAce() {
        if (this.value == 11) {

        }
    }

    /**
     * Returns the string value of the card. examples: 2 of Diamonds Ace of
     * Clubs King of Hearts 10 of Spades
     */
    @Override
    public String toString() {
        return getValueString() + " of " + getSuitString();
    }

    /**
     * Card value inside of brackets [Ace of Spades] [10 of Hearts]
     *
     * @return Card within brackets.
     */
    public String getCardText() {
        return "[" + toString() + "]";
    }

    /**
     * Returns short version of the card.
     * i.e.
     * [A of H] [10 of D]
     *
     * @return
     */
    public String getShortVersion() {
        return "[" + getShortValueString() + " of " + getShortSuitString() + "]";
    }

    public String getShortValueString() {
        switch (value) {
            case (CardConstants.ACE):
                return "a";
            case (CardConstants.JACK):
                return "j";
            case (CardConstants.QUEEN):
                return "q";
            case (CardConstants.KING):
                return "k";
            default:
                return value + "";
        }
    }

    public int getRowValue() {
        switch (value) {
            case (CardConstants.ACE):
                return 14;
            case (CardConstants.JACK):
                return 11;
            case (CardConstants.QUEEN):
                return 12;
            case (CardConstants.KING):
                return 13;
            default:
                return value;
        }
    }


    public String getShortSuitString() {
        switch (suit) {
            case (CardConstants.SPADES):
                return "s";
            case (CardConstants.HEARTS):
                return "h";
            case (CardConstants.DIAMONDS):
                return "d";
            case (CardConstants.CLUBS):
                return "c";
            default:
                return null;
        }
    }

    public int colVal() {
        switch (suit) {
            case (CardConstants.SPADES):
                return 3;
            case (CardConstants.HEARTS):
                return 2;
            case (CardConstants.DIAMONDS):
                return 1;
            case (CardConstants.CLUBS):
                return 0;
            default:
                return 0;
        }
    }

    /**
     * Returns the string of the suit
     *
     * @return
     */
    public String getSuitString() {
        switch (suit) {
            case (CardConstants.SPADES):
                return CardConstants.SPADES_STRING;
            case (CardConstants.HEARTS):
                return CardConstants.HEARTS_STRING;
            case (CardConstants.DIAMONDS):
                return CardConstants.DIAMONDS_STRING;
            case (CardConstants.CLUBS):
                return CardConstants.CLUBS_STRING;
            default:
                return null;
        }
    }

    /**
     * returns the string of the value.
     *
     * @return
     */
    public String getValueString() {
        switch (value) {
            case (CardConstants.ACE):
                return CardConstants.ACE_STRING;
            case (CardConstants.JACK):
                return CardConstants.JACK_STRING;
            case (CardConstants.QUEEN):
                return CardConstants.QUEEN_STRING;
            case (CardConstants.KING):
                return CardConstants.KING_STRING;
            default:
                return value + "";
        }
    }

    /**
     * Compares this card to another card. -1 if this value is lower 0 if the
     * values are equal 1 if this value is higher
     *
     * @param card
     * @return
     */
    public int compareTo(Card card) {
        if (card.value > this.value)
            return -1;
        else if (card.value < this.value)
            return 1;
        else
            return 0;
    }

    /**
     * Compares this card to another card. -1 if this value is lower 0 if the
     * values are equal 1 if this value is higher
     *
     * @param card
     * @return
     */
    public int compareTo(Card card, boolean acesHigh) {
        int cardA = card.value;
        int cardB = this.value;
        if (acesHigh) {
            if (cardA == 1)
                cardA = 14;
            if (cardB == 1)
                cardB = 14;
        }

        if (cardA > cardB)
            return -1;
        else if (cardA < cardB)
            return 1;
        else
            return 0;
    }

    /**
     * Determines whether or not the cards are the same.
     *
     * @param card
     * @return
     */
    public boolean equals(Card card) {
        if (this.value == card.value && this.suit == card.suit)
            return true;
        return false;
    }

    }




