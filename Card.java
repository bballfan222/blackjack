package james.aaron.blackjackapp;

/**
 * Created by bball on 2/7/2018.
 */

public class Card {

    private int suit;
    //this is the assigned value for card creation and is used for array location
    private int value;
    private boolean isAce;
    //this is an assigned value for card value to be used for black jack
    private int bJValue;


    /**
     * Creates a card based off of a suit and value
     *
     * @param suit
     * @param value
     */
    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
        this.isAce= false;
        if(this.value == 1)
        {
            this.value = 14;
            isAce=true;
        }
        switch (this.value) {
            case (CardConstants.ACE):
                this.bJValue = 11;
                break;
            case (CardConstants.JACK):
                this.bJValue = 10;
                break;
            case (CardConstants.QUEEN):
                this.bJValue = 10;
                break;
            case (CardConstants.KING):
                this.bJValue = 10;
                break;
            default:
               this.bJValue= this.value;
        }
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
        if (this.value == 14) {
            this.bJValue=1;
        }
    }





    public int getRowValue() {
        return value;

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
    public int getBlackJackValue()
    {
        return this.bJValue;
    }
    public boolean isAce()
    {
        return this.isAce;
    }

    }




