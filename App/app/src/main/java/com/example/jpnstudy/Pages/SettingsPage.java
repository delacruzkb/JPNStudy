package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.jpnstudy.R;

public class SettingsPage extends AppCompatActivity {
    //TODO: make a settings page, clear/init, edit, and add
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
    }

    public void addNewTerm(View view)
    {
        //TODO: addNewTerm
    }

    public void editRemoveTerm(View view)
    {
        //TODO: editRemoveTerm
    }

    public void defaultDatabase(View view)
    {
        //TODO: defaultDatabase
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to revert to the default dataset?")
                .setTitle("Warining")
                .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO: clear then implement
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
    }

    public void clearDatabase(View view)
    {
        //TODO: clearDatabas
    }
}
