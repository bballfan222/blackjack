package james.aaron.blackjackapp;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView test;
    Button newCardButton;
    //create a person to test cards with
    Person aaron = new Person();
    //create a deck of cards
    Deck testDeck = new Deck();
    ImageView c1;
    ImageView c2;
    Button resetButton;
    int[][] cardImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //fill a 2d array with the int file locations of card pictures
        cardImages =fillCardImage();


        newCardButton = (Button) findViewById(R.id.newCButton);
        c1= (ImageView) findViewById(R.id.c1) ;
        c2 = (ImageView) findViewById(R.id.c2);
        resetButton = (Button) findViewById(R.id.resetButton);

        test =(TextView) findViewById(R.id.test);
        test.setText(aaron.displayHand());
        c1.setImageResource(R.mipmap.blue_back);
        c2.setImageResource(R.mipmap.blue_back);




        newCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testDeck = new Deck();
                testDeck.shuffle();
                //add the top card of a deck to a hand arraylist in the person class
                aaron.addCard(testDeck.getTopCard());
                aaron.addCard(testDeck.getTopCard());
                test.setText(aaron.displayHand());
                //test method to show the text of the cards and find the images of the card in the 2d array
                displayTheCards(cardImages,c1,c2,aaron);
                //delete the persons hand
                aaron.discardHand();




            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setImageResource(R.mipmap.blue_back);
                c2.setImageResource(R.mipmap.blue_back);
                test.setText("Need New Cards");
            }
        });
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
    public void displayTheCards(int[][] a, ImageView c1, ImageView c2, Person aaron)
    {
        int row;
        int col;
        for(int i=0; i<aaron.getHandsize();i++)
        {
            switch(i)
            {
                case(0):
                    row=aaron.getCardNumber(i)-2;
                    col =  aaron.getCardSuitValue(i);
                    c1.setImageResource(a[row][col]);
                    break;
                case(1):
                    row=aaron.getCardNumber(i)-2;
                    col =  aaron.getCardSuitValue(i);
                    c2.setImageResource(a[row][col]);
                    break;


            }
        }
    }
}
