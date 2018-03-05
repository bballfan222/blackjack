package james.aaron.blackjackapp;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     Button testDeal;
     Button testHit;
    Button testStay;
    //create a person to test cards with
    Person aaron = new Person();
    //create a deck of cards
    Deck testDeck = new Deck();

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
        playerHandImage = fillPImage();
        testHit = (Button) findViewById(R.id.hitButton);
        testStay = (Button) findViewById(R.id.stayButton);
        testDeal = (Button) findViewById(R.id.dealButton);
        testDeck.shuffle();

        testDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aaron.addCard(testDeck.getTopCard());
                aaron.addCard(testDeck.getTopCard());
                displayTheCards(cardImages,playerHandImage,aaron);
                testDeal.setVisibility(View.INVISIBLE);
            }
        });

        testHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aaron.addCard(testDeck.getTopCard());
                displayTheCards(cardImages,playerHandImage,aaron);
            }
        });

        testStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aaron.discardHand();
                testDeck.resetDeck();
                testDeck.shuffle();
                playerHandImage= fillPImage();
                testDeal.setVisibility(View.VISIBLE);
            }
        });





    }
    public ImageView[] fillPImage()
    {
        ImageView[] temp= new ImageView[]{
                findViewById(R.id.player1),findViewById(R.id.player2),findViewById(R.id.player3),
                findViewById(R.id.player4),findViewById(R.id.player5),findViewById(R.id.player6),
                findViewById(R.id.player7),findViewById(R.id.player8)
        };

        for(int i=0; i <8; i++)
        {
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

}
