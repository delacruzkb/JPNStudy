package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.R;

import java.util.ArrayList;

public class FlashCardPage extends AppCompatActivity {
    //TODO: finish population
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_page);
        Intent intent = getIntent();
        String properties = intent.getStringExtra("properties");
        //ArrayList<FlashCard> cards = ;
    }
}
