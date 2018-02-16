package james.aaron.blackjackapp;

/**
 * Created by bball on 2/7/2018.
 */

public interface IDeck {
    /**
     * Resets the deck. If you created the deck to hold 1 or more decks it puts the correct amount of cards back in the deck.
     */
    public void resetDeck();

    /**
     * Shuffles All cards in the deck.
     */
    public void shuffle();

    /**
     * Removes the top card from the deck and returns it
     * @return the top Card from the deck.
     */
    public Card getTopCard();

    /**
     * Prints out to the Systems console the cards in the deck in their order.
     */
    public void printDeck();
}
