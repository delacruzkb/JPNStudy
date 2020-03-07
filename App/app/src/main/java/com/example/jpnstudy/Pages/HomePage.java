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
        String mode="";
        boolean error=false;
        switch (view.getId()) {
            case R.id.home_learn_button:
                mode = getString(R.string.learn_label);
                break;
            case R.id.home_hone_button:
                mode = getString(R.string.hone_label);
                break;
            case R.id.home_ordeal_button:
                mode = getString(R.string.ordeal_label);
                break;
            default:
                //TODO: error? do something
                error=true;
                break;
        }
        if(!error)
        {
            intent.putExtra("mode",mode);
            startActivity(intent);
        }

    }
    public void records(View view){

    }
    public void settings(View view){
        Intent intent = new Intent(this,SettingsPage.class);
        startActivity(intent);
    }

}
