package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.R;

import java.util.ArrayList;

public class FlashCardPage extends AppCompatActivity {

    ArrayList<FlashCard> flashCards;

    FlashCard currentCard;

    MenuItem starIcon;
    MenuItem masterIcon;

    String cardFront;
    String cardBack;
    String mode;
    int amount;
    int cardCount;
    int currentCardIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_page);
        initialSetup();
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


    private void initialSetup() {
        Intent intent = getIntent();
        cardFront = intent.getStringExtra(getString(R.string.card_front_key));
        cardBack = intent.getStringExtra(getString(R.string.card_back_key));
        mode = intent.getStringExtra(getString(R.string.mode_key));
        amount = intent.getIntExtra(getString(R.string.amount_key),1);
        flashCards = (ArrayList<FlashCard>) intent.getSerializableExtra(getString(R.string.card_key));
    }

    //

    private void loadModeFrame(){
        //TODO:frames based on mode
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

    //TODO: on back press, prompt
    //TODO: again, but new

}
