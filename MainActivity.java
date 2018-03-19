package james.aaron.blackjackapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button deal;
    Button hit;
    Button stay;
    Button increaseBet;
    Button decreaseBet;
    int bet;
    int betTotal;
    int chips;
    TextView betText;
    TextView chipText;
    TextView playerTotal;
    TextView dealerTotal;

    //create a person and dealer to play cards with
    Person aaron = new Person();
    Person dealer = new Person();
    //create a deck of cards
    Deck gameDeck = new Deck();


    //create array to hold the card images
    int[][] cardImages;
    //create arrays to hold the card place holders on main activity
    ImageView[] playerHandImage= new ImageView[8];
    ImageView[] dealerHandImage= new ImageView[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fill a 2d array with the int file locations of card pictures
        cardImages =fillCardImage();

        //create buttons and set Visibility
        dealerHandImage = fillDImage();
        playerHandImage = fillPImage();
        hit = (Button) findViewById(R.id.hitButton);
        hit.setVisibility(View.INVISIBLE);
        stay = (Button) findViewById(R.id.stayButton);
        stay.setVisibility(View.INVISIBLE);
        deal = (Button) findViewById(R.id.dealButton);
        increaseBet = (Button) findViewById(R.id.incBet);
        decreaseBet = (Button) findViewById(R.id.decButton);
        betText = (TextView) findViewById(R.id.betText);
        chipText = (TextView) findViewById(R.id.chipTotal);
        playerTotal = (TextView) findViewById(R.id.playerTotal);
        dealerTotal = (TextView) findViewById(R.id.dealerTotal);
        bet=5;
        betTotal=0;
        //starting chips will be 100
        chips =100;
        //set the button texts
        betText.setText("Bet: 0");
        increaseBet.setText("+"+String.valueOf(bet));
        decreaseBet.setText("-"+String.valueOf(bet));
        chipText.setText("Total chips: "+String.valueOf(chips));



        increaseBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bet+betTotal <= chips) {
                    betTotal += bet;
                    setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                }else
                {
                    Toast.makeText(getApplicationContext(),"Insufficient amount of chips to increase bet!",Toast.LENGTH_LONG).show();
                }
            }
        });

        increaseBet.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                if(bet<=9)
                {
                    if(chips<10)
                        Toast.makeText(getApplicationContext(),"Insufficient amount of chips to increase bet by that much!",Toast.LENGTH_LONG).show();
                    else
                    {
                        bet =10;
                        setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                    }
                }else if(bet<=24)
                {
                    if(chips<25)
                        Toast.makeText(getApplicationContext(),"Insufficient amount of chips to increase bet by that much!",Toast.LENGTH_LONG).show();
                    else
                    {
                        bet =25;
                        setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                    }
                }else if(bet<=49)
                {
                    if(chips<50)
                        Toast.makeText(getApplicationContext(),"Insufficient amount of chips to increase bet by that much!",Toast.LENGTH_LONG).show();
                    else
                    {
                        bet =50;
                        setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                    }

                }else if(bet<=99)
                {
                    if(chips<100) {
                        Toast.makeText(getApplicationContext(), "Insufficient amount of chips to increase bet by that much!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        bet =100;
                        setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Cannot increment more than 100", Toast.LENGTH_LONG).show();
                }
                return true;
            }

        });

        decreaseBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chips > 5) {
                    if ((betTotal - bet) >= 5) {
                        betTotal -= bet;
                        setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                    } else {
                        Toast.makeText(getApplicationContext(), "Minimum bet is 5, cannot bet less!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        decreaseBet.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(bet==5)
                {
                        Toast.makeText(getApplicationContext(),"Cannot decrease bet lower than 5!",Toast.LENGTH_LONG).show();

                }else if(bet<=10)
                {
                    bet =5;
                    setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                }else if(bet<=25)
                {
                        bet =10;
                    setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                }else if(bet<=50)
                {
                        bet =25;
                    setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                }else if(bet<=100)
                {
                        bet =50;
                    setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                }
                else
                {
                    bet =100;
                    setBettingButtons(betText,increaseBet,decreaseBet,bet,betTotal);
                }
                return true;
            }

        });

        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chips-betTotal>=0) {
                    //call this to make sure the previous hand is discarded
                    aaron.discardHand();
                    dealer.discardHand();
                    //set the person and dealer card hand array with memory locations for the xml
                    playerHandImage = fillPImage();
                    dealerHandImage = fillDImage();
                    //reset the deck and shuffle every time
                    gameDeck.resetDeck();
                    gameDeck.shuffle();
                    aaron.addCard(gameDeck.getTopCard());
                    dealer.addCard(gameDeck.getTopCard());
                    aaron.addCard(gameDeck.getTopCard());
                    dealer.addCard(gameDeck.getTopCard());
                    displayTheCards(cardImages, playerHandImage, aaron);
                    displayTheCards(cardImages, dealerHandImage, dealer);
                    dealerHandImage[0].setImageResource(R.mipmap.blue_back);
                    //get the hand total
                    playerTotal.setText(String.valueOf(aaron.getBlackJackHandTotal()));
                    deal.setVisibility(View.INVISIBLE);
                    stay.setVisibility(View.VISIBLE);
                    hit.setVisibility(View.VISIBLE);
                    increaseBet.setVisibility(View.INVISIBLE);
                    decreaseBet.setVisibility(View.INVISIBLE);
                }else
                {
                    Toast.makeText(getApplicationContext(),"Not enough chips to place that bet!",Toast.LENGTH_LONG).show();
                }





            }
        });

        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aaron.addCard(gameDeck.getTopCard());
                displayTheCards(cardImages,playerHandImage,aaron);
                playerTotal.setText(String.valueOf(aaron.getBlackJackHandTotal()));
            }
        });

        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayTheCards(cardImages,dealerHandImage,dealer);
                deal.setVisibility(View.VISIBLE);
                stay.setVisibility(View.INVISIBLE);
                hit.setVisibility(View.INVISIBLE);
                increaseBet.setVisibility(View.VISIBLE);
                decreaseBet.setVisibility(View.VISIBLE);

            }
        });

    }
    public ImageView[] fillPImage()
    {
        //create an array of imageView which are the players hand
        ImageView[] temp= new ImageView[]{
                findViewById(R.id.player1),findViewById(R.id.player2),findViewById(R.id.player3),
                findViewById(R.id.player4),findViewById(R.id.player5),findViewById(R.id.player6),
                findViewById(R.id.player7),findViewById(R.id.player8)
        };

        for(int i=0; i <8; i++)
        {
            //set the players hand to blank cards incase it was shown and make them invisible.
            temp[i].setImageResource(R.mipmap.blue_back);
            temp[i].setVisibility(View.INVISIBLE);

        }
        return temp;
    }
    public ImageView[] fillDImage()
    {
        //create an array of imageView which are the players hand
        ImageView[] temp= new ImageView[]{
                findViewById(R.id.dealer1),findViewById(R.id.dealer2),findViewById(R.id.dealer3),
                findViewById(R.id.dealer4),findViewById(R.id.dealer5),findViewById(R.id.dealer6),
                findViewById(R.id.dealer7),findViewById(R.id.dealer8)
        };

        for(int i=0; i <8; i++)
        {
            //set the players hand to blank cards incase it was shown and make them invisible.
            temp[i].setImageResource(R.mipmap.blue_back);
            temp[i].setVisibility(View.INVISIBLE);

        }
        return temp;
    }

    public int[][] fillCardImage()
    {
        // To organize that location of each picture in the array the row a card is in will be the
        // card value -2 and the coll is in the order club, diamond, heart, spade
        int[][] a = new int[][]{
                {R.mipmap.c2, R.mipmap.d2, R.mipmap.h2, R.mipmap.s2},
                {R.mipmap.c3, R.mipmap.d3, R.mipmap.h3, R.mipmap.s3},
                {R.mipmap.c4, R.mipmap.d4, R.mipmap.h4, R.mipmap.s4},
                {R.mipmap.c5, R.mipmap.d5, R.mipmap.h5, R.mipmap.s5},
                {R.mipmap.c6, R.mipmap.d6, R.mipmap.h6, R.mipmap.s6},
                {R.mipmap.c7, R.mipmap.d7, R.mipmap.h7, R.mipmap.s7},
                {R.mipmap.c8, R.mipmap.d8, R.mipmap.h8, R.mipmap.s8},
                {R.mipmap.c9, R.mipmap.d9, R.mipmap.h9, R.mipmap.s9},
                {R.mipmap.c10, R.mipmap.d10, R.mipmap.h10, R.mipmap.s10},
                {R.mipmap.cj, R.mipmap.dj, R.mipmap.hj, R.mipmap.sj},
                {R.mipmap.cq, R.mipmap.dq, R.mipmap.hq, R.mipmap.sq},
                {R.mipmap.ck, R.mipmap.dk, R.mipmap.hk, R.mipmap.sk},
                {R.mipmap.ca, R.mipmap.da, R.mipmap.ha, R.mipmap.sa}



        };
        return a;
    }

    //this is a test method that will be changed for the program
    public void displayTheCards(int[][] a, ImageView[] playerHandDisplay, Person aaron)
    {
        int row;
        int col;
        for(int i=0; i<aaron.getHandsize();i++)
        {

                    row=aaron.getCardNumber(i)-2;
                    col =  aaron.getCardSuitValue(i);
                    playerHandDisplay[i].setVisibility(View.VISIBLE);
                    playerHandDisplay[i].setImageResource(a[row][col]);

        }
    }

    //this method will set the betting button values and text
    public void setBettingButtons(TextView betText, Button inc, Button dec, int bet, int betTotal)
    {
        betText.setText("Bet: "+String.valueOf(betTotal));
        inc.setText("+"+String.valueOf(bet));
        dec.setText("-"+String.valueOf(bet));
    }





}
