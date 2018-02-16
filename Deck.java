package james.aaron.blackjackapp;

/**
 * Created by bball on 2/7/2018.
 */
import java.util.ArrayList;
public class Deck  implements IDeck
{
    public final int        NUMBER_OF_CARDS_IN_DECK  = 52;
    private final int       NUMBER_OF_SUITS_IN_DECK  = 4;
    private final int       NUMBER_OF_VALUES_IN_DECK = 13;

    private ArrayList<Card> cardDeck;
    private int             numberOfDecks            = 1;

    /**
     * Instantiates the Deck using a standard poker deck of 52 cards
     *
     * @param //numberOfDecks
     */
    public Deck()
    {
        super();
        instantiate();
    }

    /**
     * Instantiates the Deck with a number of decks it will hold, if the number is less than 1 it will hold 1 deck.
     *
     * @param numberOfDecks
     */
    public Deck( int numberOfDecks )
    {
        this.numberOfDecks = numberOfDecks;
        instantiate();
    }

    private void instantiate()
    {
        cardDeck = new ArrayList<>();
        if ( numberOfDecks < 1 )
            numberOfDecks = 1;
        resetDeck();
    }

    @Override
    public void resetDeck()
    {
        cardDeck.clear();
        for ( int count = 0; count < numberOfDecks; count++ )
            cardDeck.addAll( createDeck() );
    }

    @Override
    public void shuffle()
    {
        Card tempCard;
        int randomPosition;
        for ( int currentPosition = 0; currentPosition < NUMBER_OF_CARDS_IN_DECK; currentPosition++ )
        {
            randomPosition = (int) ( Math.random() * NUMBER_OF_CARDS_IN_DECK );
            tempCard = cardDeck.get( randomPosition );
            cardDeck.set( randomPosition, cardDeck.get( currentPosition ) );
            cardDeck.set( currentPosition, tempCard );
        }
    }

    @Override
    public Card getTopCard()
    {
        if ( cardDeck.size() == 0 )
            return null;
        return cardDeck.remove( 0 );
    }

    @Override
    public void printDeck()
    {
        for ( Card card : cardDeck )
            System.out.println( card.toString() );
    }

    private ArrayList<Card> createDeck()
    {
        ArrayList<Card> cards = new ArrayList<>();
        for ( int suit = 1; suit <= NUMBER_OF_SUITS_IN_DECK; suit++ )
            for ( int value = 1; value <= NUMBER_OF_VALUES_IN_DECK; value++ )
                cards.add( new Card( suit, value ) );
        return cards;
    }

    /**
     * Returns current number of cards in deck
     *
     * @return
     */
    public int sizeOfDeck()
    {
        return cardDeck.size();
    }

}
