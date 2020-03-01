package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jpnstudy.Database.FlashCardDatabaseReader;
import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.R;

import java.util.ArrayList;

public class FlashCardPage extends AppCompatActivity {
    ArrayList<FlashCard> flashCards;
    int currentCard;
    TextView cardCounterLabel;
    EditText card;

    String sideFrontProperties;
    String sideBackProperties;
    boolean isFront;
    boolean isHone;
    int amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_page);

        initialSetup();
        flashCards = new ArrayList<>();
        for( int i = 0; i<amount;i++)
        {
            FlashCard temp = new FlashCard();
            temp.setEnglish("English " + (i+1));
            temp.setKanji("Kanji " + (i+1));
            temp.setHiragana("Hiragana " + (i+1));
            flashCards.add(temp);
        }
        //loadCardsFromDatabase();
        loadCard(currentCard);
    }



    public void nextCard(View view) {
        if(currentCard < flashCards.size()-1)
        {
            currentCard++;
            loadCard(currentCard);
        }
    }

    public void prevCard(View view){
        if(currentCard > 0)
        {
            currentCard += -1;
            loadCard(currentCard);

        }
    }

    private void loadCard(int cardNumber) {
        isFront=true;
        cardCounterLabel.setText((currentCard +1) + "/" + (flashCards.size()));
        FlashCard currCard = flashCards.get(cardNumber);
        if(sideFrontProperties.equalsIgnoreCase("English"))
        {
            card.setText(currCard.getEnglish());
        }
        else if(sideFrontProperties.equalsIgnoreCase("Hiragana"))
        {
            card.setText(currCard.getHiragana());
        }
        else if(sideFrontProperties.equalsIgnoreCase("Kanji"))
        {
            card.setText(currCard.getKanji());
        }
    }

    public void flipCard(View view){
        FlashCard currCard = flashCards.get(currentCard);
        if(!isHone && !currCard.isKnown());
        {
            currCard.setKnown(true);
        }
        if(!isFront)
        {
            if(sideFrontProperties.equalsIgnoreCase("English"))
            {
                card.setText(currCard.getEnglish());
            }
            else if(sideFrontProperties.equalsIgnoreCase("Hiragana"))
            {
                card.setText(currCard.getHiragana());
            }
            else if(sideFrontProperties.equalsIgnoreCase("Kanji"))
            {
                card.setText(currCard.getKanji());
            }
        }
        else
        {
            if(sideBackProperties.equalsIgnoreCase("English"))
            {
                card.setText(currCard.getEnglish());
            }
            else if(sideBackProperties.equalsIgnoreCase("Hiragana"))
            {
                card.setText(currCard.getHiragana());
            }
            else if(sideBackProperties.equalsIgnoreCase("Kanji"))
            {
                card.setText(currCard.getKanji());
            }
        }
        isFront = !isFront;
    }

    private void initialSetup() {
        currentCard=0;

        //Get data from Menu
        Intent intent = getIntent();
        amount = intent.getIntExtra("amount",1);
        isHone = intent.getBooleanExtra("isHone",false);
        String[] properties = intent.getStringExtra("properties").split(",");
        sideFrontProperties = properties[0];
        sideBackProperties = properties[1];

        //View Setup
        TextView modeLabel = findViewById(R.id.flash_card_menu_mode_label);
        modeLabel.setText("Front : " + sideFrontProperties + " / Back : " + sideBackProperties);
        card = findViewById(R.id.flash_card_text);
        cardCounterLabel = findViewById(R.id.flash_card_counter_label);
    }
    private void loadCardsFromDatabase() {
        FlashCardDatabaseReader db = new FlashCardDatabaseReader(getApplicationContext());
        flashCards = db.searchFlashCardKnown(isHone,amount);
    }
    //TODO: on back press, prompt
    //TODO: again, but new
}
