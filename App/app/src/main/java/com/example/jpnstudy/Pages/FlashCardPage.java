package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.R;

import java.util.ArrayList;

public class FlashCardPage extends AppCompatActivity {
    ArrayList<FlashCard> flashCards;
    FlashCard currentCard;
    String cardFront;
    String cardBack;
    String mode;
    int amount;
    int currentCardIndex;
    boolean isFront;

    //Views
    MenuItem starIcon;
    MenuItem masterIcon;
    TextView flashCardText;
    TextView cardCounterLabel;
    Button prevButton;
    Button nextButton;
    Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_page);
        initialSetup();
        loadCard(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu,menu);
        starIcon=menu.getItem(0);
        if(mode.equals(getString(R.string.hone_label)))
        {
            masterIcon=menu.getItem(1);
            masterIcon.setVisible(true);
            if(currentCard.isMastered())
            {
                masterIcon.setIcon(R.drawable.ic_mastered);
            }
        }

        if(currentCard.isStarred())
        {
            starIcon.setIcon(R.drawable.ic_starred);
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

    public void flipCard(View view){
        if(isFront)
        {
            if(cardBack.equals(getString(R.string.english_label)))
            {
                flashCardText.setText(currentCard.getEnglish());
            }
            else if(cardBack.equals(getString(R.string.hiragana_label)))
            {
                flashCardText.setText(currentCard.getHiragana());
            }
            else if(cardBack.equals(getString(R.string.kanji_label)))
            {
                flashCardText.setText(currentCard.getKanji());
            }
        }
        else {
            if(cardFront.equals(getString(R.string.english_label)))
            {
                flashCardText.setText(currentCard.getEnglish());
            }
            else if(cardFront.equals(getString(R.string.hiragana_label)))
            {
                flashCardText.setText(currentCard.getHiragana());
            }
            else if(cardFront.equals(getString(R.string.kanji_label)))
            {
                flashCardText.setText(currentCard.getKanji());
            }
        }
        isFront= !isFront;
    }

    public void nextCard(View view){
        if(currentCardIndex<amount-1)
        {
            loadCard(currentCardIndex+1);
        }


        if(doneButton.getVisibility() == View.INVISIBLE && currentCardIndex == amount-1)
        {
            doneButton.setVisibility(View.VISIBLE);
        }

        if(currentCardIndex > 0)
        {
            prevButton.setVisibility(View.VISIBLE);
        }

        if(currentCardIndex == amount-1)
        {
            nextButton.setVisibility(View.INVISIBLE);
        }
    }

    public void prevCard(View view){
        if(currentCardIndex>0)
        {
            loadCard(currentCardIndex-1);
        }

        if(currentCardIndex < amount-1)
        {
            nextButton.setVisibility(View.VISIBLE);
        }

        if(currentCardIndex==0)
        {
            prevButton.setVisibility(View.INVISIBLE);
        }


    }

    public void done(View view){
        onBackPressed();
    }


    private void loadCard(int index) {
        currentCard = flashCards.get(index);
        currentCardIndex = index;
        isFront=true;
        if(cardFront.equals(getString(R.string.english_label))) {
            flashCardText.setText(currentCard.getEnglish());
        }
        else if(cardFront.equals(getString(R.string.hiragana_label))) {
            flashCardText.setText(currentCard.getHiragana());
        }
        else if(cardFront.equals(getString(R.string.kanji_label))) {
            flashCardText.setText(currentCard.getKanji());
        }

        if(starIcon != null) {
            if(currentCard.isStarred())
            {
                starIcon.setIcon(R.drawable.ic_starred);
            }
            else
            {
                starIcon.setIcon(R.drawable.ic_un_starred);
            }
        }

        if( masterIcon != null) {
            masterIcon.setChecked(currentCard.isMastered());
            if(currentCard.isMastered())
            {
                masterIcon.setIcon(R.drawable.ic_mastered);
            }
            else
            {
                masterIcon.setIcon(R.drawable.ic_un_mastered);
            }
        }


        cardCounterLabel.setText( (index+1) + " / "  + amount );
    }

    private void initialSetup() {
        Intent intent = getIntent();
        cardFront = intent.getStringExtra(getString(R.string.card_front_key));
        cardBack = intent.getStringExtra(getString(R.string.card_back_key));
        mode = intent.getStringExtra(getString(R.string.mode_key));
        amount = intent.getIntExtra(getString(R.string.amount_key),1);
        isFront=true;
        currentCardIndex =0;
        flashCards = (ArrayList<FlashCard>) intent.getSerializableExtra(getString(R.string.card_key));

        //Views
        flashCardText = findViewById(R.id.flash_card_text_view);
        cardCounterLabel = findViewById(R.id.flash_card_counter_label);
        nextButton = findViewById(R.id.flash_card_next_button);
        prevButton = findViewById(R.id.flash_card_previous_button);
        doneButton = findViewById(R.id.flash_card_done_button);
    }

    private void toggleStar(MenuItem item) {
        currentCard.setStarred(!currentCard.isStarred());
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
        if(currentCard.isMastered())
        {
            item.setIcon(R.drawable.ic_mastered);
        }
        else
        {
            item.setIcon(R.drawable.ic_un_mastered);
        }
    }

    private void update()
    {
        //TODO: update at the end, also put it in code
    }

    @Override
    public void onBackPressed() {
        final Context context = this;
        Intent intent = new Intent(context, ModeMenu.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.done_dialog_title)
                .setPositiveButton(R.string.again_dialog_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, ModeMenu.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra(getString(R.string.mode_key),mode);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.return_home_dialog_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                });
        builder.create();
        builder.show();
    }



}
