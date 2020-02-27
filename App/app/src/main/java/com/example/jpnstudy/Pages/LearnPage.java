package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jpnstudy.R;

public class LearnPage extends AppCompatActivity {
    //TODO: make lesson page, pull X unknown cards from the database
    //TODO: App Bar, hide settings there, also have options for star and mastered
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_page);
        Intent intent = getIntent();
        int cardAmount= intent.getIntExtra("cardAmount",0);
        String flashCardPair = intent.getStringExtra("flashCardPair");
        TextView test1 = findViewById(R.id.lesson_test1);
        test1.setText(""+ cardAmount);
        TextView test2 = findViewById(R.id.lesson_test2);
        test2.setText(flashCardPair);
    }
}
