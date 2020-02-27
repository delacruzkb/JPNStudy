package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.jpnstudy.R;
//TODO: stylize home page
public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    //TODO: navigation for the page & material design
    public void flashCard(View view){
        Intent intent = new Intent(this,FlashCardMenu.class);
        int mode=0;
        if( view.getId() == R.id.home_hone_button){
            mode =1;
        }
        intent.putExtra("mode",mode);
        startActivity(intent);
    }
    public void hone(View view){
        Intent intent = new Intent(this,FlashCardMenu.class);
        intent.putExtra("mode","hone");
        startActivity(intent);
    }
    public void ordeal(View view){

    }
    public void records(View view){

    }
    public void settings(View view){
        Intent intent = new Intent(this,SettingsPage.class);
        startActivity(intent);
    }

}
