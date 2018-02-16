package james.aaron.blackjackapp;

/**
 * Created by bball on 2/7/2018.
 */
import java.util.ArrayList;

public class Person {
    private String name="";
    private int chips=0;
    private boolean playing=false;
    private boolean computerPlayer = false;
    private ArrayList<Card> hand = new ArrayList<>();
    private int handSize=0;
    /**
     * set Person's name
     */
    public void setName(String n)
    {
        this.name = n;
    }
    /**
     * Return the persons name
     */
    public String getName()
    {
        return name;
    }

    /**
     * increase the number of chips based on bet
     */
    public void increaseChips(int bet)
    {
        this.chips += bet;
    }

    /**
     * Decrease the number of chips by the bet
     */
    public void decreaseBet(int bet)
    {
        this.chips-= bet;
    }

    /**
     * Return the number of chips
     */
    public int getChips()
    {
        return chips;
    }
    /**
     * Person is playing or not playing
     */
    public void isPlaying(boolean choice)
    {
        this.playing= choice;
    }


    /**
     * return if person is playing or not
     */
    public boolean playingTF()
    {
        return this.playing;
    }

    /**
     * add a card to the arraylist
     */
    public void addCard(Card card)
    {
        this.hand.add(card);
        handSize++;
    }


    /**
     * Discard hand
     */
    public void discardHand()
    {
        for(int i=0;i<hand.size()+1;i++)
        {
            hand.remove(0);
        }
        handSize=0;
    }

    /**
     * Display the hand
     */
    public String displayHand()
    {
        String handString="";
        for(int i=0; i < this.hand.size();i++)
        {

            if(i!=0)
            {
                handString+=", ";
            }
            handString+=hand.get(i).toString();
        }

        return handString;
    }
    /**
     * set the amount of chips
     */
    public void setChips(int chips)
    {
        this.chips = chips;
    }

    /**
     * set if the player will be a computer or user
     */
    public void setPlayer(boolean tf)
    {
        this.computerPlayer= tf;
    }

    /**
     * return a boolean if a player is, or is not a computer player
     */
    public boolean getPlayer()
    {
        return this.computerPlayer;
    }


    public int getHandsize()
    {
        return handSize;
    }
    public int getCardNumber(int a)
    {
       return hand.get(a).getRowValue();
    }

    public int getCardSuitValue(int a)
    {
        return hand.get(a).colVal();
    }

}

