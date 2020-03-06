package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.jpnstudy.R;
public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    //TODO: navigation for the page & material design
    public void flashCard(View view){
        Intent intent = new Intent(this,FlashCardMenu.class);
        String mode;
        switch (view.getId()) {
            case R.id.home_learn_button:
                mode = getString(R.string.flash_card_learn_title)
                break;
            case R.id.home_hone_button:
                mode = getString(R.string.flash_card_hone_title)
                break;
            case R.id.home_ordeal_button:
                mode = getString(R.string.flash_card_ordeal_title)
                break;
        }
        intent.putExtra("mode",mode);
        startActivity(intent);
    }
    public void records(View view){

    }
    public void settings(View view){
        Intent intent = new Intent(this,SettingsPage.class);
        startActivity(intent);
    }

}
