package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jpnstudy.R;

public class ChallengePage extends AppCompatActivity {
    //TODO: pull 10 known cards
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_page);
        Intent intent = getIntent();
        int cardAmount= intent.getIntExtra("cardAmount",0);
        String flashCardPair = intent.getStringExtra("flashCardPair");
        String challengeLevel = intent.getStringExtra("challengeLevel");
        TextView test1 = findViewById(R.id.challenge_test1);
        test1.setText(""+ cardAmount);
        TextView test2 = findViewById(R.id.challenge_test2);
        test2.setText(flashCardPair);
        TextView test3 = findViewById(R.id.challenge_test3);
        test3.setText(challengeLevel);
    }
}
