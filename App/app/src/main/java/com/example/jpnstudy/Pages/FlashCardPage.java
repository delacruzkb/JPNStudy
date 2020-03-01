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
    int currentCard;
    TextView cardCounter;
    EditText card;
    ArrayList<FlashCard> flashCards;
    String sideFrontProperties;
    String sideBackProperties;
    boolean isFront;
    int mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_page);
        Intent intent = getIntent();
        int amount = intent.getIntExtra("amount",1);
        mode = intent.getIntExtra("mode",1);
        String[] properties = intent.getStringExtra("properties").split(",");
        sideFrontProperties = properties[0];
        sideBackProperties = properties[1];
        FlashCardDatabaseReader db = new FlashCardDatabaseReader(getApplicationContext());
        flashCards = db.searchFlashCardKnown(mode,amount);

        currentCard=0;
        TextView modeLabel = findViewById(R.id.flash_card_mode_label);
        modeLabel.setText(sideFrontProperties + " / " + sideBackProperties);

        card = findViewById(R.id.flash_card_text);
        cardCounter = findViewById(R.id.flash_card_counter_label);
        loadCard(currentCard);
    }

    public void nextCard(View view) {
        if(currentCard < flashCards.size()-1)
        {
            loadCard(currentCard+1);
        }
    }

    public void prevCard(View view){
        if(currentCard > 0)
        {
            loadCard(currentCard-1);
        }
    }

    private void loadCard(int cardNumber) {
        isFront=true;
        cardCounter.setText((currentCard +1) + "/" + (flashCards.size()));
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
        if(mode==0 && currCard.isKnown()==0;)
        {
            currCard.setKnown(true);
        }
        if(isFront)
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
    }

    //TODO: on back press, prompt
    //TODO: again, but new
}
