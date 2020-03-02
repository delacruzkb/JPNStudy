package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jpnstudy.Database.FlashCardDatabaseReader;
import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.R;

import java.util.ArrayList;

public class FlashCardPage extends AppCompatActivity {
    ArrayList<FlashCard> flashCards;
    int currentCardCount;
    FlashCard currentCard;
    TextView cardCounterLabel;
    EditText card;

    String sideFrontProperties;
    String sideBackProperties;
    boolean isFront;
    boolean isHone;
    int amount;

    MenuItem starIcon;
    MenuItem masterIcon;
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
        //loadCard(currentCardCount);
    }
    //TODO: menu item implementation

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    public void nextCard(View view) {
        if(currentCardCount < flashCards.size()-1)
        {
            currentCardCount++;
            loadCard(currentCardCount);
        }
    }

    public void prevCard(View view){
        if(currentCardCount > 0)
        {
            currentCardCount += -1;
            loadCard(currentCardCount);

        }
    }

    private void loadCard(int cardNumber) {
        isFront=true;
        cardCounterLabel.setText((currentCardCount +1) + "/" + (flashCards.size()));
        currentCard = flashCards.get(cardNumber);
        if(sideFrontProperties.equalsIgnoreCase("English"))
        {
            card.setText(currentCard.getEnglish());
        }
        else if(sideFrontProperties.equalsIgnoreCase("Hiragana"))
        {
            card.setText(currentCard.getHiragana());
        }
        else if(sideFrontProperties.equalsIgnoreCase("Kanji"))
        {
            card.setText(currentCard.getKanji());
        }

        if( currentCard.isMastered())
        {
            starIcon.setIcon(R.drawable.flash_card_mastered_icon);
        }
        else
        {
            starIcon.setIcon(R.drawable.flash_card_unmastered_icon);
        }

        if( currentCard.isStarred())
        {
            starIcon.setIcon(R.drawable.flash_card_starred_icon);
        }
        else
        {
            starIcon.setIcon(R.drawable.flash_card_unstarred_icon);
        }



    }

    public void flipCard(View view){
        if(!isHone && !currentCard.isKnown());
        {
            currentCard.setKnown(true);
            //TODO: Update DAO known
        }
        if(!isFront)
        {
            if(sideFrontProperties.equalsIgnoreCase("English"))
            {
                card.setText(currentCard.getEnglish());
            }
            else if(sideFrontProperties.equalsIgnoreCase("Hiragana"))
            {
                card.setText(currentCard.getHiragana());
            }
            else if(sideFrontProperties.equalsIgnoreCase("Kanji"))
            {
                card.setText(currentCard.getKanji());
            }
        }
        else
        {
            if(sideBackProperties.equalsIgnoreCase("English"))
            {
                card.setText(currentCard.getEnglish());
            }
            else if(sideBackProperties.equalsIgnoreCase("Hiragana"))
            {
                card.setText(currentCard.getHiragana());
            }
            else if(sideBackProperties.equalsIgnoreCase("Kanji"))
            {
                card.setText(currentCard.getKanji());
            }
        }
        isFront = !isFront;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_star:
                starCard(currentCard, !currentCard.isStarred());
                return true;

            case R.id.action_master:
                masterCard(currentCard, !currentCard.isMastered());
                return true;

            default:
                //don't know what happened
                return super.onOptionsItemSelected(item);
        }
    }

    private void masterCard(FlashCard masterCard, boolean isMaster) {
        if(isMaster) {
            masterIcon.setIcon(R.drawable.flash_card_mastered_icon);
        }
        else {
            masterIcon.setIcon(R.drawable.flash_card_unmastered_icon);
        }
        masterCard.setMastered(isMaster);
        //TODO: Update DAO master
    }

    private void starCard(FlashCard starCard, boolean isStar){
        if(isStar) {
            starIcon.setIcon(R.drawable.flash_card_starred_icon);
        }
        else{
            starIcon.setIcon(R.drawable.flash_card_unstarred_icon);
        }
        starCard.setStarred(isStar);
        //TODO: Update DAO star
    }

    private void initialSetup() {
        currentCardCount=0;

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
        if (isHone)
        {
            setTitle("HONE!");
        }
        else{
            setTitle("LEARN!");
        }

        starIcon = findViewById(R.id.action_star);
        masterIcon = findViewById(R.id.action_master);

    }
    private void loadCardsFromDatabase() {
        FlashCardDatabaseReader db = new FlashCardDatabaseReader(getApplicationContext());
        flashCards = db.searchFlashCardKnown(isHone,amount);
    }

    //TODO: on back press, prompt
    //TODO: again, but new
}
