package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.jpnstudy.R;
//TODO: stylize home page
public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    //TODO: navigation for the page & material design
    //TODO: App Bar, hide settings there
    public void lesson(View view){
        Intent intent = new Intent(this,LessonMenu.class);
        startActivity(intent);
    }
    public void challenge(View view){
        Intent intent = new Intent(this,ChallengeMenu.class);
        startActivity(intent);
    }
    public void settings(View view){
        Intent intent = new Intent(this,SettingsPage.class);
        startActivity(intent);
    }
}
