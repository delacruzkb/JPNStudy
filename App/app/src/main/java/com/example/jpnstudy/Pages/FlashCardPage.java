package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
    TextView card;

    String cardFront;
    String cardBack;
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
        for( int i = 0; i<amount;i++) {
            FlashCard temp = new FlashCard();
            temp.setEnglish("English " + (i + 1));
            temp.setKanji("Kanji " + (i + 1));
            temp.setHiragana("Hiragana " + (i + 1));
            temp.setStarred(true);
            temp.setMastered(true);
            flashCards.add(temp);
        }
        //loadCardsFromDatabase();

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadCard(currentCardCount);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu,menu);
        starIcon=menu.getItem(0);
        masterIcon=menu.getItem(1);
        if(currentCard.isStarred())
        {
            starIcon.setIcon(R.drawable.ic_starred);
        }
        if(currentCard.isMastered())
        {
            masterIcon.setIcon(R.drawable.ic_mastered);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_master:
                toggleMaster(item);
                return true;
            case R.id.action_star:
                toggleStar(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void nextCard(View view) {
        if(currentCardCount < flashCards.size()-1)
        {
            currentCardCount = currentCardCount +1;
            loadCard(currentCardCount);
        }
    }

    public void prevCard(View view){
        if(currentCardCount > 0)
        {
            currentCardCount = currentCardCount -1;
            loadCard(currentCardCount);

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
            if(cardFront.equalsIgnoreCase("English"))
            {
                card.setText(currentCard.getEnglish());
            }
            else if(cardFront.equalsIgnoreCase("Hiragana"))
            {
                card.setText(currentCard.getHiragana());
            }
            else if(cardFront.equalsIgnoreCase("Kanji"))
            {
                card.setText(currentCard.getKanji());
            }
        }
        else
        {
            if(cardBack.equalsIgnoreCase("English"))
            {
                card.setText(currentCard.getEnglish());
            }
            else if(cardBack.equalsIgnoreCase("Hiragana"))
            {
                card.setText(currentCard.getHiragana());
            }
            else if(cardBack.equalsIgnoreCase("Kanji"))
            {
                card.setText(currentCard.getKanji());
            }
        }
        isFront = !isFront;
    }


    private void loadCard(int cardNumber) {
        isFront=true;
        cardCounterLabel.setText((currentCardCount +1) + "/" + (flashCards.size()));
        currentCard = flashCards.get(cardNumber);
        if(cardFront.equalsIgnoreCase("English"))
        {
            card.setText(currentCard.getEnglish());
        }
        else if(cardFront.equalsIgnoreCase("Hiragana"))
        {
            card.setText(currentCard.getHiragana());
        }
        else if(cardFront.equalsIgnoreCase("Kanji"))
        {
            card.setText(currentCard.getKanji());
        }

        if (masterIcon != null || starIcon != null)
        {
            if( currentCard.isMastered()) {
                masterIcon.setIcon(R.drawable.ic_mastered);
            }
            else{
                masterIcon.setIcon(R.drawable.ic_un_mastered);
            }
            if( currentCard.isStarred()) {
                starIcon.setIcon(R.drawable.ic_starred);
            }
            else{
                starIcon.setIcon(R.drawable.ic_un_starred);
            }
        }
    }

    private void toggleStar(MenuItem item) {
        currentCard.setStarred(!currentCard.isStarred());
        //TODO: UPDATE DAO star
        if(currentCard.isStarred())
        {
            item.setIcon(R.drawable.ic_starred);
        }
        else
        {
            item.setIcon(R.drawable.ic_un_starred);
        }
    }

    private void toggleMaster(MenuItem item) {
        currentCard.setMastered(!currentCard.isMastered());
        //TODO: UPDATE DAO star
        if(currentCard.isMastered())
        {
            item.setIcon(R.drawable.ic_mastered);
        }
        else
        {
            item.setIcon(R.drawable.ic_un_mastered);
        }
    }

    private void initialSetup() {
        currentCardCount=0;

        //Get data from Menu
        Intent intent = getIntent();
        amount = intent.getIntExtra("amount",1);
        isHone = intent.getBooleanExtra("isHone",false);
        cardFront = intent.getStringExtra("cardFront");
        cardBack = intent.getStringExtra("cardBack");

        //View Setup
        TextView modeLabel = findViewById(R.id.flash_card_menu_mode_label);
        modeLabel.setText("Front : " + cardFront + " / Back : " + cardBack);
        card = findViewById(R.id.flash_card_text);
        cardCounterLabel = findViewById(R.id.flash_card_counter_label);
        if (isHone)
        {
            setTitle("HONE!");
        }
        else{
            setTitle("LEARN!");
        }
    }

    private void loadCardsFromDatabase() {
        FlashCardDatabaseReader db = new FlashCardDatabaseReader(getApplicationContext());
        flashCards = db.searchFlashCardKnown(isHone,amount);
    }

    //TODO: on back press, prompt
    //TODO: again, but new
}
